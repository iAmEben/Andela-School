package com.mobileedu8.andelaschools.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static com.mobileedu8.andelaschools.utils.Constants.USER_MODE_PREF_DEFAULT_RETURN;
import static com.mobileedu8.andelaschools.utils.Constants.USER_MODE_PREF_KEY;
import static com.mobileedu8.andelaschools.utils.Constants.USER_MODE_PREF_NAME;

public class Prefs {

    public static boolean setUserMode(short userMode, Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(USER_MODE_PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.putInt(USER_MODE_PREF_KEY, userMode);
        return editor.commit();
    }


    public static short getUserMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(USER_MODE_PREF_NAME, Context.MODE_PRIVATE);
        return (short) preferences.getInt(USER_MODE_PREF_KEY, USER_MODE_PREF_DEFAULT_RETURN);
    }
}
