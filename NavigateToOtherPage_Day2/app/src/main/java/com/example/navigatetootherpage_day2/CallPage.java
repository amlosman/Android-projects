package com.example.navigatetootherpage_day2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class CallPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_page);
        Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01022159072"));
        startActivity(intent);
    }
}
