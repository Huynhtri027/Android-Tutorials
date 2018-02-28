package com.example.kerem.retrojsondenemesi.Client;

import com.example.kerem.retrojsondenemesi.API.Api_Interface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kerem on 28.02.2018.
 */

public class Client {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://theimdbapi.org";

    private Client() {}

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;

    }

    public static Api_Interface getRetroInterface() {
        return getRetrofitInstance().create(Api_Interface.class);
    }

}
