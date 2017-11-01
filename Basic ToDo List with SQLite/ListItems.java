package com.example.kerem.sqlitedeneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListItems extends AppCompatActivity {

    TextView textView_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        textView_list = (TextView) findViewById(R.id.textView_list);

        Database database = new Database(getApplicationContext());

        List<User> userList = new ArrayList<User>();

        userList = database.printAllDatas();

        StringBuilder stringBuilder = new StringBuilder();
        for(User user:userList){
            stringBuilder.append(user.getTitle()+"\n"+user.getContent()+"\n\n");
        }
        textView_list.setText(stringBuilder);
    }
}
