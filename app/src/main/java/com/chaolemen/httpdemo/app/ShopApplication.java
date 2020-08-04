package com.chaolemen.httpdemo.app;

import android.app.Application;

import com.chaolemen.httplibrary.HttpConstant;
import com.chaolemen.httplibrary.HttpGlobalConfig;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;


public class ShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInsance()
                .setBaseUrl("http://api.t.ergedd.com/")
//                .setBaseUrl("https://www.wanandroid.com/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
    }
}
