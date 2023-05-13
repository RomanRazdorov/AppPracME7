package com.example.apppracme7.Data.DataSources.room.Entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.apppracme7.Data.Models.Media;

@Entity(tableName = "media_table")
public class MediaEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "author")
    public String author;

    @ColumnInfo(name = "imageFilePath")
    public String imageFilePath;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public MediaEntity(String title, String author, String imageFilePath) {
        this.title = title;
        this.author = author;
        this.imageFilePath = imageFilePath;
    }

    public Media toDomainModel() {
        return new Media(title, author, imageFilePath);
    }
}
