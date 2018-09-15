package com.wanztudio.mvp.data.prefs;

import com.wanztudio.mvp.data.DataManager;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public interface PreferencesHelper {
    int getCurrentUserLoggedInMode();
    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getAccessToken();
    void setAccessToken(String token);

}
