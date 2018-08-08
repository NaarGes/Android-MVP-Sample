package com.example.asus.usersandpostslists.data.remote;

import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/users")
    Call<List<User>> getAllUsers();

}
