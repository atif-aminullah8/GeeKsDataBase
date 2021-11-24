package com.freecodecamp.project_geeks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ViewCourses extends AppCompatActivity {

    private ArrayList<CourseModal> courseModalArrayList;
    private DB_Handler db_handler;
    private CourseRVAdapter adapter ;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);
        recyclerView = findViewById(R.id.idRVCourses);


        // inizialing our all variables
          courseModalArrayList = new ArrayList<>();
          db_handler = new DB_Handler(ViewCourses.this);

        courseModalArrayList = db_handler.readCourse();



        adapter = new CourseRVAdapter(courseModalArrayList,ViewCourses.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCourses.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}