package com.example.kavan.behrouzkhani.retrofit;


// ye onject az classe retrofit barmigardoone

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    public static final String BASE_URL = "http://kavanalp.ir/test/";

    public static Retrofit getClient() {

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;

    }


}
