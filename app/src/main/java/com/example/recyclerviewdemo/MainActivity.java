package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserAdapter.OnItemClickListener {
    // RecyclerView
    private RecyclerView userRecyclerView;
    // Adapter
    private UserAdapter adapter;
    // DataSource
    private ArrayList<User> users = new ArrayList<>();

    private Button addUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Add new user button
        addUserButton = findViewById(R.id.addNewUserBtn);
        // Add button onClickListener
        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });
        // Create users
        createUsers();
        // Connect recyclerView with xml
        userRecyclerView = findViewById(R.id.userRecyclerView);
        // Create adapter
        adapter = new UserAdapter(users);
        // Set adapter
        userRecyclerView.setAdapter(adapter);
        // Set OnItemClickListener
        adapter.setOnItemClickListener(this);
        // Alternative way of setting onItemClickListener if the class doesnt implement the UserAdapter.OnItemClickListener interface
        /*adapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                User user = users.get(position);
                Log.d("Will", user.getUserName());
                user.setUserName("HALLÅÅÅÅ");
                adapter.notifyItemChanged(position);
            }
        });*/
        // LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(5, LinearLayoutManager.HORIZONTAL);
        userRecyclerView.setLayoutManager(layoutManager);
    }

    private void addNewUser() {
        User newUser = new User("New user", "3 days ago");
        users.add(0, newUser);
        adapter.notifyItemInserted(0);
    }

    private void deleteUser() {
        users.remove(0);
        adapter.notifyItemRemoved(0);
    }

    private void createUsers() {
        for (int i = 0; i < 7; i++) {
            users.add(new User("User " + i, i % 4 + " days ago"));
        }
    }

    @Override
    public void onItemClick(int position, View v) {
        User user = users.get(position);
        Log.d("Will", user.getUserName());
        user.setUserName("HALLÅÅÅÅ");
        // int color = Color.parseColor("#ff00ff");
        // v.setBackgroundColor(color);
        adapter.notifyItemChanged(position);
    }
}







