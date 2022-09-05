package com.example.myapplicationtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item2> mData;
    //多个布局type
    public static final int TYPE_item1 = 0;
    public static final int TYPE_item2 = 1;

    public void setData(List<Item2> items) {
        this.mData = items;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        //        TextView name1;
//        TextView name2;
//        TextView description;
//        TextView price;
//        TextView purchase;
        TextView product_name1;
        TextView price1;
        TextView product_name2;
        TextView price2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_name1 = itemView.findViewById(R.id.textView1);
            price1 = itemView.findViewById(R.id.textView2);
            product_name2 = itemView.findViewById(R.id.textView3);
            price2 = itemView.findViewById(R.id.textView4);

//            description = itemView.findViewById(R.id.textView9);
//            price = itemView.findViewById(R.id.textView10);
//            purchase = itemView.findViewById(R.id.textView11);
        }

    }
    public static class LastViewHolder extends RecyclerView.ViewHolder{
        public LastViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }


    @Override
    public int getItemViewType(int position) {
//        Item2 item2 = mData.get(position);
        if (position % 2 == 0){
            return TYPE_item1;
        }
        else{return TYPE_item2;}

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //从item_layout创建VIEW
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layoutdemo, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;

        //多个item viewtype
        View inflate;
        RecyclerView.ViewHolder holder = null;
        if(viewType == TYPE_item1){
            inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layoutdemo, parent, false);
            return new ViewHolder(inflate);
        }
        else{
            inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new LastViewHolder(inflate);
        }




    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //给每个item绑定数据
        Item2 item2 = mData.get(position);
        if (item2 == null) {
            return;
        }
        if (holder instanceof MyAdapter.ViewHolder) {
//            ((ViewHolder) holder).name1.setText(item2.getName1());
//            ((ViewHolder) holder).name2.setText(item2.getName2());
//            ((ViewHolder) holder).description.setText(item2.getDescription());
            ((ViewHolder) holder).product_name1.setText(item2.getProduct_name());
            ((ViewHolder) holder).price1.setText(item2.getPrice());
            ((ViewHolder) holder).product_name2.setText(item2.getProduct_name());
            ((ViewHolder) holder).price2.setText(item2.getPrice());

        }


    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}


