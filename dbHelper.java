package com.example.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="students";

    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery="CREATE TABLE STUDENT_DETAILS(ROLLNO TEXT ,NAME TEXT, BRANCH TEXT, MARKS TEXT, PERCENTAGE TEXT);";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertData(student s){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        //mapping with column names
        cv.put("ROLLNO",s.getRollno());
        cv.put("NAME",s.getName());
        cv.put("BRANCH",s.getBranch());
        cv.put("MARKS",s.getMarks());
        cv.put("PERCENTAGE",s.getPercentage());

        //insert
        long insert=db.insert("STUDENT_DETAILS",null,cv);
        return insert != -1;
    }

    public student getStudent(String rollNo){
        String query="SELECT * FROM STUDENT_DETAILS WHERE ROLLNO = "+rollNo+";";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            String rollno=cursor.getString(0);
            String name=cursor.getString(1);
            String branch=cursor.getString(2);
            String marks=cursor.getString(3);
            String percentage=cursor.getString(4);

            student s=new student(rollno,name,branch,marks,percentage);
            return s;
        }
        return null;
    }
}
