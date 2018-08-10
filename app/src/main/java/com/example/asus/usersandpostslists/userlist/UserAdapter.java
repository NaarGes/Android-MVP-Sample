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
    private OnUserClickListener listener;

    public UserAdapter() {

    }

    public UserAdapter(List<User> dataList, OnUserClickListener listener) {
        this.userList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new MyViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.onBind(userList.get(position));
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

        public void onBind(User user) {

            userName.setText(user.getName());
            userEmail.setText(user.getEmail());
            final int userID = user.getId();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUserClick(userID);
                }
            });
        }
    }
}
