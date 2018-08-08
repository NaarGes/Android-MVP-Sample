package com.example.asus.usersandpostslists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.usersandpostslists.userlist.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserFragment userFragment = UserFragment.newInstance();
        getSupportFragmentManager().beginTransaction().addToBackStack("user fragment")
                .replace(R.id.main_container, userFragment).commit();
    }
}
