package com.example.kerem.retrojsondenemesi.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kerem on 28.02.2018.
 */

public class Metadata {
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("asp_retio")
    @Expose
    private String aspRetio;
    @SerializedName("filming_locations")
    @Expose
    private List<String> filmingLocations = null;
    @SerializedName("also_known_as")
    @Expose
    private List<String> alsoKnownAs = null;
    @SerializedName("countries")
    @Expose
    private List<String> countries = null;
    @SerializedName("gross")
    @Expose
    private String gross;
    @SerializedName("sound_mix")
    @Expose
    private List<String> soundMix = null;
    @SerializedName("budget")
    @Expose
    private String budget;

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getAspRetio() {
        return aspRetio;
    }

    public void setAspRetio(String aspRetio) {
        this.aspRetio = aspRetio;
    }

    public List<String> getFilmingLocations() {
        return filmingLocations;
    }

    public void setFilmingLocations(List<String> filmingLocations) {
        this.filmingLocations = filmingLocations;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<String> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public List<String> getSoundMix() {
        return soundMix;
    }

    public void setSoundMix(List<String> soundMix) {
        this.soundMix = soundMix;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
