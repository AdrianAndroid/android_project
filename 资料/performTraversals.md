
# requestLayout和invalidate区别
https://blog.csdn.net/hxl517116279/article/details/90410345

    private void performTraversals() {
        boolean windowShouldResize = layoutRequested;

        // performMeasure
        if (windowShouldResize) {
            if (!mStopped || wasReportNextDraw) {
                boolean focusChangedDueToTouchMode = ensureTouchModeLocally((relayoutResult&WindowManagerGlobal.RELAYOUT_RES_IN_TOUCH_MODE) != 0);
                if (focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight() || dispatchApplyInsets || updatedConfiguration) {
                    performMeasure(childWidthMeasureSpec, childHeightMeasureSpec);

                    ...
                    boolean measureAgain = false;
                    ...

                    if (measureAgain) {
                        performMeasure(childWidthMeasureSpec, childHeightMeasureSpec);
                    }

                    layoutRequested = true;
                }
            }
        }

        final boolean didLayout = layoutRequested && (!mStopped || wasReportNextDraw);

        // performLayout
        if (didLayout) {
            performLayout(lp, mWidth, mHeight);
        }

        // Remember if we must report the next draw.

        if ((relayoutResult & WindowManagerGlobal.RELAYOUT_RES_FIRST_TIME) != 0) {
            reportNextDraw();
        }

        boolean cancelDraw = mAttachInfo.mTreeObserver.dispatchOnPreDraw() || !isViewVisible;

        if (!cancelDraw) {
            performDraw();
        } else {
            if (isViewVisible) {
                // Try again
                scheduleTraversals();
            } else {
                ...
            }
        }
        mIsInTraversal = false;
    }
