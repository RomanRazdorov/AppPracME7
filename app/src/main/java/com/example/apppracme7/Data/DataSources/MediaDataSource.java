package com.example.apppracme7.Data.DataSources;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.apppracme7.Data.Models.Media;
import com.example.apppracme7.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaDataSource {
    private final Context context;

    public MediaDataSource(Context context) {
        this.context = context;
    }

    public LiveData<List<Media>> media() {
        MutableLiveData<List<Media>> result = new MutableLiveData<>();
        ArrayList<Media> resultArr = new ArrayList<>();

        File externalDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalDir != null) {
            File[] imageFiles = externalDir.listFiles();
            if (imageFiles != null) {
                for (File file : imageFiles) {
                    String filename = file.getName();
                    int dotIndex = filename.lastIndexOf('.');
                    if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
                        String extension = filename.substring(dotIndex + 1).toLowerCase();
                        if (extension.equals("jpg") || extension.equals("png")) {
                            String artist = filename.substring(0, dotIndex);
                            String title = "";
                            int dashIndex = artist.indexOf('-');
                            if (dashIndex >= 0 && dashIndex < artist.length() - 1) {
                                title = artist.substring(dashIndex + 1).trim();
                                artist = artist.substring(0, dashIndex).trim();
                            }
                            resultArr.add(new Media(artist, title, Uri.fromFile(file).getPath()));
                        }
                    }
                }
            }
        }

        result.postValue(resultArr);
        return result;
    }

}
