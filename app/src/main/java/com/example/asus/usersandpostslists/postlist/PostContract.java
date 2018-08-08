package com.example.asus.usersandpostslists.postlist;

import com.example.asus.usersandpostslists.data.local.model.Post;

import java.util.List;

public interface PostContract {

    interface View {

        void showProgressBar();
        void hideProgressBar();

        void showPostList(List<Post> posts);
        void showErrorMessage();
    }

    interface Presenter {

        List<Post> onLoadPost(int userId);
    }
}
