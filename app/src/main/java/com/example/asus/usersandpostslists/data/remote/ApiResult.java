package com.example.asus.usersandpostslists.data.remote;

import com.example.asus.usersandpostslists.data.local.model.Post;
import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

public interface ApiResult {

    interface UserResults {

        void onSuccess(List<User> users);
        void onFail();
    }

    interface PostResults {

        void onSuccess(List<Post> posts);
        void onFail();
    }

}
