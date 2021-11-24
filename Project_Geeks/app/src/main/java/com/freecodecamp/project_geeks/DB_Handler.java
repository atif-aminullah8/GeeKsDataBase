package com.freecodecamp.project_geeks;

import static com.freecodecamp.project_geeks.DB_Constants.DESCRIPTION_COL;
import static com.freecodecamp.project_geeks.DB_Constants.DURATION_COL;
import static com.freecodecamp.project_geeks.DB_Constants.ID_COL;
import static com.freecodecamp.project_geeks.DB_Constants.NAME_COL;
import static com.freecodecamp.project_geeks.DB_Constants.TABLE_NAME;
import static com.freecodecamp.project_geeks.DB_Constants.TRACKS_COL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DB_Handler extends SQLiteOpenHelper {

    public DB_Handler(@Nullable Context context) {
        super(context,DB_Constants.DB_NAME, null, DB_Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)";

        db.execSQL(query);

    }


    //Adding a Course
    public void addNewCourse(String courseName, String courseDuration, String courseDescription, String courseTracks){
          SQLiteDatabase db = this.getWritableDatabase();
        // (way to putting values in Table)
        ContentValues cv = new ContentValues();
        cv.put(NAME_COL, courseName);
        cv.put(DURATION_COL, courseDuration);
        cv.put(DESCRIPTION_COL, courseDescription);
        cv.put(TRACKS_COL, courseTracks);

        db.insert(TABLE_NAME,null,cv);
        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // Reading all Courses
    public ArrayList<CourseModal> readCourse(){
    SQLiteDatabase db = getReadableDatabase();
    String query_read = "SELECT  *  FROM  " + TABLE_NAME ;
        Cursor cursor = db.rawQuery(query_read , null);

        ArrayList<CourseModal> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                arrayList.add(new CourseModal(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)));

            }while(cursor.moveToNext());
        }
           cursor.close();

        return arrayList;

    }

    public void updateCourse(String originalCourseName, String courseName, String courseDescription, String courseTracks, String courseDuration ){

         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();

         contentValues.put(NAME_COL,courseName);
         contentValues.put(DESCRIPTION_COL,courseDescription);
         contentValues.put(DURATION_COL,courseDuration);
         contentValues.put(TRACKS_COL,courseTracks);

         db.update(TABLE_NAME,contentValues,"name=?",new String[]{originalCourseName});
         db.close();



    }






    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
