package com.antonioleiva.materializeyourapp;

/**
 * Created by kishan on 7/6/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class recyclerview1_adapter extends RecyclerView.Adapter<recyclerview1_adapter.MyViewHolder> {
    Context _context;
    public ArrayList<recyclerview1_model> data1;
    private int resId;

    public recyclerview1_adapter(Context context, int textViewResourceId,
                            ArrayList<recyclerview1_model> objects) {
        //super(context, textViewResourceId, objects);
        _context = context;
        data1 = objects;
        resId = textViewResourceId;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time_days;
        TextView calldtalk_days;
        TextView calldbtnttalk_days;
        TextView mailsent_days;
        TextView mailrecieved_days;
        TextView message_days;
        TextView others_days;
        TextView total_days;



        public MyViewHolder(View view) {
            super(view);
            this.time_days = (TextView) view
                    .findViewById(R.id.txt_timedays);
            this.calldtalk_days = (TextView) view
                    .findViewById(R.id.txt_calndtlkdays);
            this.calldbtnttalk_days = (TextView) view
                    .findViewById(R.id.txt_clbutnttalkdays);
            this.mailsent_days = (TextView) view
                    .findViewById(R.id.txt_mailsentdays);
            this.mailrecieved_days = (TextView) view
                    .findViewById(R.id.txt_mailrecievedays);
            this.message_days = (TextView) view
                    .findViewById(R.id.txt_messgedays);
            this.others_days = (TextView) view
                    .findViewById(R.id.txt_othersdays);
            this.total_days = (TextView) view
                    .findViewById(R.id.txt_totaldays);

        }
    }

    public recyclerview1_adapter(ArrayList<recyclerview1_model> data) {
        this.data1 = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview1_listitem, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TextView time_days=holder.time_days;
        TextView calldtalk_days=holder.calldtalk_days;
        TextView calldbtnttalk_days=holder.calldbtnttalk_days;
        TextView mailsent_days=holder.mailsent_days;
        TextView mailrecieved_days=holder.mailrecieved_days;
        TextView message_days=holder.message_days;
        TextView others_days=holder.others_days;
        TextView total_days=holder.total_days;

        time_days.setText(data1.get(position).getTime());
        calldtalk_days.setText(data1.get(position).getCalledtalked());
        calldbtnttalk_days.setText(data1.get(position).getCallnttalk());
        mailsent_days.setText(data1.get(position).getMailsent());
        mailrecieved_days.setText(data1.get(position).getMailreceived());
        message_days.setText(data1.get(position).getMessage());
        others_days.setText(data1.get(position).getOther());
        total_days.setText(data1.get(position).getTotal());


    }

    @Override
    public int getItemCount() {
        return data1.size();
    }
}