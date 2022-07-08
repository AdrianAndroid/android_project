package com.joyy.android_project

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * https://www.jianshu.com/p/ee1342fcf5e7
 */
class MainActivity : AppCompatActivity() {
    var mTask: MyTask? = null

    var button: Button? = null
    var cancel: Button? = null
    var text: TextView? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button = findViewById<View>(R.id.button) as Button
        cancel = findViewById<View>(R.id.cancel) as Button
        text = findViewById<View>(R.id.text) as TextView
        progressBar = findViewById<View>(R.id.progress_bar) as ProgressBar

        /**
         * 步骤2：创建AsyncTask子类的实例对象（即 任务实例）
         * 注：AsyncTask子类的实例必须在UI线程中创建
         */
        /**
         * 步骤2：创建AsyncTask子类的实例对象（即 任务实例）
         * 注：AsyncTask子类的实例必须在UI线程中创建
         */
        mTask = MyTask()

        // 加载按钮按按下时，则启动AsyncTask
        // 任务完成后更新TextView的文本

        // 加载按钮按按下时，则启动AsyncTask
        // 任务完成后更新TextView的文本
        button?.setOnClickListener {
            /**
             * 步骤3：手动调用execute(Params... params) 从而执行异步线程任务
             * 注：
             * a. 必须在UI线程中调用
             * b. 同一个AsyncTask实例对象只能执行1次，若执行第2次将会抛出异常
             * c. 执行任务中，系统会自动调用AsyncTask的一系列方法：onPreExecute() 、doInBackground()、onProgressUpdate() 、onPostExecute()
             * d. 不能手动调用上述方法
             */
            mTask!!.execute()
        }
        cancel = findViewById<View>(R.id.cancel) as Button
        cancel?.setOnClickListener {
            // 取消一个正在执行的任务,onCancelled方法将会被调用
            mTask!!.cancel(true)
        }
    }

    /**
     * 步骤1：创建AsyncTask子类
     * 注：
     * a. 继承AsyncTask类
     * b. 为3个泛型参数指定类型；若不使用，可用java.lang.Void类型代替
     * 此处指定为：输入参数 = String类型、执行进度 = Integer类型、执行结果 = String类型
     * c. 根据需求，在AsyncTask子类内实现核心方法
     */
    inner class MyTask : AsyncTask<String?, Int?, String?>() {
        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        override fun onPreExecute() {
            text?.text = "加载中"
            // 执行前显示提示
        }

        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
        override fun doInBackground(vararg params: String?): String? {
            try {
                var count = 0
                val length = 1
                while (count < 99) {
                    count += length
                    // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
                    publishProgress(count)
                    // 模拟耗时任务
                    Thread.sleep(50)
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            return null
        }

        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        override fun onProgressUpdate(vararg progresses: Int?) {
            progressBar?.progress = progresses[0] ?: 0
            text?.text = "loading..." + progresses[0] + "%"
        }

        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        override fun onPostExecute(result: String?) {
            // 执行完毕后，则更新UI
            text?.setText("加载完毕")
        }

        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
        override fun onCancelled() {
            text?.setText("已取消")
            progressBar?.setProgress(0)
        }
    }
}