package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FirstRegActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page_reg);
    }

    public void clickContinue(View view) {
        Intent intent = new Intent(FirstRegActivity.this, SecondRegActivity.class);
        startActivity(intent);
    }
}
