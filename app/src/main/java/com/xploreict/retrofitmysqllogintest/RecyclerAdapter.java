package com.xploreict.retrofitmysqllogintest;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myviewholder>{

    List<fetchdatamodel> data;

    public RecyclerAdapter(List<fetchdatamodel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.myviewholder holder, int position) {
        holder.t1.setText(data.get(position).getName());
        holder.t2.setText(data.get(position).getDesignation());
        Glide.with(holder.t1.getContext()).load("https://android.gadgetlab.store/images/"+data.get(position).getImages()).centerCrop().into(holder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView t1,t2;
        ImageView img;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.tv1);
            t2 = itemView.findViewById(R.id.tv2);
            img = itemView.findViewById(R.id.img);
        }
    }
}
