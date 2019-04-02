package com.danteh.youtubedl;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("youtube.php")
    Call<Youtube> getAllURL(@Query("secret") String secret,@Query("video") String video);
}
