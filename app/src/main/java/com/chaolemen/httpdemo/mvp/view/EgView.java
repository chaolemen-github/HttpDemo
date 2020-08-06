package com.chaolemen.httpdemo.mvp.view;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoEGGet;
import com.chaolemen.mvplibrary.view.BaseView;

public interface EgView extends BaseView {
    void onSuccess(DemoEGGet demoEGGet);
    void onFail(String error);
}
