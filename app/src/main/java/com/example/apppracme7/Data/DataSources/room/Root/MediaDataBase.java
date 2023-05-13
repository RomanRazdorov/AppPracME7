package com.example.apppracme7.Data.DataSources.room.Root;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.apppracme7.Data.DataSources.room.DAO.MediaDAO;
import com.example.apppracme7.Data.DataSources.room.Entites.MediaEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MediaEntity.class}, version = 1)
public abstract class MediaDataBase extends RoomDatabase {
    public abstract MediaDAO mediaDAO();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile MediaDataBase INSTANCE;

    public static MediaDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MediaDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MediaDataBase.class, "media-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
