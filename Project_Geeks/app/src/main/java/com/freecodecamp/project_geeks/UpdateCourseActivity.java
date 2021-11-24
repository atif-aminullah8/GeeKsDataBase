package com.freecodecamp.project_geeks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCourseActivity extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button updateCourseBtn;
    private DB_Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);

        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);

        // on below line we are initialing our dbhandler class.
        handler = new DB_Handler(UpdateCourseActivity.this);
          String coursename =  getIntent().getStringExtra("name");
          String courseDesc =  getIntent().getStringExtra("description");
          String courseDuration =  getIntent().getStringExtra("duration");
          String coursTracks =  getIntent().getStringExtra("tracks");


          courseNameEdt.setText(coursename);
          courseTracksEdt.setText(coursTracks);
          courseDurationEdt.setText(courseDuration);
          courseDescriptionEdt.setText(courseDesc);

          updateCourseBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
               handler.updateCourse(coursename,courseNameEdt.getText().toString(),courseDescriptionEdt.getText().toString(),courseTracksEdt.getText().toString(),courseDurationEdt.getText().toString());
                  Toast.makeText(UpdateCourseActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();

                  Intent intent = new Intent(UpdateCourseActivity.this, MainActivity.class);
                  startActivity(intent);

              }
          });
    }
}