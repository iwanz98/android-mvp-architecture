package com.wanztudio.mvp.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.wanztudio.mvp.data.db.DbHelper;
import com.wanztudio.mvp.data.network.ApiHeader;
import com.wanztudio.mvp.data.network.ApiHelper;
import com.wanztudio.mvp.data.network.model.LoginRequest;
import com.wanztudio.mvp.data.network.model.LoginResponse;
import com.wanztudio.mvp.data.prefs.PreferencesHelper;
import com.wanztudio.mvp.di.ApplicationContext;
import io.reactivex.Observable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    // DatabaseHelper


    // PreferencesHelper

    @Override
    public int getCurrentUserLoggedInMode() {
            if (mPreferencesHelper.getCurrentUserLoggedInMode() == LoggedInMode.LOGGED_IN_MODE_SERVER.getType())
                updateApiHeader(getAccessToken());

            return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String token) {
        mPreferencesHelper.setAccessToken(token);
    }

    @Override
    public void updateUserInfo(LoginResponse.Customer customer, LoggedInMode loggedInMode) {
        setCurrentUserLoggedInMode(loggedInMode);
        updateApiHeader(getAccessToken());
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(new LoginResponse.Customer(),DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }

    // ApiHelper

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Observable<LoginResponse> doLoginApiCall(LoginRequest request) {
        return mApiHelper.doLoginApiCall(request);
    }

    @Override
    public void updateApiHeader(String token) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setKey(token);
    }

}
