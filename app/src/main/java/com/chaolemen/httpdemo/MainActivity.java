package com.chaolemen.httpdemo;

import android.os.Bundle;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoErgedd;
import com.chaolemen.httpdemo.httpdemo.ergediandian.ErgeddHttpCallBack;
import com.chaolemen.httpdemo.httpdemo.wanandroid.Demo;
import com.chaolemen.httpdemo.httpdemo.wanandroid.DemoPost;
import com.chaolemen.httpdemo.httpdemo.wanandroid.HttpCallBack;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initGet();
//        initPost();
        initErgedd();
    }

    private void initErgedd() {
        new HttpClient.Builder()
                .setApiUrl("getUpgrade")
                .post()
                .setJsonBody("",false)
                .setParamser(new HashMap<String, Object>())
                .build()
                .request(new ErgeddHttpCallBack<List<DemoErgedd>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(code+message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<DemoErgedd> demoErgedds) {
                        LogUtils.e(demoErgedds.toString());
                    }

                    @Override
                    public List<DemoErgedd> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result,DemoErgedd.class);
                    }
                });
    }

    private void initPost() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","朝乐门");
        map.put("password","111111");

        new HttpClient.Builder()
                .post()
                .setApiUrl("user/login")
                .setJsonBody("",false)
                .setParamser(map)
                .build()
                .request(new HttpCallBack<DemoPost>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(code+message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(DemoPost demoPost) {
                        LogUtils.e(demoPost.toString());
                    }

                    @Override
                    public DemoPost convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result,DemoPost.class);
                    }
                });
    }

    private void initGet() {
        new HttpClient.Builder()
                .setApiUrl("wxarticle/list/408/1/json")
                .get()
                .build().request(new HttpCallBack<Demo>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message);
            }
            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(Demo demo) {
              LogUtils.e(demo.toString());
            }

            @Override
            public Demo convert(JsonElement result) {
                return new Gson().fromJson(result,Demo.class);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
