package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String INPUT_URL= "https://myeducationapp.s3.ap-southeast-2.amazonaws.com/";
    public static Retrofit getRetrofitInstance(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(INPUT_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

}
