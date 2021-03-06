package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyForums extends AppCompatActivity {

    private static RecyclerView mRecyclerView;
    private static MyForumsDataAdapter mAdapter;
    private  static RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<DiscussionThread> myForums;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        // Need to search for current user
        ThreadSearcher.setSearchMode("CREATOR");
        // Bump order by default
        Sorter.setSortMode("TIME");
        Sorter.setReverse(true);
        myForums = ThreadSearcher.search(ClientCommunicator.getUsername());
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyForumsDataAdapter(myForums);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        final ArrayList<DiscussionThread> finalForumEvents = myForums;

        mAdapter.setOnItemClickListener(new MyForumsDataAdapter.OnItemClickListener() {
            public void onItemClick(int position) {
                Intent intent2 = new Intent(MyForums.this, ExpandForum.class);
                intent2.putExtra("ForumThread", finalForumEvents.get(position));
                startActivity(intent2);
            }

            @Override
            public void onDeleteClick(int position) {
                ClientCommunicator.deleteThread(finalForumEvents.get(position));
                finish();
                startActivity(new Intent(MyForums.this, MyForums.class));
            }
        });
    }
}
