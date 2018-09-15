package com.wanztudio.mvp.utils;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

/**
 * Created by Ridwan Ismail on 28 August 2018
 * You can contact me at : iwanz@pm.me
 */

public class ReleaseTree extends Timber.Tree {

    private static final int MAX_LOG_LENGTH = 40000;

    @Override
    protected boolean isLoggable(String tag, int priority) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO){
            return false;
        }

        //Only log WARN, ERROR, WTF
        return true;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (isLoggable(tag, priority)){

            //Report caught exceptions to Crashlytics (for whatever crash library you use)
            if (priority == Log.ERROR && t != null){
                Crashlytics.log(message);
                Crashlytics.logException(t);
            }

            //Message is short enough, does not need to be broken into chunks
            if (message.length() < MAX_LOG_LENGTH){
                if (priority == Log.ASSERT){
                    Log.wtf(tag, message);
                } else {
                    Log.println(priority, tag, message);
                }
                return;
            }

            //Split by line, then ensure each line can fit into Log's maximum length.
            for(int i = 0, length = message.length(); i < length; i++){
                int newLine = message.indexOf('\n', i);
                newLine = newLine != -1 ? newLine : length;
                do{
                    int end = Math.min(newLine, i + MAX_LOG_LENGTH);
                    String part = message.substring(i, end);
                    if (priority == Log.ASSERT){
                        Log.wtf(tag, part);
                    } else {
                        Log.println(priority, tag, part);
                    }
                } while (i < length);
            }
        }
    }
}


