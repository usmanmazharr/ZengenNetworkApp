package com.example.zengennetwork.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.zengennetwork.MainActivity;
import com.example.zengennetwork.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        Thread thread = new Thread()
        {
            @Override
            public void run() {
             try
             {
                 sleep(2500);
             }

             catch (InterruptedException e)
             {
                 e.printStackTrace();
             }

             finally
             {
                 Intent intent  = new Intent(SplashActivity.this , MainActivity.class);
                 startActivity(intent);
             }
            }

        };
        thread.start();
    }
}