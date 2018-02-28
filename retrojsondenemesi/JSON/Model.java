package com.example.kerem.retrojsondenemesi.JSON;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Url;

/**
 * Created by Kerem on 28.02.2018.
 */

public class Model {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("content_rating")
    @Expose
    private String contentRating;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("url")
    @Expose
    private Url url;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("trailer")
    @Expose
    private List<Trailer> trailer = null;
    @SerializedName("length")
    @Expose
    private String length;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("genre")
    @Expose
    private List<String> genre = null;
    @SerializedName("rating_count")
    @Expose
    private String ratingCount;
    @SerializedName("storyline")
    @Expose
    private String storyline;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("writers")
    @Expose
    private List<String> writers = null;
    @SerializedName("stars")
    @Expose
    private List<String> stars = null;
    @SerializedName("poster")
    @Expose
    private Poster poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Trailer> getTrailer() {
        return trailer;
    }

    public void setTrailer(List<Trailer> trailer) {
        this.trailer = trailer;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getStoryline() {
        return storyline;
    }

    public void setStoryline(String storyline) {
        this.storyline = storyline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }

}
