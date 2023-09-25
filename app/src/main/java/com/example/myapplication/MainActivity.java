package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.fragments.FirstFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> users = new ArrayList<User>();
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new FirstFragment(), "first_fragment")
                .commit();
    }

    private void setInitialData() {
        users.add(new User("Dota 2", 2000, R.drawable.dota));
        users.add(new User("CSGO", 2015, R.drawable.csgo));
        users.add(new User("CS 2", 2025, R.drawable.cs));
        users.add(new User("Valorant", 2020, R.drawable.valorant));
    }
}

