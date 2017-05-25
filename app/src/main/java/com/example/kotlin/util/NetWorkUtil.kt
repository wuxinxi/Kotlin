package com.example.kotlin.util

import android.content.Context
import android.net.ConnectivityManager
import com.example.kotlin.MyApplication

/**
 * 作者：Tangren on 2017/5/24 13:40
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
class NetWorkUtil {
    companion object {
        fun isNetWorkConnected(): Boolean {
            val cm = MyApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val currentNet = cm.activeNetworkInfo ?: return false
            return currentNet.isAvailable
        }
    }

}