package com.example.navigatetootherpage_day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class BrowsePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_page);
        Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(intent);
    }
}
