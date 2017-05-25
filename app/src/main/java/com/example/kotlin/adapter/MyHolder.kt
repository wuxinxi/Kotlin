package com.example.kotlin.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin.R
import com.example.kotlin.util.OnItemClick

/**
 * 作者：Tangren on 2017/5/22 12:46
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
class MyHolder(itemView: android.view.View, click: OnItemClick) : android.support.v7.widget.RecyclerView.ViewHolder(itemView), android.view.View.OnClickListener {

    var textView: TextView

    var img: ImageView

    private var click: OnItemClick? = null

    init {
        textView = itemView.findViewOften(R.id.textView)
        img = itemView.findViewOften(R.id.img)
        this.click = click
        itemView.setOnClickListener(this)
    }


    fun <T : android.view.View> android.view.View.findViewOften(viewId: Int): T {
        var viewHolder: android.util.SparseArray<View> = tag as? android.util.SparseArray<View> ?: android.util.SparseArray()
        tag = viewHolder
        var childView: android.view.View? = viewHolder.get(viewId)
        if (null == childView) {
            childView = findViewById(viewId)
            viewHolder.put(viewId, childView)
        }
        return childView as T
    }

    override fun onClick(v: android.view.View?) {
        if (v != null) {
            click!!.onItemClick(v, adapterPosition)
        }
    }

}
