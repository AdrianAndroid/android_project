/**

* Attempts to get the ViewHolder for the given position, either from the Recycler scrap,
* cache, the RecycledViewPool, or creating it directly.
* <p>
* If a deadlineNs other than {@link #FOREVER_NS} is passed, this method early return
* rather than constructing or binding a ViewHolder if it doesn't think it has time.
* If a ViewHolder must be constructed and not enough time remains, null is returned. If a
* ViewHolder is aquired and must be bound but not enough time remains, an unbound holder is
* returned. Use {@link ViewHolder#isBound()} on the returned object to check for this.
*
* @param position Position of ViewHolder to be returned.
* @param dryRun True if the ViewHolder should not be removed from scrap/cache/
* @param deadlineNs Time, relative to getNanoTime(), by which bind/create work should
*                   complete. If FOREVER_NS is passed, this method will not fail to
*                   create/bind the holder if needed.
* @return ViewHolder for requested position
  */ @Nullable ViewHolder tryGetViewHolderForPositionByDeadline(int position, boolean dryRun, long
  deadlineNs) { if (position < 0 || position >= mState.getItemCount()) { throw new
  IndexOutOfBoundsException("Invalid item position " + position + "(" + position + "). Item count:"
  + mState.getItemCount() + exceptionLabel()); } boolean fromScrapOrHiddenOrCache = false;
  ViewHolder holder = null; // 0) If there is a changed scrap, try to find from there if (
  mState.isPreLayout()) { holder = getChangedScrapViewForPosition(position);
  fromScrapOrHiddenOrCache = holder != null; } // 1) Find by position from scrap/hidden list/cache
  if (holder == null) { holder = getScrapOrHiddenOrCachedHolderForPosition(position, dryRun); if (
  holder != null) { if (!validateViewHolderForOffsetPosition(holder)) { // recycle holder (and
  unscrap if relevant) since it can't be used if (!dryRun) { // we would like to recycle this but
  need to make sure it is not used by // animation logic etc. holder.addFlags(
  ViewHolder.FLAG_INVALID); if (holder.isScrap()) { removeDetachedView(holder.itemView, false);
  holder.unScrap(); } else if (holder.wasReturnedFromScrap()) { holder.clearReturnedFromScrapFlag();
  } recycleViewHolderInternal(holder); } holder = null; } else { fromScrapOrHiddenOrCache = true; }
  } } if (holder == null) { final int offsetPosition = mAdapterHelper.findPositionOffset(position);
  if (offsetPosition < 0 || offsetPosition >= mAdapter.getItemCount()) { throw new
  IndexOutOfBoundsException("Inconsistency detected. Invalid item " + "position " + position

+ "(offset:" + offsetPosition + ")." + "state:" + mState.getItemCount() + exceptionLabel()); }

                final int type = mAdapter.getItemViewType(offsetPosition);
                // 2) Find from scrap/cache via stable ids, if exists
                if (mAdapter.hasStableIds()) {
                    holder = getScrapOrCachedViewForId(mAdapter.getItemId(offsetPosition), type, dryRun);
                    if (holder != null) {
                        // update position
                        holder.mPosition = offsetPosition;
                        fromScrapOrHiddenOrCache = true;
                    }
                }
                if (holder == null && mViewCacheExtension != null) {
                    // We are NOT sending the offsetPosition because LayoutManager does not
                    // know it.
                    final View view = mViewCacheExtension.getViewForPositionAndType(this, position, type);
                    if (view != null) {
                        holder = getChildViewHolder(view);
                        if (holder == null) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned" + " a view which does not have a ViewHolder" + exceptionLabel());
                        } else if (holder.shouldIgnore()) {
                            throw new IllegalArgumentException("getViewForPositionAndType returned" + " a view that is ignored. You must call stopIgnoring before" + " returning this view." + exceptionLabel());
                        }
                    }
                }
                if (holder == null) { // fallback to pool
                    if (DEBUG) {
                        Log.d(TAG, "tryGetViewHolderForPositionByDeadline(" + position + ") fetching from shared pool");
                    }
                    holder = getRecycledViewPool().getRecycledView(type);
                    if (holder != null) {
                        holder.resetInternal();
                        if (FORCE_INVALIDATE_DISPLAY_LIST) {
                            invalidateDisplayListInt(holder);
                        }
                    }
                }
                if (holder == null) {
                    long start = getNanoTime();
                    if (deadlineNs != FOREVER_NS && !mRecyclerPool.willCreateInTime(type, start, deadlineNs)) {
                        // abort - we have a deadline we can't meet
                        return null;
                    }
                    holder = mAdapter.createViewHolder(RecyclerView.this, type);
                    if (ALLOW_THREAD_GAP_WORK) {
                        // only bother finding nested RV if prefetching
                        RecyclerView innerView = findNestedRecyclerView(holder.itemView);
                        if (innerView != null) {
                            holder.mNestedRecyclerView = new WeakReference<>(innerView);
                        }
                    }

                    long end = getNanoTime();
                    mRecyclerPool.factorInCreateTime(type, end - start);
                    if (DEBUG) {
                        Log.d(TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
                    }
                }
            }

            // This is very ugly but the only place we can grab this information
            // before the View is rebound and returned to the LayoutManager for post layout ops.
            // We don't need this in pre-layout since the VH is not updated by the LM.
            if (fromScrapOrHiddenOrCache && !mState.isPreLayout() && holder.hasAnyOfTheFlags(ViewHolder.FLAG_BOUNCED_FROM_HIDDEN_LIST)) {
                holder.setFlags(0, ViewHolder.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                if (mState.mRunSimpleAnimations) {
                    int changeFlags = ItemAnimator.buildAdapterChangeFlagsForAnimations(holder);
                    changeFlags |= ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
                    final ItemAnimator.ItemHolderInfo info = mItemAnimator.recordPreLayoutInformation(mState, holder, changeFlags, holder.getUnmodifiedPayloads());
                    recordAnimationInfoIfBouncedHiddenView(holder, info);
                }
            }

            boolean bound = false;
            if (mState.isPreLayout() && holder.isBound()) {
                // do not update unless we absolutely have to.
                holder.mPreLayoutPosition = position;
            } else if (!holder.isBound() || holder.needsUpdate() || holder.isInvalid()) {
                if (DEBUG && holder.isRemoved()) {
                    throw new IllegalStateException("Removed holder should be bound and it should" + " come here only in pre-layout. Holder: " + holder + exceptionLabel());
                }
                final int offsetPosition = mAdapterHelper.findPositionOffset(position);
                bound = tryBindViewHolderByDeadline(holder, offsetPosition, position, deadlineNs);
            }

            final ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            final LayoutParams rvLayoutParams;
            if (lp == null) {
                rvLayoutParams = (LayoutParams) generateDefaultLayoutParams();
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else if (!checkLayoutParams(lp)) {
                rvLayoutParams = (LayoutParams) generateLayoutParams(lp);
                holder.itemView.setLayoutParams(rvLayoutParams);
            } else {
                rvLayoutParams = (LayoutParams) lp;
            }
            rvLayoutParams.mViewHolder = holder;
            rvLayoutParams.mPendingInvalidate = fromScrapOrHiddenOrCache && bound;
            return holder;
        }
