package com.example.kerem.customlistview.Model;

/**
 * Created by Kerem on 07.12.2017.
 */

public class Ulkeler {

    private String ad;
    private String baskent;
    private int nufus;
    private String resim;

    public Ulkeler(){}

    public Ulkeler(String ad, String baskent, int nufus, String resim) {
        this.ad = ad;
        this.baskent = baskent;
        this.nufus = nufus;
        this.resim = resim;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getBaskent() {
        return baskent;
    }

    public void setBaskent(String baskent) {
        this.baskent = baskent;
    }

    public int getNufus() {
        return nufus;
    }

    public void setNufus(int nufus) {
        this.nufus = nufus;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }
}
