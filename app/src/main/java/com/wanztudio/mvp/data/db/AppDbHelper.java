package com.wanztudio.mvp.data.db;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.wanztudio.mvp.data.db.model.DaoMaster;
import com.wanztudio.mvp.data.db.model.DaoSession;
import com.wanztudio.mvp.data.db.model.StoreAddress;
import io.reactivex.Observable;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Boolean> saveAddress(StoreAddress address) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getStoreAddressDao().insert(address);
                return true;
            }
        });
    }
}