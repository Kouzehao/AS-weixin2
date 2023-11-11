package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.Myholder> {

    Context context1;
    List<String> list1;
    OnItemClickListener listener;


    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public Myadapter(Context context,List list) {
        context1=context;
        list1=list;
        mListener = listener;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context1).inflate(R.layout.item,parent,false);
        Myholder holder = new Myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(list1.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null) {
                    mListener.onItemClick(position);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView6);
        }
    }
}