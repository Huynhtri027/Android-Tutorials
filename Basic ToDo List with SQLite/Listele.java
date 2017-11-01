package com.example.kerem.veritabaniornekuygulama1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Listele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        TextView tv = (TextView) findViewById(R.id.textView);

        Database db = new Database(getApplicationContext());

        List<Student> studentList = new ArrayList<Student>();
        studentList=db.tumKayitlariGetir();

        StringBuilder stringBuilder = new StringBuilder();
        for(Student student:studentList){
            stringBuilder.append(
                    student.getNameSurname()+"\n"+
                    student.getEmail()+"\n"+
                    student.getAdress()+"\n"+"\n\n"
            );
        }
        tv.setText(stringBuilder);

    }
}
