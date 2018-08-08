package com.example.asus.usersandpostslists.data.remote;

import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

public interface ApiResult {

    void onSuccess(List<User> users);
    void onFail();
}
