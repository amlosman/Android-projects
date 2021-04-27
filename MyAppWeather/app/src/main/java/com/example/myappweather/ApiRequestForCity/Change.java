package com.example.myappweather.ApiRequestForCity;

import com.google.gson.annotations.SerializedName;

public class Change {
    @SerializedName("main")
    Main main;
    public Main getMain()
    {
        return  main;
    }
    public void setMain(Main main)
    {
        this.main = main;
    }

}
