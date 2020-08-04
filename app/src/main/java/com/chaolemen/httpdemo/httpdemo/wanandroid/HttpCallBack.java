package com.chaolemen.httpdemo.httpdemo.wanandroid;

import android.util.Log;

import com.chaolemen.httplibrary.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;


public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    WanResponse wanResponse;
    @Override
    protected T onConvert(String result) {
        T t=null;
        wanResponse = new Gson().fromJson(result, WanResponse.class);
        JsonElement data = wanResponse.getData();
        int errorCode = wanResponse.getErrorCode();
        String errorMsg = wanResponse.getErrorMsg();
        switch (errorCode) {
            case -1001:
                onError("登录失效",errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("liangxq", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (wanResponse != null) {
            return wanResponse.getErrorCode() == 0;
        }
        return false;
    }

}
