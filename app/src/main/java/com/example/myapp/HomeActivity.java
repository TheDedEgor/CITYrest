package com.example.myapp;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import org.json.simple.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private final String MAPKIT_API_KEY = "ff1939ec-224e-48e1-b938-68bca52bb07e";
    private final Point TARGET_LOCATION = new Point(57.628394, 39.885588);
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);
        setContentView(R.layout.home_page);
        ConstraintLayout placeHolder = findViewById(R.id.home_layout);
        getLayoutInflater().inflate(R.layout.menu, placeHolder);
        getLayoutInflater().inflate(R.layout.profile, placeHolder);
        ImageView imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);

        Bundle arguments = getIntent().getExtras();
        JsonSerialize test = (JsonSerialize) arguments.get("json");
        JSONObject object = test.getJson();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mapView != null){
            mapView.onStop();
            MapKitFactory.getInstance().onStop();
        }
    }

    public void clickHome(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        ConstraintLayout placeHolder = findViewById(R.id.home_layout);
        placeHolder.removeAllViews();
        ltInflater.inflate(R.layout.menu, placeHolder);
        ltInflater.inflate(R.layout.profile, placeHolder);


        ImageView imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.chat_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.search_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.map_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.events_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
    }

    public void clickChat(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        ConstraintLayout homeHolder = findViewById(R.id.home_layout);
        homeHolder.removeAllViews();
        ltInflater.inflate(R.layout.menu, homeHolder);
        ltInflater.inflate(R.layout.chat, homeHolder);
        LinearLayout addUsers = findViewById(R.id.add_chat_user);
        ltInflater.inflate(R.layout.user_chat, addUsers);

        View user = ltInflater.inflate(R.layout.user_chat, null, false);
        TextView lastMes = user.findViewById(R.id.user_last_message);
        lastMes.setText("Привет как тебе квест?");
        TextView name = user.findViewById(R.id.user_name);
        name.setText("Смирнова Анастасия");
        TextView time = user.findViewById(R.id.user_last_time);
        time.setText(" · 20:00");
        ImageView img = user.findViewById(R.id.unread_message);
        img.setVisibility(View.INVISIBLE);
        CircleImageView image = user.findViewById(R.id.user_photo);
        image.setImageResource(R.drawable.user_photo2);
        addUsers.addView(user);

        user = ltInflater.inflate(R.layout.user_chat, null, false);
        lastMes = user.findViewById(R.id.user_last_message);
        lastMes.setText("Классно посидели!");
        name = user.findViewById(R.id.user_name);
        name.setText("Голубев Артем");
        time = user.findViewById(R.id.user_last_time);
        time.setText(" · 8нед");
        image = user.findViewById(R.id.user_photo);
        img = user.findViewById(R.id.unread_message);
        img.setVisibility(View.INVISIBLE);
        image.setImageResource(R.drawable.user_photo3);
        addUsers.addView(user);


        ImageView imageView = findViewById(R.id.chat_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.search_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.map_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.events_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
    }

    public void clickMap(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        ConstraintLayout placeHolder = findViewById(R.id.home_layout);
        placeHolder.removeAllViews();
        ltInflater.inflate(R.layout.menu, placeHolder);
        ltInflater.inflate(R.layout.map, placeHolder);

        Spinner spinner = findViewById(R.id.spinner_events);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.spinner_item_on_map, getResources().getStringArray(R.array.events));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner = findViewById(R.id.spinner_nearby);
        adapter = new ArrayAdapter(this, R.layout.spinner_item_on_map, getResources().getStringArray(R.array.nearby));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Карта Яндекса
        // Создание MapView.
        mapView = (MapView)findViewById(R.id.mapview);
        //Запуск карты
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
        // Перемещение камеры в Ярославль.
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 15.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 1),
                null);


        ImageView imageView = findViewById(R.id.map_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.search_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.chat_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.events_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
    }

    public void clickSearch(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        ConstraintLayout placeHolder = findViewById(R.id.home_layout);
        placeHolder.removeAllViews();
        ltInflater.inflate(R.layout.search, placeHolder);
        ltInflater.inflate(R.layout.menu, placeHolder);

        ImageView imageView = findViewById(R.id.search_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.map_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.chat_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.events_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
    }

    public void clickEvents(View view) {
        LayoutInflater ltInflater = getLayoutInflater();
        ConstraintLayout placeHolder = findViewById(R.id.home_layout);
        placeHolder.removeAllViews();
        ltInflater.inflate(R.layout.menu, placeHolder);
        ltInflater.inflate(R.layout.events, placeHolder);

        ImageView imageView = findViewById(R.id.events_image);
        imageView.setColorFilter(getResources().getColor(R.color.active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.home_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.map_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.chat_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
        imageView = findViewById(R.id.search_image);
        imageView.setColorFilter(getResources().getColor(R.color.no_active_tab), PorterDuff.Mode.SRC_IN);
    }


    public void clickFilter(View view) {
        Intent intent = new Intent(HomeActivity.this, FilterActivity.class);
        startActivity(intent);
    }

    public void clickNews(View view) {
        Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
        startActivity(intent);
    }

    public void clickSubscribers(View view) {
        Intent intent = new Intent(HomeActivity.this, SubscribersActivity.class);
        startActivity(intent);
    }
}
