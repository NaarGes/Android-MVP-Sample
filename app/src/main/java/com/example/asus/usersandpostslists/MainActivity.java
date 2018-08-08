package com.example.asus.usersandpostslists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.usersandpostslists.data.local.model.Post;
import com.example.asus.usersandpostslists.postlist.PostFragment;
import com.example.asus.usersandpostslists.userlist.UserFragment;

public class MainActivity extends AppCompatActivity implements TransferBetweenFragments {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserFragment userFragment = UserFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, userFragment).commit();
    }

    @Override
    public void goFromUserToPost(int userID) {

        PostFragment postFragment = PostFragment.newInstance(userID);
        getSupportFragmentManager().beginTransaction().addToBackStack("post fragment")
                .replace(R.id.main_container, postFragment).commit();

    }
}
