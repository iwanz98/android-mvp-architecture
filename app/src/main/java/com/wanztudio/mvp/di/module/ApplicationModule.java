package com.wanztudio.mvp.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.wanztudio.mvp.R;
import com.wanztudio.mvp.data.AppDataManager;
import com.wanztudio.mvp.data.DataManager;
import com.wanztudio.mvp.data.db.AppDbHelper;
import com.wanztudio.mvp.data.db.DbHelper;
import com.wanztudio.mvp.data.network.ApiHeader;
import com.wanztudio.mvp.data.network.ApiHelper;
import com.wanztudio.mvp.data.network.AppApiHelper;
import com.wanztudio.mvp.data.prefs.AppPreferencesHelper;
import com.wanztudio.mvp.data.prefs.PreferencesHelper;
import com.wanztudio.mvp.di.ApiInfo;
import com.wanztudio.mvp.di.ApplicationContext;
import com.wanztudio.mvp.di.DatabaseInfo;
import com.wanztudio.mvp.utils.Constants;
import io.github.inflationx.calligraphy3.CalligraphyConfig;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return Constants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideTypeKey() {
        return Constants.TYPE_KEY;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.PublicApiHeader providePublicApiHeader() {
        return new ApiHeader.PublicApiHeader();
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String type, PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(type, "");
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig(@ApplicationContext Context context) {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getString(R.string.typeface_regular))
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}

