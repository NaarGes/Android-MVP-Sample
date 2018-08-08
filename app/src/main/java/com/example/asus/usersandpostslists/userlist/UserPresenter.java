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
    public List<User> onLoadUser() {

        view.showProgressBar();

        List<User> users;
        users = repository.getUsers(new ApiResult.UserResults() {
            @Override
            public void onSuccess(List<User> users) {
                view.hideProgressBar();
                view.showUserList(users);
            }

            @Override
            public void onFail() {
                view.showErrorMessage();
            }
        });
        return users;

    }

}
