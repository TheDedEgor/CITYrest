package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.simple.JSONObject;

import java.io.IOException;

public class SecondRegActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page_reg);
        Spinner spinner = findViewById(R.id.spinner_days);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_item_in_registration, getResources().getStringArray(R.array.days));
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.spinner_months);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_in_registration, getResources().getStringArray(R.array.months));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.spinner_years);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_in_registration, getResources().getStringArray(R.array.years));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void clickRegistered(View view) throws IOException {
        /*Requests requests = new Requests();
        String name = ((EditText) findViewById(R.id.name_text)).getText().toString();
        String surname = ((EditText) findViewById(R.id.surname_text)).getText().toString();
        String date = ((Spinner) findViewById(R.id.spinner_years)).getSelectedItem().toString() + "-" + ((Spinner) findViewById(R.id.spinner_months)).getSelectedItem().toString() + "-" + ((Spinner) findViewById(R.id.spinner_days)).getSelectedItem().toString();
        String sex = "М";
        Bundle arguments = getIntent().getExtras();
        String email = arguments.get("email").toString();
        String password = arguments.get("password").toString();
        JSONObject object = requests.register(name,surname,sex,date,email,password);
        System.out.println(object);
        System.out.println(object.get("result"));*/
        Intent intent = new Intent(SecondRegActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
