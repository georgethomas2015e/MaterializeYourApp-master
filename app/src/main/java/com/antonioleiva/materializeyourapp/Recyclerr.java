
package com.antonioleiva.materializeyourapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by kishan on 7/5/2016.
 */

public class Recyclerr extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    // String year="",team_individual="",user="", type="";
    String yearr="",team_individuall="",userr="", typee="",customerID="",username="";
    public static boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        //year=getIntent().getStringExtra("yeark");
        // team_individual=getIntent().getStringExtra("teamindi_rdk");
        //user=getIntent().getStringExtra("userk");
        // type=getIntent().getStringExtra("typek");


        if(flag=false){
            yearr=getIntent().getStringExtra("yeark");
            team_individuall=getIntent().getStringExtra("teamindi_rdk");
            if(getIntent().getStringExtra("userk").equals("Select Username")){
                userr="";
            }
            else {
                userr=getIntent().getStringExtra("userk");
            }
            typee=getIntent().getStringExtra("typek");
            customerID=Globaldata.customerid;
            username=Globaldata.username;
        }

        else {
            yearr="2016";
            team_individuall="Individual";
            userr="";
            typee="All";
            customerID=Globaldata.customerid;
            username=Globaldata.username;

        }
       /* if(!year.equals("2016")){
            //team_individual(add to name value pair)
        }
        else {

        }

        if(team_individual.equals("")){

        }
   else {
            //team_individual(add to name value pair)
        }
        if(user.equals("Select Username")||user.equals("")){

        }
        else {
            //team_individual(add to name value pair)
        }
        if(type.equals("Select Type")||type.equals("")){

        }
        else {
            //team_individual(add to name value pair)
        }*/




        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (Util.isDeviceOnline(Recyclerr.this)) {

                            Intent nt = new Intent(Recyclerr.this, testingcapture.class);
                            nt.putExtra("year", yearr);
                            nt.putExtra("team_individual", team_individuall);
                            nt.putExtra("user", userr);
                            nt.putExtra("type", typee);
                            nt.putExtra("Month",month);
                            // nt.putExtra("messageId", adapter.data3.get(position).getMessageId());
                            // TODO Handle item click
                        } else {
                            Util.showMessageDialog(Recyclerr.this, "Network Connection Error!!");
                        }

                    }
                })
        );
    }




    public class allgeneralreport extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // Util.showProDialog(getActivity(), "Loading....");
            // progressDialog = new SpotsDialog(getActivity(),R.style.Custom);
            progressDialog.show();
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            getprojectlist();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Util.dimissProDialog();
            progressDialog.dismiss();
            mainadapter1 = new projectlist_adapter(getActivity(),
                    R.layout.projects_listitem, GlobalData.projectlist);
            lv.setAdapter(mainadapter1);




        }
    }



}
