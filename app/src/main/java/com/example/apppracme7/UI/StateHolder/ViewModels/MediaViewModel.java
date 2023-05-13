package com.example.apppracme7.UI.StateHolder.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.apppracme7.Data.Repositories.MediaRepository;
import com.example.apppracme7.Data.Models.Media;

import java.util.List;

public class MediaViewModel extends AndroidViewModel {

    private MediaRepository mediaRepository;

    private LiveData<List<Media>> mediaLiveData;

    public MediaViewModel(Application application) {
        super(application);
        this.mediaRepository = new MediaRepository(application);
        mediaLiveData = mediaRepository.getMediaFromDB();
    }

    public LiveData<List<Media>> getMedia() {
        if (mediaLiveData == null) {
            mediaLiveData = mediaRepository.getMedia();
        }
        return mediaLiveData;
    }

    public void insert(String title, String author, String imageFilePath) {
        mediaRepository.addMedia(new Media(title, author, imageFilePath));
    }

}
