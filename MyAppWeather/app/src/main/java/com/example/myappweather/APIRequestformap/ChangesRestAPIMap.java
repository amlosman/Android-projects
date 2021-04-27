package com.example.myappweather.APIRequestformap;

import com.example.myappweather.ApiRequestForCity.Change;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChangesRestAPIMap {

   @GET("weather/")
   Call<Change> GetResponse(@Query("lon") String lon, @Query("lat") String lat,
                            @Query("appid")String APIKey, @Query("units") String Unit);


}
