package com.wanztudio.mvp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import com.wanztudio.mvp.BaseApplication;
import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.di.component.DaggerServiceComponent;
import com.wanztudio.mvp.di.component.ServiceComponent;
import com.wanztudio.mvp.di.module.ServiceModule;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class BaseService extends Service {

    private static final String TAG = "BaseService";

    private ServiceComponent mServiceComponent;

    @Inject
    DataManager mDataManager;

    @Inject
    SchedulerProvider mSchedulerProvider;

    @Inject
    CompositeDisposable mCompositeDisposable;

    @Override
    public void onCreate() {
        super.onCreate();

        mServiceComponent = DaggerServiceComponent.builder()
                .serviceModule(new ServiceModule(this))
                .applicationComponent(((BaseApplication) getApplication()).getComponent())
                .build();
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public ServiceComponent getServiceComponent() {
        return mServiceComponent;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
