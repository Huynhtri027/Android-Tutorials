package com.example.kerem.sqlitedeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kerem on 01.11.2017.
 */

public class Database extends SQLiteOpenHelper{

    //DATABASE INFO
    private static final String DATABASE_NAME="todo_database";
    private static final String TABLE_NAME="todo_table";
    private static final int DATABASE_VERSION=1;

    //VALUES OF DATABASE
    private static final String TITLE="todo_headline";
    private static final String CONTENT = "todo_content";
    private static final String ID = "_id";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREATING DATABASE

        String create_table = "CREATE TABLE "+TABLE_NAME+
                " (" +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TITLE+" VARCHAR,"+
                CONTENT+" VARCHAR)";
        sqLiteDatabase.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //DELETES EXISTING TABLE AND CRATES NEW UPGRADED TABLE
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addNewTodo(User user) {

        //OPENING DATABASE FIRST
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TITLE,user.getTitle());
        cv.put(CONTENT,user.getContent());

        //if id == -1 then we understand something went wrong or not written
        long id = database.insert(TABLE_NAME, null, cv);
        database.close();
        return id;

    }

    public List<User> printAllDatas() {

        SQLiteDatabase database = this.getReadableDatabase();

        //ONLY BRING TITLE AND CONTENT COLUMNS
        String [] columns = new String[]{TITLE,CONTENT};
        Cursor c = database.query(TABLE_NAME, columns, null, null, null, null, null);

        /* IF WE WANT TO PRINT ALL DATAS FROMT THAT TABLE
        Cursor cursor = database.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        */

        int lineNumber_title = c.getColumnIndex(TITLE);
        int lineNumber_content = c.getColumnIndex(CONTENT);

        List<User> userList = new ArrayList<User>();

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){

            User user = new User();
            user.setTitle(c.getString(lineNumber_title));
            user.setContent(c.getString(lineNumber_content));

            userList.add(user);

        }
        database.close();
        return userList;
    }
}
