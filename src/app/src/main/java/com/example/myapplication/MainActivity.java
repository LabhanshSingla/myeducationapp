package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.CourseHelper.Courses;
import com.example.myapplication.CourseHelper.PickUpFromWhereYouLeft;
import com.example.myapplication.CourseHelper.PopularCourse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ApiHelper apiHelper;

    RecyclerView popularRecycler,pickupwhereyouleftRecycler;
    PopularCourseAdaptor popularCourseAdaptor;
    PickUpFromWhereYouLeftAdaptor pickUpFromWhereYouLeftAdaptor;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // new code
        apiHelper = RetrofitClient.getRetrofitInstance().create(ApiHelper.class);
        String accessToken ="";
        Call<List<Courses>> call = apiHelper.getAllCourses();


        call.enqueue(new Callback<List<Courses>>() {

            @Override
            public void onResponse(Call<List<Courses>> call, Response<List<Courses>> response) {
                List<Courses> courses = response.body();

                setPopularRecycler(courses.get(0).getPopularCourses());
                setPickupwhereyouleftRecycler(courses.get(0).getPickUpFromWhereYouLeft());

            }

            @Override
            public void onFailure(Call<List<Courses>> call, Throwable t) {

            }
        });




    }

    public void setPopularRecycler(List<PopularCourse> popularCourseList){
        popularRecycler = findViewById(R.id.id_mostPopular);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        popularRecycler.setLayoutManager(layoutManager);
        popularRecycler.setHasFixedSize(true);
        popularCourseAdaptor = new PopularCourseAdaptor(this, popularCourseList, new PopularCourseAdaptor.ItemClickListener() {
            @Override
            public void onItemClick(PopularCourse details) {
                String url = details.getUrl();
                Intent intent = new Intent(getApplicationContext(),ActivityWeb.class);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        popularRecycler.setAdapter(popularCourseAdaptor);
    }
    public void setPickupwhereyouleftRecycler(List<PickUpFromWhereYouLeft> popularCourseList){
        pickupwhereyouleftRecycler = findViewById(R.id.id_pickrecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        pickupwhereyouleftRecycler.setLayoutManager(layoutManager);
        pickupwhereyouleftRecycler.setHasFixedSize(true);
        pickUpFromWhereYouLeftAdaptor = new PickUpFromWhereYouLeftAdaptor(this, popularCourseList, new PickUpFromWhereYouLeftAdaptor.ItemClickListener() {
            @Override
            public void onItemClick(PickUpFromWhereYouLeft details) {
                String url = details.getUrl();
                Intent intent = new Intent(getApplicationContext(),ActivityWeb.class);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });
        pickupwhereyouleftRecycler.setAdapter(pickUpFromWhereYouLeftAdaptor);
    }
}