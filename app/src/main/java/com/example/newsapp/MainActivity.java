package com.example.newsapp;

import android.os.Bundle;

import com.example.newsapp.Models.News_Headlines;
import com.example.newsapp.Models.api_response;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.newsapp.ui.main.SectionsPagerAdapter;
import com.example.newsapp.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener,"General",null);
    }
    private final OnFetchDataListener<api_response> listener = new OnFetchDataListener<api_response>() {
        @Override
        public void onFetchData(List<News_Headlines> list, String message) {
            showNews(list);

        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<News_Headlines> list) {
        recyclerView = findViewById(R.id.main_container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new CustomAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }
}