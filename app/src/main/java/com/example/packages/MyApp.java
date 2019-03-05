package com.example.packages;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

/**
 * MyApp
 * Create By 樱桃 on 2019/3/5 16:36
 */
public class MyApp extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "591014");
    }
}
