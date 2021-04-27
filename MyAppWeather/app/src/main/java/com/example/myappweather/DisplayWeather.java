package com.example.myappweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myappweather.ApiRequestForCity.Change;
import com.example.myappweather.ApiRequestForCity.ChangesRestAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayWeather extends AppCompatActivity {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String APIKey = "5591cb3fcc2d6c4445455fd59b39b5be";
    String units="imperial";
    TextView tmp ,city,hum,puss,lastUpdate;
    ImageView imageView;
    Button SelectCity;
    Date date;
    public static final String Shared ="shared";
    public static final String TEXT ="text";
    String Cityn=null;


    int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weather);
        Intent intent = getIntent();
        String  CityName = intent.getStringExtra("CityName");
            SelectCity= findViewById(R.id.button);
            city = findViewById(R.id.Title);
            hum = findViewById(R.id.prcentage);
            puss = findViewById(R.id.prcentag);
            tmp = findViewById(R.id.C);
            imageView = findViewById(R.id.imag);
            lastUpdate = findViewById(R.id.lastUpdate);
            date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        c++;
            if(CityName==null) {
                update();
                CityName=Cityn;
                SelectCity.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
           if(CityName!=null&&CityName!=""){
               c++;
               Gson gson = new GsonBuilder()
                       .setLenient()
                       .create();
               Retrofit retrofit = new Retrofit.Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create(gson))
                       .build();
               ChangesRestAPI gerritAPI = retrofit.create(ChangesRestAPI.class);
               String[] Data = CityName.split("&");
               if (Data.length == 1 && Data[0] != "") {
                   city.setText(CityName);

                   Call<Change> call = gerritAPI.GetResponse(CityName, APIKey, units);
                   call.enqueue(new Callback<Change>() {
                       @Override
                       public void onResponse(Call<Change> call, Response<Change> response) {
                           Change change = response.body();
                           tmp.setText(change.getMain().getTemp().toString());
                           puss.setText(change.getMain().getPressure().toString());
                           hum.setText(change.getMain().getHumidity().toString());

                           double tmpc = 5 / 9 * (change.getMain().getTemp() - 32);
                           if (tmpc < 0 && tmpc <= 25) {
                               imageView.setImageResource(R.drawable.winter);
                           } else if (tmpc > 25 && tmpc <= 50) {
                               imageView.setImageResource(R.drawable.spring);
                           } else {
                               imageView.setImageResource(R.drawable.summer);
                           }


                       }

                       @Override
                       public void onFailure(Call<Change> call, Throwable t) {
                           System.out.println("Error To Load API Request");
                       }
                   });


                   SharedPreferences sharedPreferences = getSharedPreferences(Shared,MODE_PRIVATE);
                   SharedPreferences.Editor editor =sharedPreferences.edit();
                   editor.putString(TEXT ,city.getText().toString());
                   editor.apply();
               } else if (Data.length > 1) {
                   Call<Change> call = gerritAPI.GetResponse2((Data[1]), (Data[2]), APIKey, units);
                   call.enqueue(new Callback<Change>() {
                       @Override
                       public void onResponse(Call<Change> call, Response<Change> response) {
                           Change change = response.body();
                           tmp.setText(change.getMain().getTemp().toString());
                           puss.setText(change.getMain().getPressure().toString());
                           hum.setText(change.getMain().getHumidity().toString());
                           city.setText("by your map");
                           double tmpc = 5 / 9 * (change.getMain().getTemp() - 32);
                           if (tmpc < 0 && tmpc <= 25) {
                               imageView.setImageResource(R.drawable.winter);
                           } else if (tmpc > 25 && tmpc <= 50) {
                               imageView.setImageResource(R.drawable.spring);
                           } else {
                               imageView.setImageResource(R.drawable.summer);
                           }
                       }

                       @Override
                       public void onFailure(Call<Change> call, Throwable t) {

                       }
                   });

               }
                SelectCity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
               lastUpdate.setText("Last update:"+formatter.format(date));


           }

    }
    public void update()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(Shared,MODE_PRIVATE);
        Cityn = sharedPreferences.getString(TEXT,"");
    }
}
