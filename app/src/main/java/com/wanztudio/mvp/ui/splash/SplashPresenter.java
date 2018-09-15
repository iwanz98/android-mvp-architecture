package com.wanztudio.mvp.ui.splash;

import android.os.Handler;

import javax.inject.Inject;

import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.ui.base.BasePresenter;
import com.wanztudio.mvp.utils.AppLogger;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void decidedNextActivity() {
        new Handler().postDelayed(() -> {
            if (getDataManager().getCurrentUserLoggedInMode()
                    == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
                getMvpView().openLoginActivity();
                AppLogger.i("GO-LOGIN");
            } else {
                getMvpView().openMainActivity();
                AppLogger.i("GO-MAIN");
            }
        }, 3*1000); // wait for 3 seconds
    }
}