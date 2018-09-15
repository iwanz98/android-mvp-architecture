package com.wanztudio.mvp.ui.main.fragment;

import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.ui.base.BasePresenter;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class MainFragmentPresenter<V extends MainFragmentMvpView> extends BasePresenter<V> implements MainFragmentMvpPresenter<V> {

    @Inject
    public MainFragmentPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
