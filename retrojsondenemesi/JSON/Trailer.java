package com.example.kerem.retrojsondenemesi.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kerem on 28.02.2018.
 */

public class Trailer {
    @SerializedName("mimeType")
    @Expose
    private String mimeType;
    @SerializedName("definition")
    @Expose
    private String definition;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
