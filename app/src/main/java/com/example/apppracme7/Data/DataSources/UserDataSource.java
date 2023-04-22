package com.example.apppracme7.Data.DataSources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.Data.Models.User;
import com.example.apppracme7.R;

import java.util.ArrayList;
import java.util.List;

public class UserDataSource {
    public LiveData<List<User>> users(){
        MutableLiveData<List<User>> result  = new  MutableLiveData<>();
        ArrayList<User> resultArr = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            resultArr.add(new User("default.user" + i + "@mail.com", "passwd" + i));

        }
        result.postValue(resultArr);


        return result;
    }
}
