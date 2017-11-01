package com.example.kerem.veritabaniornekuygulama1;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="student_database";
    private static final String TABLE_NAME="student_table";
    private static final int DATABASE_VERSION =1;

    private static final String NAME ="name_surname";
    private static final String EMAIL ="email";
    private static final String ADRESS ="adress";
    private static final String ID ="_id";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String create_table = "CREATE TABLE "+TABLE_NAME+
                " ("+ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NAME + " TEXT, "+
                EMAIL + " TEXT, "+
                ADRESS+ " TEXT)";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long newRegister(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, student.getNameSurname());
        cv.put(EMAIL, student.getEmail());
        cv.put(ADRESS, student.getAdress());

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public List<Student> tumKayitlariGetir() {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunlar = new String[]{NAME,EMAIL,ADRESS};
        Cursor c = db.query(TABLE_NAME,sutunlar,null,null,null,null,null);

        int adsirano = c.getColumnIndex(NAME);
        int mailsirano = c.getColumnIndex(EMAIL);
        int adressirano = c.getColumnIndex(ADRESS);

        List<Student> studentList = new ArrayList<Student>();

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            Student student = new Student();
            student.setNameSurname(c.getString(adressirano));
            student.setEmail(c.getString(mailsirano));
            student.setAdress(c.getString(adressirano));
            studentList.add(student);
        }
        db.close();
        return null;
    }
}
