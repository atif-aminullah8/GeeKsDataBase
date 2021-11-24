package com.freecodecamp.project_geeks;

public class CourseModal {
    // variables for our coursename, duration
    // description, tracks and d id.

    private String courseName;
    private String courseDuration;
    private String courseDescription ;
    private String tracks ;
    int id ;

    public CourseModal(String courseName, String courseDuration, String courseDescription, String tracks) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.tracks = tracks;

    }



    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
