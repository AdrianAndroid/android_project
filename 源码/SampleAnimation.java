public class SampleAnimation {
    // Choreographer是线程唯一的。通过getInstance()后去当前线程的实例
    Choreographer mChoreographer = Choreographer.getInstance();
    // 一个Animation
    Animation mAnimation = null;

    // 保存需要运行的动画，并通过ScheduleNextFrame准备执行第一帧
    public synchronized void startAnime(Animation anim) {
        mAnimation = anim;
        scheduleNextFrame();
    }

    //将负责执行渲染的mAnimationRunnable抛给Choreographer
    private void scheduleNextFrame() {
        mChoreographer.postCallback(Choreographer.CALLBAC_ANIMATION, mAnimation, null);
    }

    // 这个Runnable实现了如何渲染一帧
    Runnable mAnnimationRunnable = new Runnable() {
        public void run() {
            // 从这里正式开始渲染动画
            if (mAnimation != null) {
                // 获取当前时间
                long time = SystemClock.uptimeMillis();
                // 新建一个Transformation用以保存Animation的变换计算结果
                Transformation transform = new Transformation();
                // 计算出Transformation，返回值more表示动画是否需要继续执行
                boolean more = mAnimation.getTransformation(time, transform);
                // 使用Animation计算出的Tranformation进行渲染
                PERFORM_RENDER_WITH_TRANSFORMATION(transform);
                // 如果mAnimation表示动画尚未结束，则向Choreographer申请处理下一帧
                // 否则清空mAnimation并不再向Choreographer发送请求
                if(more) {
                    scheduleNextFrame();
                } else {
                    mAnimation = null;
                }
            }
        }
    }
}