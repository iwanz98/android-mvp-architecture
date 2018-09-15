
package com.wanztudio.mvp.data.network;

import com.wanztudio.mvp.data.network.model.LoginRequest;
import com.wanztudio.mvp.data.network.model.LoginResponse;
import io.reactivex.Observable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public interface ApiHelper {
    com.wanztudio.mvp.data.network.ApiHeader getApiHeader();

    // Auth
    Observable<LoginResponse> doLoginApiCall(LoginRequest request);


}
