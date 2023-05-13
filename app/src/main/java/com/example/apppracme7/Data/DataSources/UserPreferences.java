package com.example.apppracme7.Data.DataSources;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.apppracme7.Data.Models.UserData;

public class UserPreferences {

    private static final String PREFS_NAME = "user_prefs";
    private static final String KEY_NICKNAME = "nickname";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_SNAME = "sname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String APP_PREFERENCES = "user_profiles";

    private android.content.SharedPreferences mSettings;

    private Context context;

    public UserPreferences(Context context) {
        this.context = context;
        mSettings = this.context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }


    public void saveUserData(String nickname, String fName, String sName, String email, String password) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(KEY_NICKNAME, nickname);
        editor.putString(KEY_FNAME, fName);
        editor.putString(KEY_SNAME, sName);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);

        editor.apply();
    }

    public UserData getUserData() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String nickname = prefs.getString(KEY_NICKNAME, null);
        String fName = prefs.getString(KEY_FNAME, null);
        String sName = prefs.getString(KEY_SNAME, null);
        String email = prefs.getString(KEY_EMAIL, null);
        String password = prefs.getString(KEY_PASSWORD, null);

        if (nickname == null || fName == null || sName == null || email == null || password == null) {
            return null;
        }

        return new UserData(nickname, fName, sName, email, password);
    }
    public  void clearUserData() {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }

    public void setSomeValue(String key, int value) {
        android.content.SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getSomeValue(String key) {
        return mSettings.getInt(key, 0);
    }
}
