package com.wanztudio.mvp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import com.wanztudio.mvp.di.ActivityContext;
import com.wanztudio.mvp.di.ApplicationContext;
import com.wanztudio.mvp.di.PerActivity;
import com.wanztudio.mvp.ui.custom.LinearLayoutSmoothScroller;
import com.wanztudio.mvp.ui.login.LoginMvpPresenter;
import com.wanztudio.mvp.ui.login.LoginMvpView;
import com.wanztudio.mvp.ui.login.LoginPresenter;
import com.wanztudio.mvp.ui.main.MainMvpPresenter;
import com.wanztudio.mvp.ui.main.MainMvpView;
import com.wanztudio.mvp.ui.main.MainPresenter;
import com.wanztudio.mvp.ui.main.dialog.MainDialogMvpPresenter;
import com.wanztudio.mvp.ui.main.dialog.MainDialogMvpView;
import com.wanztudio.mvp.ui.main.dialog.MainDialogPresenter;
import com.wanztudio.mvp.ui.main.fragment.MainFragmentMvpPresenter;
import com.wanztudio.mvp.ui.main.fragment.MainFragmentMvpView;
import com.wanztudio.mvp.ui.main.fragment.MainFragmentPresenter;
import com.wanztudio.mvp.ui.register.RegisterMvpPresenter;
import com.wanztudio.mvp.ui.register.RegisterMvpView;
import com.wanztudio.mvp.ui.register.RegisterPresenter;
import com.wanztudio.mvp.ui.splash.SplashMvpPresenter;
import com.wanztudio.mvp.ui.splash.SplashMvpView;
import com.wanztudio.mvp.ui.splash.SplashPresenter;
import com.wanztudio.mvp.utils.rx.AppSchedulerProvider;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    LinearLayoutSmoothScroller provideLinearLayoutSmoothScroller(AppCompatActivity activity) {
        return new LinearLayoutSmoothScroller(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RegisterMvpPresenter<RegisterMvpView> provideRegisterPresenter(
            RegisterPresenter<RegisterMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainFragmentMvpPresenter<MainFragmentMvpView> provideMainFragmentPresenter(
            MainFragmentPresenter<MainFragmentMvpView> presenter) {
        return presenter;
    }

    @Provides
    MainDialogMvpPresenter<MainDialogMvpView> provideMainDialogPresenter(
            MainDialogPresenter<MainDialogMvpView> presenter) {
        return presenter;
    }
}
