package com.example.kerem.retrojsondenemesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kerem.retrojsondenemesi.API.Api_Interface;
import com.example.kerem.retrojsondenemesi.Client.Client;
import com.example.kerem.retrojsondenemesi.JSON.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static List<Model> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        textView = (TextView)findViewById(R.id.textView);
        //

        //interface
        Api_Interface service = Client.getRetrofitInstance().create(Api_Interface.class);

        //call
        Call<List<Model>> call = service.getMovies("transformers","2007");

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                modelList = response.body();
                String firstMovieTitle = modelList.get(0).getTitle();
                textView.setText(""+firstMovieTitle);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }
}
