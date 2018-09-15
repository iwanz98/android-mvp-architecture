package com.wanztudio.mvp.data.prefs;

import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.di.ApplicationContext;
import com.wanztudio.mvp.utils.Constants;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context) {
        Hawk.init(context).build();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return Hawk.get(Constants.PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        Hawk.put(Constants.PREF_KEY_USER_LOGGED_IN_MODE, mode.getType());
    }

    @Override
    public String getAccessToken() {
        return Hawk.get(Constants.PREF_KEY_USER_TOKEN,"");
    }

    @Override
    public void setAccessToken(String token) {
       Hawk.put(Constants.PREF_KEY_USER_TOKEN, token);
    }
}
