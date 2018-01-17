package com.example.kerem.jsonparse4.Model;

/**
 * Created by Kerem on 17.01.2018.
 */

public class Ogrenci {

    private int ogrenciNo;
    private String ogrenciAdi;
    private String ogrenciSoyadi;
    private String bolumAdi;
    private String okulAdi;
    private int ogrenciSinif;
    private String ogrenciResim;

    public Ogrenci(){

    }

    public Ogrenci(int ogrenciNo, String ogrenciAdi, String ogrenciSoyadi, String bolumAdi, String okulAdi, int ogrenciSinif, String ogrenciResim) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAdi = ogrenciAdi;
        this.ogrenciSoyadi = ogrenciSoyadi;
        this.bolumAdi = bolumAdi;
        this.okulAdi = okulAdi;
        this.ogrenciSinif = ogrenciSinif;
        this.ogrenciResim = ogrenciResim;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(int ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }

    public String getOgrenciSoyadi() {
        return ogrenciSoyadi;
    }

    public void setOgrenciSoyadi(String ogrenciSoyadi) {
        this.ogrenciSoyadi = ogrenciSoyadi;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public int getOgrenciSinif() {
        return ogrenciSinif;
    }

    public void setOgrenciSinif(int ogrenciSinif) {
        this.ogrenciSinif = ogrenciSinif;
    }

    public String getOgrenciResim() {
        return ogrenciResim;
    }

    public void setOgrenciResim(String ogrenciResim) {
        this.ogrenciResim = ogrenciResim;
    }
}
