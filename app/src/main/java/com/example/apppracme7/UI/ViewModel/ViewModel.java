package com.example.apppracme7.UI.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Repositories.MediaRepository;
import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.Data.Models.User;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private final MutableLiveData<MediaRepository> mediaUI =
            new MutableLiveData<>(new MediaRepository(new Media(null, null,0)));
    private final MutableLiveData<MediaRepository> userID =
            new MutableLiveData<>(new MediaRepository(new User(null, null)));

    public LiveData<MediaRepository> getMediaUI() {
        return mediaUI;
    }

    public void addMedia(String artistName, String title, int imageSource) {
            mediaUI.setValue(
                new MediaRepository(new Media(artistName, title, imageSource))
        );
    }

    public LiveData<MediaRepository> getUserID() {
        return userID;
    }

    public void addUser(String email, String password) {
        userID.setValue(
                new MediaRepository(new User(email, password))
        );
    }
}
