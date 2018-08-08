package com.example.asus.usersandpostslists.userlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.usersandpostslists.R;
import com.example.asus.usersandpostslists.data.local.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> userList;

    public UserAdapter() {

    }

    public UserAdapter(List<User> dataList) {
        this.userList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new MyViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(userList.get(position).getName());
        holder.userEmail.setText(userList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {

        if(userList == null)
            return 0;
        return userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private TextView userEmail;

        MyViewHolder(View itemView) {

            super(itemView);
            userName = itemView.findViewById(R.id.user_name);
            userEmail = itemView.findViewById(R.id.user_email);

        }
    }
}
