package com.antonioleiva.materializeyourapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kishan on 7/5/2016.
 */
public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyViewHolder> {
    Context _context;
    public ArrayList<Messages_Model> data3;
    private int resId;
    public Recycler_adapter(Context context, int textViewResourceId,
                            ArrayList<Messages_Model> objects) {
        //super(context, textViewResourceId, objects);
        _context = context;
        data3 = objects;
        resId = textViewResourceId;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView authorname;
        TextView messagetitle;
        TextView messagebody;
        TextView date;
        ImageView authoravatorurl;


        public MyViewHolder(View view) {
            super(view);
            this.authorname = (TextView) view
                    .findViewById(R.id.txt_name);
            this.messagetitle = (TextView) view
                    .findViewById(R.id.msg_Title);
            this.messagebody = (TextView) view
                    .findViewById(R.id.msg_body);
            this.date = (TextView) view
                    .findViewById(R.id.msg_date);
            this.authoravatorurl=(ImageView) view.findViewById(R.id.authormsgimage);
        }
    }

    public Messages_adapter(ArrayList<Messages_Model> data) {
        this.data3 = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.submsglist_item, parent, false);



        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TextView authorname=holder.authorname;
        TextView messagetitle=holder.messagetitle;
        TextView messagebody=holder.messagebody;
        TextView date=holder.date;
        ImageView authoravatorurl=holder.authoravatorurl;

        String name=data3.get(position).getAuthorfirstname()+" "+data3.get(position).getAuthorlastname();
        authorname.setText(name);
        messagetitle.setText(data3.get(position).getMessagetitle());
        messagebody.setText(data3.get(position).getMessagebody());
        String date1=data3.get(position).getPostedOn();
        String date2 =date1.substring(5);
        date.setText(date2);
        Glide.with(MyApplication.getContext())
                .load(data3.get(position).getAuthoravatorurl())
                .into(authoravatorurl);
    }

    @Override
    public int getItemCount() {
        return data3.size();
    }
}
