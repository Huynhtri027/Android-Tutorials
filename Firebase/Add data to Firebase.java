package com.example.kerem.firebaseapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/* IMPORTANT NOTES
    Email must be valid like using @ sign
    Password must be at least 6 values

    minSdk: 20
    add dependencies: compile 'com.google.firebase:firebase-auth:10.0.1'
    internet permission might be needed
 */
    public class MainActivity extends AppCompatActivity {

    EditText editText_todo;
    Button button_add;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference noteRef = database.getReference("Notes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_todo = (EditText) findViewById(R.id.editText_todo);
        button_add = (Button) findViewById(R.id.button_add);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo = editText_todo.getText().toString();
                noteRef.child("todolist").push().setValue(todo);
            }
        });




    }






}


