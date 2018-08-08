package com.example.asus.usersandpostslists.data.remote;

import com.example.asus.usersandpostslists.data.local.model.Post;
import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/users")
    Call<List<User>> getAllUsers();

    @GET("/posts")
    Call<List<Post>> getUserPosts(@Query("userId") int userId);

}
