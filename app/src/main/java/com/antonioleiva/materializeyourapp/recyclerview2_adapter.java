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


public class recyclerview2_adapter extends RecyclerView.Adapter<recyclerview2_adapter.MyViewHolder> {
    Context _context;
    public ArrayList<recyclerview2_model> data4;
    private int resId;

    public recyclerview2_adapter(Context context, int textViewResourceId,
                                 ArrayList<recyclerview2_model> objects) {
        //super(context, textViewResourceId, objects);
        _context = context;
        data4 = objects;
        resId = textViewResourceId;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time_date;
        TextView calldtalk_date;
        TextView calldbtnttalk_date;
        TextView mailsent_date;
        TextView mailrecieved_date;
        TextView message_date;
        TextView others_date;
        TextView total_date;



        public MyViewHolder(View view) {
            super(view);
            this.time_date = (TextView) view
                    .findViewById(R.id.txt_timedate);
            this.calldtalk_date = (TextView) view
                    .findViewById(R.id.txt_calndtlkdate);
            this.calldbtnttalk_date = (TextView) view
                    .findViewById(R.id.txt_clbutnttalkdate);
            this.mailsent_date = (TextView) view
                    .findViewById(R.id.txt_mailsentdate);
            this.mailrecieved_date = (TextView) view
                    .findViewById(R.id.txt_mailrecievedate);
            this.message_date = (TextView) view
                    .findViewById(R.id.txt_messgedate);
            this.others_date = (TextView) view
                    .findViewById(R.id.txt_othersdate);
            this.total_date = (TextView) view
                    .findViewById(R.id.txt_totaldate);

        }
    }

    public recyclerview2_adapter(ArrayList<recyclerview2_model> data) {
        this.data4 = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview2_listitem, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        TextView time_date=holder.time_date;
        TextView calldtalk_date=holder.calldtalk_date;
        TextView calldbtnttalk_date=holder.calldbtnttalk_date;
        TextView mailsent_date=holder.mailsent_date;
        TextView mailrecieved_date=holder.mailrecieved_date;
        TextView message_date=holder.message_date;
        TextView others_date=holder.others_date;
        TextView total_date=holder.total_date;

        time_date.setText(data4.get(position).getTime());
        calldtalk_date.setText(data4.get(position).getCalledtalked());
        calldbtnttalk_date.setText(data4.get(position).getCallnttalk());
        mailsent_date.setText(data4.get(position).getMailsent());
        mailrecieved_date.setText(data4.get(position).getMailreceived());
        message_date.setText(data4.get(position).getMessage());
        others_date.setText(data4.get(position).getOther());
        total_date.setText(data4.get(position).getTotal());


    }

    @Override
    public int getItemCount() {
        return data4.size();
    }
}
