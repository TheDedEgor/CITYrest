package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.simple.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
    }

    public void clickRegistration(View view) {
        Intent intent = new Intent(MainActivity.this, FirstRegActivity.class);
        startActivity(intent);
    }

    public void clickInput(View view) {
        String email = ((EditText) findViewById(R.id.login_text)).getText().toString();
        String password = ((EditText) findViewById(R.id.pass_text)).getText().toString();
        JSONObject object = new JSONObject();
        object.put("name", "Егор");
        object.put("surname", "Корепин");
        JsonSerialize test = new JsonSerialize(object);
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        intent.putExtra("json", test);
        startActivity(intent);
        /*Requests requests = new Requests();
        requests.login(email,password);
        JSONObject object = requests.getResult();
        if((boolean)object.get("result")){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("json", object);
            startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(this, "Неверный логин или пароль!",Toast.LENGTH_LONG);
            toast.show();
        }*/

    }
}