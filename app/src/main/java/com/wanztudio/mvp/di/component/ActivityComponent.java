package com.wanztudio.mvp.di.component;

import dagger.Component;
import com.wanztudio.mvp.di.PerActivity;
import com.wanztudio.mvp.di.module.ActivityModule;
import com.wanztudio.mvp.ui.login.LoginActivity;
import com.wanztudio.mvp.ui.main.MainActivity;
import com.wanztudio.mvp.ui.main.dialog.MainDialog;
import com.wanztudio.mvp.ui.main.fragment.MainFragment;
import com.wanztudio.mvp.ui.register.RegisterActivity;
import com.wanztudio.mvp.ui.splash.SplashActivity;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    // Activity
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(RegisterActivity activity);
    void inject(MainActivity activity);

    // Fragment
    void inject(MainFragment fragment);

    //Dialog
    void inject(MainDialog dialog);

}