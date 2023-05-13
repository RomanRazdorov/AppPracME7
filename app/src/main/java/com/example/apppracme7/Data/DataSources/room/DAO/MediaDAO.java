package com.example.apppracme7.Data.DataSources.room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.apppracme7.Data.DataSources.room.Entites.MediaEntity;

import java.util.List;

@Dao
public interface MediaDAO {
    @Query("SELECT * FROM media_table")
    LiveData<List<MediaEntity>> getAllMedia();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMedia(MediaEntity newExercise);

}
