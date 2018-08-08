package com.example.asus.usersandpostslists.userlist;

import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

public interface UserContract {

    interface View {

        void showProgressBar();
        void hideProgressBar();
        void showUserList(List<User> users);
        void showErrorMessage();
    }

    interface Presenter {

        List<User> onLoadUser();
    }
}
