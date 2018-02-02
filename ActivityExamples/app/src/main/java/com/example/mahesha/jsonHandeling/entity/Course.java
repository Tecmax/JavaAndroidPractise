package com.example.mahesha.jsonHandeling.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL PC on 26-Dec-17.
 */

public class Course {
    @SerializedName("Categories")
    private CourseCategory[] category;

    public CourseCategory[] getCategory() {
        return category;
    }

    public void setCategory(CourseCategory[] category) {
        this.category = category;
    }

    public class CourseCategory {
        @SerializedName("courseName")
        private String courseName;
        @SerializedName("courseDetails")
        private String courseDetail;

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseDetail() {
            return courseDetail;
        }

        public void setCourseDetail(String courseDetail) {
            this.courseDetail = courseDetail;
        }
    }
}
