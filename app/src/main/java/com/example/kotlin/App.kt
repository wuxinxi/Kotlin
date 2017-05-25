package com.example.kotlin

import android.app.Application

/**
 * 作者：Tangren on 2017/5/23 17:46
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
class App private constructor() : Application() {

    private @Volatile var instance: App? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            App()
        }
    }

    fun getInstance(): App {
        if (instance == null) {
            synchronized(this) {
                instance = App()
            }
        }
        return instance!!
    }

}