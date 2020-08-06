package com.chaolemen.httpdemo.mvp.presenter;

import com.chaolemen.httpdemo.httpdemo.ergediandian.DemoEGGet;
import com.chaolemen.httpdemo.mvp.callback.EgCallBack;
import com.chaolemen.httpdemo.mvp.model.EgModel;
import com.chaolemen.httpdemo.mvp.view.EgView;
import com.chaolemen.mvplibrary.model.ModelFractory;
import com.chaolemen.mvplibrary.presenter.BasePresenter;
import com.trello.rxlifecycle2.LifecycleProvider;

public class EgPresenter extends BasePresenter<EgView> implements EgCallBack {

    public void getData() {
        //创建model对象
        EgModel model = ModelFractory.createModel(EgModel.class);
        //调用model方法
        model.getData(this);
    }

    @Override
    public void onSuccess(DemoEGGet demoEGGet) {
        mView.onSuccess(demoEGGet);
    }

    @Override
    public void onFail(String error) {
        mView.onFail(error);
    }

}
