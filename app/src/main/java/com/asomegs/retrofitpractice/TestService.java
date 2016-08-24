package com.asomegs.retrofitpractice;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gyeongsik Kim on 2016-08-24.
 */
public interface TestService {
    @GET("weather")
    Call<Weather> getWeather(@Query("lat") String lat, @Query("lon") String lng, @Query("APPID") String apiKey);

    @GET("weather")
    Call<String> getJsonObject(@Query("lat") String lat, @Query("lon") String lng, @Query("APPID") String apiKey);
}
