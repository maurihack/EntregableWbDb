package com.maurihack.entregablewebdb.Model;


import com.google.gson.annotations.SerializedName;
import com.maurihack.entregablewebdb.DAOs.DAOTrackDatabase;

public class Track {

    @SerializedName(DAOTrackDatabase.TITLE)
    private String title;

    @SerializedName(DAOTrackDatabase.TRACK_ID)
    private Integer trackId;

    @SerializedName(DAOTrackDatabase.ALBUM_ID)
    private Integer albumId;

    @SerializedName(DAOTrackDatabase.IMAGE_MAIN)
    private String imageMain;

    @SerializedName(DAOTrackDatabase.THUMBNAIL)
    private String thumbnail;


    public Track() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
