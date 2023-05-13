package com.example.apppracme7.Data.Repositories;

import android.content.Context;

import com.example.apppracme7.Data.DataSources.UserPreferences;
import com.example.apppracme7.Data.Models.UserData;

public class UserDataRepository {
    private UserPreferences userPrefs;

    public UserDataRepository(Context context) {
        userPrefs = new UserPreferences(context);

    }

    public boolean saveUserData(String nickname, String fName, String sName, String email, String password) {
        try {
            userPrefs.saveUserData(nickname, fName, sName, email, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserData getUserData() {
        return userPrefs.getUserData();
    }
}
