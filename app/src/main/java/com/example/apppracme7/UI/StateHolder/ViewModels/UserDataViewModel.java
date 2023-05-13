package com.example.apppracme7.UI.StateHolder.ViewModels;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apppracme7.Data.Models.UserData;
import com.example.apppracme7.Data.Repositories.UserDataRepository;

public class UserDataViewModel extends AndroidViewModel {
    private UserDataRepository userRepository;
    private MutableLiveData<UserData> userDataLiveData = new MutableLiveData<>();

    public UserDataViewModel(Application context) {
        super(context);
        this.userRepository = new UserDataRepository(context);
        UserData userData = userRepository.getUserData();
        userDataLiveData.setValue(userData);
    }

    public void saveUserData(String nickname, String fName, String sName, String email, String password) {
        boolean result = userRepository.saveUserData(nickname, fName, sName, email, password);
        if (result) {
            UserData userData = new UserData(nickname, fName, sName, email, password);
            userDataLiveData.setValue(userData);
        }
    }

    public LiveData<UserData> getUserDataLiveData() {
        return userDataLiveData;
    }
}
