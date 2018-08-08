package com.example.asus.usersandpostslists.userlist;


import com.example.asus.usersandpostslists.data.UserRepository;
import com.example.asus.usersandpostslists.data.local.model.User;
import com.example.asus.usersandpostslists.data.remote.ApiResult;

import java.util.List;


public class UserPresenter implements UserContract.Presenter {


    private UserContract.View view;
    private UserRepository userRepository;

    public UserPresenter(UserContract.View view) {

        this.view = view;
        userRepository = new UserRepository();
    }

    @Override
    public List<User> onLoadUser() {

        view.showProgressBar();

        List<User> users;
        users = userRepository.getUsers(new ApiResult() {
            @Override
            public void onSuccess(List<User> users) {
                view.hideProgressBar();
                view.showUserList();
            }

            @Override
            public void onFail() {
                view.showErrorMessage();
            }
        });
        return users;

    }

}
