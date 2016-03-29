package com.example.maratmamin.rentamate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        //TODO: Put in login info into intent to determine if login alert should show up in MainActivity
        intent.putExtra("Login", "Some login information");
        startActivity(intent);
    }
}
