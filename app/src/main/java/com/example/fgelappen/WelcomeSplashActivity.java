package com.example.fgelappen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeSplashActivity extends AppCompatActivity {

    private static int splashTimer = 1200;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splash);

        new Handler().postDelayed(()-> {
            finish();
        },splashTimer);
    }
}