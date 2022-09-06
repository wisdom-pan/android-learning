package com.example.myappchapter9_2;

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
