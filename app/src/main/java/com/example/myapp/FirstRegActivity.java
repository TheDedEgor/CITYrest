package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FirstRegActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page_reg);
    }

    public void clickContinue(View view) {
        String email = ((EditText)findViewById(R.id.email_text)).getText().toString();
        String pass1 = ((EditText)findViewById(R.id.password_text)).getText().toString();
        String pass2 = ((EditText)findViewById(R.id.password_again_text)).getText().toString();
        if(pass1.equals(pass2)){
            Intent intent = new Intent(FirstRegActivity.this, SecondRegActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("password",pass1);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(this, "Пароли не совпадают! Попробуйте снова!",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
