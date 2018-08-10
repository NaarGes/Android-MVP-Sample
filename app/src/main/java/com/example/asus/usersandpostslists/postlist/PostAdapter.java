package com.example.asus.usersandpostslists.postlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.usersandpostslists.R;
import com.example.asus.usersandpostslists.data.local.model.Post;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;

    public PostAdapter(List<Post> dataList){
        this.postList = dataList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View result = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new PostViewHolder(result);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView body;

        PostViewHolder(View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.post_title_item);
            body = itemView.findViewById(R.id.post_body_item);
        }

        public void onBind(Post post) {

            title.setText(post.getTitle());
            body.setText(post.getBody());
        }
    }
}
