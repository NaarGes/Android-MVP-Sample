package com.example.asus.usersandpostslists.data;

import com.example.asus.usersandpostslists.data.local.usermodel.User;
import com.example.asus.usersandpostslists.data.remote.ApiClient;
import com.example.asus.usersandpostslists.data.remote.ApiResult;
import com.example.asus.usersandpostslists.data.remote.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// repository is used for preparing data
// it will decide to prepare online or offline

public class UserRepository {

    private List<User> users;

    public UserRepository() {
    }

    public List<User> getUsers(final ApiResult callback) {

        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        retrofit2.Call<List<User>> call = service.getAllUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()) {
                    users = response.body();
                    callback.onSuccess(users);
                } else {
                    callback.onFail();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                callback.onFail();
            }
        });
        return users;
    }
}
