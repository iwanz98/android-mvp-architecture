package com.wanztudio.mvp.data.db;

import com.wanztudio.mvp.data.db.model.StoreAddress;
import io.reactivex.Observable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public interface DbHelper {

    Observable<Boolean> saveAddress(StoreAddress address);
}
