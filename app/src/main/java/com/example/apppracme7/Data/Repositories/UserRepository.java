package com.example.apppracme7.Data.Repositories;

import androidx.lifecycle.LiveData;

import com.example.apppracme7.Data.DataSources.UserDataSource;
import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.Data.Models.User;

import java.util.List;

public class UserRepository {

    private UserDataSource users;
    public UserRepository(User user) {
        this.users = new UserDataSource();
    }
    public LiveData<List<User>>  getData() {
        return users.users();
    }
}
