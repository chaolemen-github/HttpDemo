package com.chaolemen.httpdemo;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoEGGet;
import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoErgedd;
import com.chaolemen.httpdemo.httpdemo.ergediandian.ErgeddHttpCallBack;
import com.chaolemen.httpdemo.httpdemo.wanandroid.Demo;
import com.chaolemen.httpdemo.httpdemo.wanandroid.DemoPost;
import com.chaolemen.httpdemo.httpdemo.wanandroid.HttpCallBack;
import com.chaolemen.httpdemo.mvp.presenter.EgPresenter;
import com.chaolemen.httpdemo.mvp.view.EgView;
import com.chaolemen.httplibrary.client.HttpClient;
import com.chaolemen.httplibrary.utils.JsonUtils;
import com.chaolemen.httplibrary.utils.LogUtils;
import com.chaolemen.mvplibrary.base.BaseMvpActivity;
import com.chaolemen.mvplibrary.presenter.BasePresenter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseMvpActivity<EgView, EgPresenter> implements EgView {
    @Override
    public void onSuccess(DemoEGGet demoEGGet) {
        LogUtils.e("111"+demoEGGet.toString());
    }

    @Override
    public void onFail(String error) {
        LogUtils.e("111"+error);
    }

    @Override
    protected EgPresenter initPresenter() {
        mPresenter = new EgPresenter();
        return mPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    private void initErgeddGetAlbum() {
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
                        LogUtils.e(code + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(DemoEGGet demoEGGet) {
                        LogUtils.e(demoEGGet.toString());
                    }

                    @Override
                    public DemoEGGet convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, DemoEGGet.class);
                    }
                });
    }

    private void initErgedd() {
        new HttpClient.Builder()
                .setApiUrl("getUpgrade")
                .post()
                .setJsonBody("", false)
                .setParamser(new HashMap<String, Object>())
                .build()
                .request(new ErgeddHttpCallBack<List<DemoErgedd>>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(code + message);
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
                        return JsonUtils.jsonToClassList(result, DemoErgedd.class);
                    }
                });
    }

    private void initPost() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "朝乐门");
        map.put("password", "111111");

        new HttpClient.Builder()
                .post()
                .setApiUrl("user/login")
                .setJsonBody("", false)
                .setParamser(map)
                .build()
                .request(new HttpCallBack<DemoPost>() {
                    @Override
                    public void onError(String message, int code) {
                        LogUtils.e(code + message);
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
                        return JsonUtils.jsonToClass(result, DemoPost.class);
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
                return new Gson().fromJson(result, Demo.class);
            }
        });
    }


}
