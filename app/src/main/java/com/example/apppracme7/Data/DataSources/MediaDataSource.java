package com.example.apppracme7.Data.DataSources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.R;

import java.util.ArrayList;
import java.util.List;

public class MediaDataSource {
    public LiveData<List<Media>> media(){
        MutableLiveData<List<Media>> result  = new  MutableLiveData<>();
            ArrayList<Media> resultArr = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                resultArr.add(new Media("Artist " + i, "Title " + i, R.drawable.the_beatles));

            }
            result.postValue(resultArr);


        return result;
    }
}
