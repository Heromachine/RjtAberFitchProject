package com.example.jessi.rjtaberfitch.data.remote.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    //https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json
    private static final String BASE_URL = "https://www.abercrombie.com/anf/nativeapp/qa/codetest/";
    //https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json

    public static Retrofit getRetrofitInstance(){

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
