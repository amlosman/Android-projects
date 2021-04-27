package com.example.myappweather.ApiRequestForCity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ChangesRestAPI {

   @GET("weather/")
   Call<Change> GetResponse(@Query("q") String City,
                            @Query("appid")String APIKey,@Query("units") String Unit);

   @GET("weather/")
   Call<Change> GetResponse2(@Query("lon") String lon,@Query("lat") String lat,
                            @Query("appid")String APIKey, @Query("units") String Unit);
}
