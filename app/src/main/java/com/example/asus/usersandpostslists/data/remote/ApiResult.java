package com.example.asus.usersandpostslists.data.remote;

import com.example.asus.usersandpostslists.data.local.model.Post;
import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

public interface ApiResult<T> {

    void onSuccess(T result);
    void onFail();

}
