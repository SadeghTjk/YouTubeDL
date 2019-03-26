package com.example.youtubedl;

import java.util.List;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("youtube.php")
    Call<Youtube> getAllURL(@Query("secret") String secret,@Query("video") String video);
}
