package com.github.seelikes.android.log.demo;

import android.app.Application;

import com.github.seelikes.android.log.SaLog;
import com.orhanobut.logger.Logger;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SaLog.init(BuildConfig.DEBUG ? Logger.VERBOSE : Logger.ERROR);
    }
}
