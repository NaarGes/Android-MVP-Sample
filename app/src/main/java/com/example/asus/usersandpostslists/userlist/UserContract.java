package com.example.asus.usersandpostslists.userlist;

import com.example.asus.usersandpostslists.data.local.usermodel.User;

import java.util.List;

public interface UserContract {

    interface View {

        void showProgressBar();
        void hideProgressBar();
        void showUserList();
        void showErrorMessage();
    }

    interface Presenter {

        List<User> onLoadUser();
    }
}
