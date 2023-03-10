package com.example.newsapp;

import com.example.newsapp.Models.News_Headlines;

import java.util.List;

public interface OnFetchDataListener<api_response> {
    void onFetchData(List<News_Headlines> list, String message);
    void onError(String message);


}
