package com.example.threadupdateui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textview;

    public static final int UPDATE_UI=1;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==UPDATE_UI){
                textview.setText("当前值是:"+msg.obj);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler.post(runnable);//执行
        handler.postDelayed(runnable,2000);

        Log.i("MainActivity","当前线程id:"+Thread.currentThread().getId());

        textview= (TextView) findViewById(R.id.textview);
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i=1;i<=100;i++){
                    Log.i("MainActivity","当前值是:"+i);
                    Message message=handler.obtainMessage();
                    message.what=UPDATE_UI;
                    message.obj=i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Log.i("MainActivity","Handler Runnable 当前线程id:"+Thread.currentThread().getId());
        }
    };
}