package com.example.kerem.denemelist.Model;

/**
 * Created by Kerem on 22.02.2018.
 */

public class Kisi {
    private String ad;

    public Kisi(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return ad;
    }
}
