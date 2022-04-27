package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
        Spinner spinner = findViewById(R.id.filter_age);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_item_in_filter, getResources().getStringArray(R.array.ages));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.filter_price);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_in_filter, getResources().getStringArray(R.array.prices));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.filter_duration);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_in_filter, getResources().getStringArray(R.array.durations));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void clickClose(View view) {
        finish();
    }
}
