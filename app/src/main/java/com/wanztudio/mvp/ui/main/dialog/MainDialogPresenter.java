package com.wanztudio.mvp.ui.main.dialog;

import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.ui.base.BasePresenter;
import com.wanztudio.mvp.ui.base.MvpPresenter;
import com.wanztudio.mvp.ui.base.MvpView;
import com.wanztudio.mvp.ui.main.fragment.MainFragmentMvpPresenter;
import com.wanztudio.mvp.ui.main.fragment.MainFragmentMvpView;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class MainDialogPresenter<V extends MainDialogMvpView> extends BasePresenter<V> implements MainDialogMvpPresenter<V> {

    @Inject
    public MainDialogPresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}

