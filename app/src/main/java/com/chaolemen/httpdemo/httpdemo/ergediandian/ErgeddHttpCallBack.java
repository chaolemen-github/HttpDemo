package com.chaolemen.httpdemo.httpdemo.ergediandian;

import android.util.Log;

import com.chaolemen.httpdemo.httpdemo.wanandroid.WanResponse;
import com.chaolemen.httplibrary.callback.BaseCallBack;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class ErgeddHttpCallBack<T> extends BaseCallBack<T> {
    ErgeddResponse ergeddResponse;
    @Override
    protected T onConvert(String result) {
        T t=null;
//        ergeddResponse = new Gson().fromJson(new Gson().toJson(result), ErgeddResponse.class);
        ergeddResponse = new Gson().fromJson(result, ErgeddResponse.class);
//        ergeddResponse = JsonUtils.jsonToClassList()
        JsonElement data = ergeddResponse.getRecord();
        int errorCode = ergeddResponse.getStatus();
        ErgeddResponse.MessagesBean messages = ergeddResponse.getMessages();
        switch (errorCode) {
            case -1:
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
        if (ergeddResponse != null) {
            return ergeddResponse.getStatus() == 200;
        }
        return false;
    }

}
