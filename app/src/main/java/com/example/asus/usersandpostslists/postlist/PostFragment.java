package com.example.asus.usersandpostslists.postlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asus.usersandpostslists.R;
import com.example.asus.usersandpostslists.data.local.model.Post;

import java.util.List;


public class PostFragment extends Fragment implements PostContract.View {

    private PostContract.Presenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar spinner;
   
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    public static PostFragment newInstance(int userId) {
        
        Bundle args = new Bundle();
        args.putInt("user id" ,userId);
        PostFragment fragment = new PostFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new PostPresenter(this);

        spinner = view.findViewById(R.id.post_progress_bar);
        recyclerView = view.findViewById(R.id.post_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        presenter.onLoadPost(getArguments().getInt("user id"));

    }

    @Override
    public void showProgressBar() {

      spinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {

      spinner.setVisibility(View.GONE);
    }

    @Override
    public void showPostList(List<Post> posts) {

        PostAdapter adapter = new PostAdapter(posts);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage() {

        Toast.makeText(this.getContext(),"Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
    }
}
