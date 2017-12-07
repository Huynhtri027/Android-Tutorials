package com.example.kerem.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kerem.customlistview.Adapter.MyAdapter;
import com.example.kerem.customlistview.Model.Ulkeler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Ulkeler> ulkelers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ulkelers = new ArrayList<>();

        myAdapter = new MyAdapter(this,ulkelers);

        //flag size: 400x200
        ulkelers.add(new Ulkeler("Turkey","Ankara",81000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countrya","Ankaradd",81000000,"myflag2"));
        ulkelers.add(new Ulkeler("Countryaa","Ankarasd",81000000,"myflag3"));
        ulkelers.add(new Ulkeler("Countrys","Ankarads",7000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countryss","Ankaraas",82000000,"myflag2"));
        ulkelers.add(new Ulkeler("Turkey","Ankara",81000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countrya","Ankaradd",81000000,"myflag2"));
        ulkelers.add(new Ulkeler("Countryaa","Ankarasd",81000000,"myflag3"));
        ulkelers.add(new Ulkeler("Countrys","Ankarads",7000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countryss","Ankaraas",82000000,"myflag2"));
        ulkelers.add(new Ulkeler("Turkey","Ankara",81000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countrya","Ankaradd",81000000,"myflag2"));
        ulkelers.add(new Ulkeler("Countryaa","Ankarasd",81000000,"myflag3"));
        ulkelers.add(new Ulkeler("Countrys","Ankarads",7000000,"myflag1"));
        ulkelers.add(new Ulkeler("Countryss","Ankaraas",82000000,"myflag2"));

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicked Item: "+i, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
