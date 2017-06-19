package com.maurihack.entregablewebdb.Model;


import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private Integer trackId;

    @SerializedName("albumId")
    private Integer albumId;

    @SerializedName("url")
    private String imageBig;

    @SerializedName("thumbnailUrl")
    private String imageSmall ;


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

    public String getImageBig() {
        return imageBig;
    }

    public void setImageBig(String imageBig) {
        this.imageBig = imageBig;
    }

    public String getImageSmall() {
        return imageSmall;
    }

    public void setImageSmall(String imageSmall) {
        this.imageSmall = imageSmall;
    }
}
