


package com.example.myapplicationtest1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    //    List<Item2> Mdata;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageView icon = findViewById(R.id.icon);
//        Glide.with(this).load(R.drawable.icon).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(icon);
        init();


//        RequestOptions options = new RequestOptions().error(R.drawable.phone);
//        Glide.with(this).load(R.drawable.phone).apply(options).into(imageView);


/*
            TextView name1 = findViewById(R.id.textView7);
            name1.setText(item1.name1);
            TextView name2 = findViewById(R.id.textView8);
            name2.setText(item1.name2);
            TextView description = findViewById(R.id.textView9);
            description.setText(item1.description);
            TextView price = findViewById(R.id.textView10);
            price.setText(item1.price);
            TextView purchase = findViewById(R.id.textView11);
            purchase.setText(item1.purchase);
            System.out.println("purchase的值为："+item1.imageUrl);

    */

//        TextView product_name = findViewById(R.id.textView1);
//
//
//        TextView price = findViewById(R.id.textview2);


    }







/*

 private String jsonData = "[\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"苹果手机\",\n" +
            "    \"name2\": \"ipone11\",\n" +
            "    \"description\": \"iphone手机最新款\",\n" +
            "    \"price\": \"5999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"华为手机\",\n" +
            "    \"name2\": \"mate40\",\n" +
            "    \"description\": \"8+256版本\",\n" +
            "    \"price\": \"6999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"小米手机\",\n" +
            "    \"name2\": \"小米12\",\n" +
            "    \"description\": \"全网通\",\n" +
            "    \"price\": \"3999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"魅族手机\",\n" +
            "    \"name2\": \"meizu\",\n" +
            "    \"description\": \"12+256全网通\",\n" +
            "    \"price\": \"2999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"三星手机\",\n" +
            "    \"name2\": \"Galaxy\",\n" +
            "    \"description\": \"全网通\",\n" +
            "    \"price\": \"5999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"imageUrl\": \"http://static.runoob.com/images/demo/demo2.jpg\",\n" +
            "    \"name1\": \"这是一个标题：锤子手机\",\n" +
            "    \"name2\": \"ipone\",\n" +
            "    \"description\": \"iphone手机最新款\",\n" +
            "    \"price\": \"5999\",\n" +
            "    \"purchase\": \"下单\"\n" +
            "  }\n" +
            "]";

*/


    private String PhoneData = "\n" +
            "[{\n" +
            "\"product_name\":\"apple watch\",\n" +
            "\"price\":\"$62.7\"\n" +
            "\n" +
            "},\n" +
            "{\n" +
            "\"product_name\":\"小米 watch\",\n" +
            "\"price\":\"$1.7\"\n" +
            "\n" +
            "},\n" +
            "{\n" +
            "\"product_name\":\"华为 watch\",\n" +
            "\"price\":\"$2.7\"\n" +
            "\n" +
            "},\n" +
            "{\n" +
            "\"product_name\":\"荣耀 watch\",\n" +
            "\"price\":\"$3\"\n" +
            "\n" +
            "},\n" +
            "{\n" +
            "\"product_name\":\"OPPO watch\",\n" +
            "\"price\":\"$12.7\"\n" +
            "\n" +
            "},\n" +
            "{\n" +
            "\"product_name\":\"Vivo watch\",\n" +
            "\"price\":\"$32.7\"\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]\n";


    void init() {

        recyclerView = findViewById(R.id.recyclerView);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Item2>>() {
        }.getType();
        List<Item2> mData = gson.fromJson(PhoneData, type);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new SimplePaddingDecoration(this));
        myAdapter = new MyAdapter();
        myAdapter.setData(mData);
        recyclerView.setAdapter(myAdapter);


        myAdapter.notifyDataSetChanged();

    }

    public class SimplePaddingDecoration extends RecyclerView.ItemDecoration {
        private int height;


        public SimplePaddingDecoration(Context context) {
            height = 50;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = height;



        }
    }


}






/*

    void init() {

        recyclerView = findViewById(R.id.recyclerView);

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Item1>>() {
        }.getType();
        List<Item> mData = gson.fromJson(jsonData, type);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        myAdapter = new MyAdapter();
        myAdapter.setData(mData);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}

*/



