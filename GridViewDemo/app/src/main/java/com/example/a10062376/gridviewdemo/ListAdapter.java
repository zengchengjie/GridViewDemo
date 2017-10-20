package com.example.a10062376.gridviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10062376 on 2017/10/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    private Context context;
    private List<MyBean> list = new ArrayList<>();

    public ListAdapter(Context context, List<MyBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.relativeLayout.getLayoutParams();
        if (getItemCount() == 2) {
            params.height = 300;
            holder.relativeLayout.setLayoutParams(params);
        } else if (getItemCount() > 2) {
            params.height = 200;
            holder.relativeLayout.setLayoutParams(params);
        }

        MyBean bean=list.get(position);
        if(bean!=null){
            if (bean.isOnline){
                holder.relativeLayout.setBackgroundResource(R.color.red);
                holder.textView.setText("视频未连接");
            }else {
                holder.relativeLayout.setBackgroundResource(R.color.green);
                holder.textView.setText("视频已连接");
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvItem);
            relativeLayout = itemView.findViewById(R.id.rlItem);
        }
    }
}
