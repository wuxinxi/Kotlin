package com.example.kotlin;

import android.app.Application;

/**
 * 作者：Tangren on 2017/5/24 18:55
 * 邮箱：wu_tangren@163.com
 * TODO:一句话描述
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        if (instance == null)
            instance = new MyApplication();
        return instance;
    }
}
