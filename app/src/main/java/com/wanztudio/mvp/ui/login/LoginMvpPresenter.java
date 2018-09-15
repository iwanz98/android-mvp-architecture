package com.wanztudio.mvp.ui.login;

import com.wanztudio.mvp.data.network.model.LoginRequest;
import com.wanztudio.mvp.di.PerActivity;
import com.wanztudio.mvp.ui.base.MvpPresenter;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {
    void sendDataLogin(LoginRequest request);
}
