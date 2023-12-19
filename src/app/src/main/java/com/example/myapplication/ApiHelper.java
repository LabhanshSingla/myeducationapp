package com.example.myapplication;

import com.example.myapplication.CourseHelper.Courses;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiHelper {
    @GET("data.json")
    Call<List<Courses>> getAllCourses();

}
