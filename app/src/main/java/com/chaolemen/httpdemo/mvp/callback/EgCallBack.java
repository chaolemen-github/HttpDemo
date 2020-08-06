package com.chaolemen.httpdemo.mvp.callback;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoEGGet;

public interface EgCallBack {
    void onSuccess(DemoEGGet demoEGGet);
    void onFail(String error);
}
