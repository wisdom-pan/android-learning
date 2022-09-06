package com.example.myappchapter9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send_request) {

            //http原生实现
            //sendRequestWithHttpURLConnection();
            //okhttp实现
            sendRequestWithOkHttp();


        }

    }


    //http请求原生实现
    private void sendRequestWithHttpURLConnection() {
        //网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.nowcoder.com/");
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
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }

            }
        }).start();
    }

    private void sendRequestWithOkHttp() {
        //网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://www.nowcoder.com/")
                            .build();

                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
                    //从服务端请求数据


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    private void showResponse(final String resopnse) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //子线程更新ui
                responseText.setText(resopnse);
            }
        });
    }
}