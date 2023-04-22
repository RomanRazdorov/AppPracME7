package com.example.apppracme7.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Repository;
import com.example.apppracme7.Data.Source.Media;
import com.example.apppracme7.Data.Source.User;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<Repository> mediaUI =
            new MutableLiveData<>(new Repository(new Media(null, null,0)));
    private final MutableLiveData<Repository> userID =
            new MutableLiveData<>(new Repository(new User(null, null)));

    public LiveData<Repository> getMediaUI() {
        return mediaUI;
    }

    public void addMedia(String artistName, String title, int imageSource) {
            mediaUI.setValue(
                new Repository(new Media(artistName, title, imageSource))
        );
    }

    public LiveData<Repository> getUserID() {
        return userID;
    }

    public void addUser(String email, String password) {
        userID.setValue(
                new Repository(new User(email, password))
        );
    }
}
