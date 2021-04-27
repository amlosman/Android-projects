package com.example.myappweather;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myappweather.RecycleView.ContactListAdapter;
import com.example.myappweather.RecycleView.weatherInfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactListAdapter.OnCityListener {
    RecyclerView recyclerView;
    ArrayList<weatherInfo> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvContacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        data.add(new weatherInfo("By GPS"));
        data.add(new weatherInfo("alex"));
        data.add(new weatherInfo("cairo"));
        data.add(new weatherInfo("luxor"));
        data.add(new weatherInfo("sohag"));
        data.add(new weatherInfo("Gizeh"));
        data.add(new weatherInfo("Shubra"));

        data.add(new weatherInfo("Suez"));
        data.add(new weatherInfo("al-Mansura"));
        data.add(new weatherInfo("Tanta"));
        data.add(new weatherInfo("Asyut"));
        data.add(new weatherInfo("Ismailia"));
        data.add(new weatherInfo("Fayyum"));

        data.add(new weatherInfo("Zagazig"));
        data.add(new weatherInfo("Aswan"));
        data.add(new weatherInfo("Damietta"));
        data.add(new weatherInfo("Damanhur"));
        data.add(new weatherInfo("al-Minya"));
        data.add(new weatherInfo("Qena"));

        data.add(new weatherInfo("Hurghada"));
        data.add(new weatherInfo("Banha"));
        data.add(new weatherInfo("Arish"));
        data.add(new weatherInfo("Mallawi"));
        data.add(new weatherInfo("Girga"));



        ContactListAdapter adapter = new ContactListAdapter(data, this, this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void OnCityClick(int position) {
        if(data.get(position).city != "By GPS"){
        Intent intent = new Intent(getApplicationContext(),DisplayWeather.class);
        intent.putExtra("CityName",data.get(position).city);
        startActivity(intent);
    }
    else {
            Intent intent = new Intent(getApplicationContext(),APIMAP.class);
            startActivity(intent);


        }
    }


}
