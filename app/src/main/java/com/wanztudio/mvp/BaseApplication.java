package com.wanztudio.mvp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import com.wanztudio.mvp.di.component.ApplicationComponent;
import com.wanztudio.mvp.di.component.DaggerApplicationComponent;
import com.wanztudio.mvp.di.module.ApplicationModule;
import com.wanztudio.mvp.utils.AppLogger;
import io.fabric.sdk.android.Fabric;
import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class BaseApplication extends Application {

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
       
        AppLogger.getInstance().init(this);

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(mCalligraphyConfig))
                .build());
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
