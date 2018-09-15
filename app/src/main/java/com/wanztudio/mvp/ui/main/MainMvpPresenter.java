package com.wanztudio.mvp.ui.main;

import com.wanztudio.mvp.di.PerActivity;
import com.wanztudio.mvp.ui.base.MvpPresenter;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {
}
