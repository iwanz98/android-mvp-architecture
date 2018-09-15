package com.wanztudio.mvp.di.component;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.wanztudio.mvp.BaseApplication;
import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.di.ApplicationContext;
import com.wanztudio.mvp.di.module.ApplicationModule;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}
