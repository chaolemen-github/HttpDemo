package com.chaolemen.httpdemo.mvp.model;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoEGGet;
import com.chaolemen.httpdemo.httpdemo.ergediandian.ErgeddHttpCallBack;
import com.chaolemen.httpdemo.mvp.callback.EgCallBack;
import com.chaolemen.httpdemo.mvp.presenter.EgPresenter;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.model.BaseModel;
import com.google.gson.JsonElement;

import java.util.HashMap;

public class EgModel implements BaseModel {

    public void getData(final EgCallBack egCallBack) {
//请求参数
        HashMap<String, Object> map = new HashMap<>();
        map.put("limit", 100);

        //请求头
        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("Cache-Control", "public");
        headerMap.put("max-age", "28800");
        new HttpClient.Builder()
                .setApiUrl("getVideoSearchKeyword")
                .post()
                .setJsonBody("", false)
                .setParamser(map)
                .setHeadres(headerMap)
                .build()
                .request(new ErgeddHttpCallBack<DemoEGGet>() {
                    @Override
                    public void onError(String message, int code) {
//                        LogUtils.e(code + message);
                        egCallBack.onFail(code + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(DemoEGGet demoEGGet) {
//                        LogUtils.e(demoEGGet.toString());
                        egCallBack.onSuccess(demoEGGet);
                    }

                    @Override
                    public DemoEGGet convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, DemoEGGet.class);
                    }
                });
    }
}
