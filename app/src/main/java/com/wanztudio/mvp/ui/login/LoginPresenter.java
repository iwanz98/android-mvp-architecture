package com.wanztudio.mvp.ui.login;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.data.network.model.LoginRequest;
import com.wanztudio.mvp.data.network.model.LoginResponse;
import com.wanztudio.mvp.ui.base.BasePresenter;
import com.wanztudio.mvp.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void sendDataLogin(LoginRequest request) {
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doLoginApiCall(request)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        if (!isViewAttached()) {
                            return;

                        }

                        getMvpView().hideLoading();

                        getDataManager().updateUserInfo(response.getCustomer(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER);

                        getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        throwable.printStackTrace();

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}