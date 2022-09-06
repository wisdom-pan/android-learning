package com.example.myappchapter9_2;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {

        //网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    //从服务端请求数据
                    connection.setRequestMethod("GET");
                    /**
                     * 向服务端提交数据，键值对格式
                     *  connection.setRequestMethod("POST");
                     *  DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                     *  out.writeBytes("tip=http访问网络学习&date=2022.08.10");
                     *
                     */
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    //读取输入流
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    //请求结束
                    if (listener != null){
                        listener.onFinish(response.toString());
                    }


                } catch (Exception e) {
                    if (listener != null){
                        listener.onError(e);
                    }

                } finally {
                    //断开连接
                    if (connection != null) {
                        connection.disconnect();

                    }

                }

            }
        }).start();
    }
    public static void sendOKHttpRequest(final String address,final okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

}
