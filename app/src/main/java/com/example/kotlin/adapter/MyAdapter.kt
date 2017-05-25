package com.example.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kotlin.MyApplication
import com.example.kotlin.R
import com.example.kotlin.bean.Banner
import com.example.kotlin.util.OnItemClick

/**
 * 作者：Tangren on 2017/5/22 12:45
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
class MyAdapter : RecyclerView.Adapter<MyHolder>() {

    var list: List<Banner> = ArrayList<Banner>()

    var click: OnItemClick? = null

    fun add(list: List<Banner>) {
        this.list = list
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        if (holder != null) {
            holder.textView.text = list!![position].name
            Glide.with(MyApplication.getInstance())
                    .load(list[position].imgUrl)
                    .centerCrop()
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.img)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_holder_view, parent, false)
        val holder = MyHolder(view, click!!)
        return holder
    }


    fun setItemClick(click: OnItemClick) {
        this.click = click
    }

}