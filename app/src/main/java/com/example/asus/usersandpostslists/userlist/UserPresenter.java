package com.example.asus.usersandpostslists.userlist;


import com.example.asus.usersandpostslists.data.Repository;
import com.example.asus.usersandpostslists.data.local.model.User;
import com.example.asus.usersandpostslists.data.remote.ApiResult;

import java.util.List;


public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;
    private Repository repository;

    public UserPresenter(UserContract.View view) {

        this.view = view;
        repository = new Repository();
    }

    @Override
    public void onLoadUser() {

        view.showProgressBar();

        repository.getUsers(new ApiResult<List<User>>() {
            @Override
            public void onSuccess(List<User> result) {
                view.hideProgressBar();
                view.showUserList(result);
            }

            @Override
            public void onFail() {
                view.showErrorMessage();
            }
        });
    }

}
