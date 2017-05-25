package com.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.kotlin.adapter.MyAdapter
import com.example.kotlin.bean.Banner
import com.example.kotlin.http.RetrofitManager
import com.example.kotlin.util.OnItemClick
import kotlinx.android.synthetic.main.activity_main2.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity(), OnItemClick {

    private var data = ArrayList<Banner>()
    private var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        adapter = MyAdapter()
        getBanner()
        val manager = LinearLayoutManager(application)
        recyclerView.layoutManager = manager
        adapter!!.setItemClick(this)

    }

    fun getBanner() {
        RetrofitManager.builder("http://112.124.22.238:8081")
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { println("call…………………………") }
                .subscribe({ ban ->
                    println(ban.toString())
                    adapter!!.add(ban)
                    recyclerView.adapter = adapter

                }) { throwable -> println(throwable.message) }

    }

    override fun onItemClick(view: View, postion: Int) {
        Toast.makeText(applicationContext, "我是第" + postion + "个", Toast.LENGTH_SHORT).show()
    }


}
