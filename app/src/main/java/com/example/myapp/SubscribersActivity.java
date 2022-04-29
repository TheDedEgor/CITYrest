package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SubscribersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscribers_page);
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickProfile(View view) {
        Intent intent = new Intent(SubscribersActivity.this, UserProfileActivity.class);
        startActivity(intent);
    }
}
