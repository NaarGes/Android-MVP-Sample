package com.example.asus.usersandpostslists.postlist;

import com.example.asus.usersandpostslists.data.Repository;
import com.example.asus.usersandpostslists.data.local.model.Post;
import com.example.asus.usersandpostslists.data.remote.ApiResult;

import java.util.List;

public class PostPresenter implements PostContract.Presenter {

    private PostContract.View view;
    private Repository repository;

    public PostPresenter(PostContract.View view) {

        this.view = view;
        repository = new Repository();
    }

    @Override
    public void onLoadPost(int userId) {

        view.showProgressBar();

        repository.getPosts(new ApiResult<List<Post>>() {
            @Override
            public void onSuccess(List<Post> posts) {
                view.hideProgressBar();
                view.showPostList(posts);
            }

            @Override
            public void onFail() {
                view.showErrorMessage();
            }
        }, userId);

    }
}
