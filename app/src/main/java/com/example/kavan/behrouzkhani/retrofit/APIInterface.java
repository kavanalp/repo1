package com.example.kavan.behrouzkhani.retrofit;


import com.example.kavan.behrouzkhani.model.LoginModel;
import com.example.kavan.behrouzkhani.model.Users;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


// har interface 1 request

public interface APIInterface {
    @GET("posttest.php")
    Call<LoginModel> getUser();

    @POST("posttest.php")
    @FormUrlEncoded

    //@Field baraye kilid haye post
    Call<Users> registerUser(@Field("username") String username , @Field("password") String password);

}
