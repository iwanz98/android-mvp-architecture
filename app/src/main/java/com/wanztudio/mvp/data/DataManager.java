package com.wanztudio.mvp.data;

import com.wanztudio.mvp.data.network.ApiHelper;
import com.wanztudio.mvp.data.network.model.LoginResponse;
import com.wanztudio.mvp.data.prefs.PreferencesHelper;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public interface DataManager extends PreferencesHelper, ApiHelper {

    void updateApiHeader(String token);

    void updateUserInfo(LoginResponse.Customer customer, LoggedInMode loggedInMode);
    void setUserAsLoggedOut();

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
