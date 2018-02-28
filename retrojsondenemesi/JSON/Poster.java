package com.example.kerem.retrojsondenemesi.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Kerem on 28.02.2018.
 */

public class Poster {
    @SerializedName("large")
    @Expose
    private String large;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
