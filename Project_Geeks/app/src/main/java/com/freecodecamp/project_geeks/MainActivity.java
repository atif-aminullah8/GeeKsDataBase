package com.freecodecamp.project_geeks;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn;
    private Button readallCourses;

    private DB_Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readallCourses = findViewById(R.id.idBtnReadCourse);

        // I want to use DataBase Functions Here so
          handler = new DB_Handler(MainActivity.this);

          addCourseBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   String name = courseNameEdt.getText().toString();
                   String track = courseTracksEdt.getText().toString();
                   String duration = courseDurationEdt.getText().toString();
                   String description = courseDescriptionEdt.getText().toString();

                   if (name.isEmpty()&&track.isEmpty()&&duration.isEmpty()&&description.isEmpty()){
                       Toast.makeText(MainActivity.this, "Please enter all data", Toast.LENGTH_SHORT).show();
                   }
                   handler.addNewCourse(name,duration,description,track);
                  Toast.makeText(MainActivity.this, "Course has been Added", Toast.LENGTH_SHORT).show();
                  courseNameEdt.setText("");
                  courseTracksEdt.setText("");
                  courseDurationEdt.setText("");
                  courseDescriptionEdt.setText("");


              }
          });
          readallCourses.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(MainActivity.this,ViewCourses.class);
                  startActivity(intent);
              }
          });
    }
}