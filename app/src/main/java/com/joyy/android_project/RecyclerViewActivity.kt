package com.joyy.android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * 资料：
 * RecyclerView源码分析
 * https://blog.csdn.net/Barryjacket/article/details/119138240
 */
class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView = findViewById(R.id.mRecyclerView)

        findViewById<View>(R.id.nomral).setOnClickListener {
            initRecyclerView()
        }
    }

    fun test() {
        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun initRecyclerView() {

        recyclerView.layoutManager =
                LinearLayoutManager(
                        applicationContext,
                        LinearLayoutManager.VERTICAL,
                        false
                ) // requestLayout()
        recyclerView.adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
            ): RecyclerView.ViewHolder {
                val itemView = LayoutInflater.from(parent.context)
                        .inflate(android.R.layout.simple_expandable_list_item_1, parent, false)
                return object : RecyclerView.ViewHolder(itemView) {
                }
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                holder.itemView.findViewById<TextView>(android.R.id.text1).apply {
                    text = "Hello World"
                    textSize = 18F
                }
            }

            override fun getItemCount(): Int {
                return 1000
            }
        } // requestLayout

        recyclerView.adapter?.registerAdapterDataObserver(adapterDataObserver)
        recyclerView.setRecyclerListener(object : RecyclerView.RecyclerListener {
            override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
                // 要回收的ViewHolder
            }
        })
        recyclerView.adapter?.notifyDataSetChanged()
        recyclerView.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewAttachedToWindow(view: View) {
            }

            override fun onChildViewDetachedFromWindow(view: View) {
            }
        })
    }


    val adapterDataObserver = object :
            RecyclerView.AdapterDataObserver() {

    }

    override fun onDestroy() {
        super.onDestroy()
        recyclerView.adapter?.unregisterAdapterDataObserver(adapterDataObserver)
    }


}