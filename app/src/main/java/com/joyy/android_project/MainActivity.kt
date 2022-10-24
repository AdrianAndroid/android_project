package com.joyy.android_project

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewCacheExtension

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DemoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = DemoAdapter()
        recyclerView.adapter = adapter

        //viewType类型为TYPE_SPECIAL时，设置四级缓存池RecyclerPool不存储对应类型的数据 因为需要开发者自行缓存
        recyclerView.recycledViewPool.setMaxRecycledViews(DemoAdapter.TYPE_SPECIAL, 0)
        //设置ViewCacheExtension缓存
        recyclerView.setViewCacheExtension(MyExtension())
    }

    inner class MyExtension : ViewCacheExtension() {
        override fun getViewForPositionAndType(
            recycler: Recycler,
            position: Int,
            viewType: Int
        ): View? {
            //如果viewType为TYPE_SPECIAL,使用自己缓存的View去构建ViewHolder
            // 否则返回null，会使用系统RecyclerPool缓存或者从新通过onCreateViewHolder构建View及ViewHolder
            return if (viewType == DemoAdapter.TYPE_SPECIAL) adapter.caches.get(position) else null
        }
    }

}