package com.example.apppracme7.UI.StateHolder.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Repositories.MediaRepository;
import com.example.apppracme7.Data.Models.Media;

import java.util.List;

import kotlinx.coroutines.channels.ProduceKt;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MediaRepository mediaRepository;
    private LiveData<List<Media>> media;

    public ViewModel(){
        mediaRepository = new MediaRepository();
        media = mediaRepository.getData();
    }
    public LiveData<List<Media>> getMedia() {
        return media;
    }

}
