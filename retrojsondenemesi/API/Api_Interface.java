package com.example.kerem.retrojsondenemesi.API;

import com.example.kerem.retrojsondenemesi.JSON.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kerem on 28.02.2018.
 */

public interface Api_Interface {

    @GET("/api/find/movie")
    Call<List<Model>> getMovies(@Query("title") String title, @Query("year") String year);
}
