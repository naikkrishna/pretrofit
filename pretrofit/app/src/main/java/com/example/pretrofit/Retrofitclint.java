package com.example.pretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitclint {

    private static Retrofit retrofit;
    private static final String BASE_URL="https://next.json-generator.com/api/json/get/";
    public static Retrofit getRetrofitInstance()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
