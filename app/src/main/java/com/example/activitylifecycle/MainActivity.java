package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int REQUEST_FOURACTIVITY_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("gp","onCreate");

        findViewById(R.id.btn_start_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_three_activity).setOnClickListener(this);
        findViewById(R.id.btn_start_four_activity).setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("gp","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("gp","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("gp","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("gp","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("gp","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("gp","onRestart");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_start_activity:
                Intent intent = new Intent(this,SecondActivity.class);

                intent.putExtra("parameter","第二个Activity参数");
                startActivity(intent);
                break;
            case R.id.btn_start_three_activity:
                Intent threeIntent = new Intent(this,ThreeActivity.class);
                threeIntent.putExtra("parameter","第三个Activity参数");
                startActivity(threeIntent);
                break;
            case R.id.btn_start_four_activity:
                Intent fourIntent = new Intent(this,FourActivity.class);
                fourIntent.putExtra("parameter","第四个Activity参数");
                startActivity(fourIntent);
                startActivityForResult(fourIntent,REQUEST_FOURACTIVITY_CODE);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_FOURACTIVITY_CODE && resultCode == RESULT_OK){
            String resultStr = data.getStringExtra("result");
            Log.i("gp",resultStr);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}