package com.example.asus.usersandpostslists.userlist;


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

import com.example.asus.usersandpostslists.MainActivity;
import com.example.asus.usersandpostslists.R;
import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;


public class UserFragment extends Fragment implements UserContract.View {

    private UserContract.Presenter presenter;
    private RecyclerView recyclerView;
    private ProgressBar spinner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    public static UserFragment newInstance() {
        
        Bundle args = new Bundle();
        
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new UserPresenter(this);

        spinner = view.findViewById(R.id.user_progress_bar);
        recyclerView = view.findViewById(R.id.user_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        presenter.onLoadUser();
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
    public void showUserList(List<User> users) {

        UserAdapter adapter = new UserAdapter(users, new OnUserClickListener() {
            @Override
            public void onUserClick(int userID) {
                ((MainActivity) (getActivity())).goFromUserToPost(userID);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage() {

        Toast.makeText(this.getContext(),"Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

    }
}
