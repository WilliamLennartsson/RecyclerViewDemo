package com.example.recyclerviewdemo;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    // Ref to dataSource
    private ArrayList<User> userList;

    // Varaible to store itemClickListener
    private OnItemClickListener onItemClickListener;

    // Constructor
    public UserAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    // Setter for onItemClickListener
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item, parent, false);
        // Create viewHolder
        UserAdapter.UserViewHolder viewHolder = new UserAdapter.UserViewHolder(view, onItemClickListener);
        return viewHolder;
        // return new UserAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        // Finds correct user
        User user = userList.get(position);
        // Pass user to viewHolder to connect user data to views
        holder.setUpViews(user);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // Custom onItemClick interface
    interface OnItemClickListener {
        void onItemClick(int position, View v);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        // Refs to views
        public TextView textViewUserName;
        public TextView textViewLastActive;
        public UserViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewUserName = itemView.findViewById(R.id.textViewUserName);
            textViewLastActive = itemView.findViewById(R.id.textViewLastActive);
            // Handle onClick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    /* Log.d("Will", "Position: " + position);
                    int color = Color.parseColor("#ff00ff");
                    v.setBackgroundColor(color); */

                    if (listener != null) {
                        if (position != RecyclerView.NO_POSITION) {
                            // Call custom onItemClick
                            listener.onItemClick(position, v);
                        }
                    }
                }
            });
        }
        // Maps a user to a listItem
        public void setUpViews(User user) {
            textViewUserName.setText(user.getUserName());
            textViewLastActive.setText(user.getLastActive());
        }
    }

}







