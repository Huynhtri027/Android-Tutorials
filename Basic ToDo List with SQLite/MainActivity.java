package com.example.kerem.sqlitedeneme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_title, editText_content;
    Button button_addToList, button_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_title = (EditText) findViewById(R.id.editText_title);
        editText_content= (EditText) findViewById(R.id.editText_content);
        button_addToList = (Button) findViewById(R.id.button_addToList);
        button_list = (Button) findViewById(R.id.button_list);


        button_addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editText_title.getText().toString();
                String content = editText_content.getText().toString();

                //User user = new User(title,content);

                Database database = new Database(getApplicationContext());
                long id = database.addNewTodo(new User(title, content));

                if(id==-1){
                    Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Item added", Toast.LENGTH_SHORT).show();
                    //CLEANING EDIT TEXTS AFTER ADDING ITEM
                    editText_title.setText("");
                    editText_content.setText("");
                }
            }
        });


        button_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListItems.class);
                startActivity(intent);
            }
        });


    }
}
