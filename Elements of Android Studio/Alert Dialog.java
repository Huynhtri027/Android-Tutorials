package com.example.kerem.yesorno;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView_questions;
    final Context context = this;
    String colors[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new String[]{"Red", "Blue", "Yellow", "Pink", "Purple"};

        listView_questions = (ListView) findViewById(R.id.listView_questions);
        listView_questions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Index: " + i, Toast.LENGTH_SHORT).show();


                final AlertDialog.Builder builder_question1 = new AlertDialog.Builder(context);
                builder_question1.setTitle("QUIZ " + i + 1);
                builder_question1.setMessage(R.string.questions_1);
                builder_question1.setIcon(android.R.drawable.alert_dark_frame);
                builder_question1.setCancelable(false);
                builder_question1.create().show();

                //POSITIVE BUTTON
                builder_question1.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do something...
                        //and dismiss
                        dialogInterface.dismiss();

                    }
                });

                //NEGATIVE BUTTON
                builder_question1.setNegativeButton("No",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do something...
                        //and dismiss
                        dialogInterface.dismiss();
                    }
                });


            }
        });


        //ALERT DIALOG EXAMPLE WITH LIST

        final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Listview Dialog Example");
        builder2.setItems(colors, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(getApplicationContext(), "Color choosed: "+colors[which],Toast.LENGTH_SHORT).show();
                builder2.create().show();
            }
        });


        //NOTE - CUSTOM DIALOG WITH Edittexts, Buttons etc...
            //1.Create a new xml(let's say; customdialog.xml) resource file and add edittexts, buttons there
        //ın main activity;

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.customdialog, null);
        final EditText name = (EditText)mView.findViewById(R.id.editText_name);
        final EditText surname = (EditText)mView.findViewById(R.id.editText_surname);
        Button mLogin = (Button)mView.findViewById(R.id.button_login);

            mLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //do something
                }
            });


    }
}
