package com.wanztudio.mvp.ui.splash;

import com.wanztudio.mvp.di.PerActivity;
import com.wanztudio.mvp.ui.base.MvpPresenter;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {
    void decidedNextActivity();
}
