package com.example.kerem.jsonparse4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.kerem.jsonparse4.Adapter.GridViewAdapter;
import com.example.kerem.jsonparse4.Model.Ogrenci;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Ogrenci> ogrenciler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);

        ogrenciler = new ArrayList<>();
        ogrenciler.add(
                new Ogrenci(1,"Kerem","Oflu","Pc müh","Beykent",3,"https://i1.sndcdn.com/avatars-000127838661-xx5rjb-t500x500.jpg")
        );
        ogrenciler.add(
                new Ogrenci(1,"Kerem","Oflu","Pc müh","Beykent",3,"https://i1.sndcdn.com/avatars-000127838661-xx5rjb-t500x500.jpg")
        );
        ogrenciler.add(
                new Ogrenci(1,"Kerem","Oflu","Pc müh","Beykent",3,"https://i1.sndcdn.com/avatars-000127838661-xx5rjb-t500x500.jpg")
        );
        ogrenciler.add(
                new Ogrenci(1,"Kerem","Oflu","Pc müh","Beykent",3,"https://i1.sndcdn.com/avatars-000127838661-xx5rjb-t500x500.jpg")
        );

        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,ogrenciler);
        gridView.setAdapter(gridViewAdapter);
    }
}
