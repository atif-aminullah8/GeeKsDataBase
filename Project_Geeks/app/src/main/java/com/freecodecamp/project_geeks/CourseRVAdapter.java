package com.freecodecamp.project_geeks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    private ArrayList<CourseModal> courseModalArrayList;
    private Context context;

    public CourseRVAdapter(ArrayList<CourseModal> courseModalArrayList, Context context) {
        this.courseModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {

        CourseModal courseModal = courseModalArrayList.get(position);
        holder.courseNameTV.setText(courseModal.getCourseName());
        holder.courseDescTV.setText(courseModal.getCourseDescription());
        holder.courseDurationTV.setText(courseModal.getCourseDuration());
        holder.courseTracksTV.setText(courseModal.getTracks());


        //the holder is containing all
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,UpdateCourseActivity.class);
               intent.putExtra("name",courseModal.getCourseName());
               intent.putExtra("description",courseModal.getCourseDescription());
               intent.putExtra("duration",courseModal.getCourseDuration());
               intent.putExtra("tracks",courseModal.getTracks());



                context.startActivity(intent); }
        });

    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);


        }
    }
}
