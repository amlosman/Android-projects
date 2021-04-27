package com.example.myappweather;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class APIMAP extends AppCompatActivity implements LocationListener {
    LocationManager locationManager;
    String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_p_i_m_a_p);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider = LocationManager.GPS_PROVIDER;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(APIMAP.this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }
        locationManager.requestLocationUpdates(provider, 0, 0, this);

        Location location = locationManager.getLastKnownLocation(provider);

        final double lon = location.getLongitude();
        final double lat = location.getLatitude();

        Intent intent = new Intent(getApplicationContext(), DisplayWeather.class);
        intent.putExtra("CityName", "map&" + lon + "&" + lat);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        System.out.println("L" + location.getLatitude() + "Lo" + location.getLongitude());

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(APIMAP.this, "Locationget Succesffully", Toast.LENGTH_SHORT).show();
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.requestLocationUpdates(provider, 0, 0, this);
                Location location = locationManager.getLastKnownLocation(provider);
                final double lon =location.getLongitude();
                final  double lat = location.getLatitude();
                Intent intent = new Intent(getApplicationContext(),DisplayWeather.class);
                intent.putExtra("CityName","map&"+lon+"&"+lat);
                startActivity(intent);

            }
            else
            {
                //user denied the permission
            }
        }


    }
}