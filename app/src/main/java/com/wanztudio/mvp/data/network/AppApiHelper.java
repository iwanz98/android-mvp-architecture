package com.wanztudio.mvp.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.wanztudio.mvp.data.network.model.LoginRequest;
import com.wanztudio.mvp.data.network.model.LoginResponse;
import io.reactivex.Observable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
public class AppApiHelper implements com.wanztudio.mvp.data.network.ApiHelper {

    private com.wanztudio.mvp.data.network.ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(com.wanztudio.mvp.data.network.ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public com.wanztudio.mvp.data.network.ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<LoginResponse> doLoginApiCall(LoginRequest request) {
        return Rx2AndroidNetworking.post(com.wanztudio.mvp.data.network.ApiEndPoint.LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }
}

