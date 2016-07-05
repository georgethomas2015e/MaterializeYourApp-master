package com.antonioleiva.materializeyourapp;

import android.app.ProgressDialog;
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
    private Restintrection restInteraction;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());



        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (Util.isDeviceOnline(Messages_Activity.this)) {

                            // TODO Handle item click
                        } else {
                            Util.showMessageDialog(Messages_Activity.this, "Network Connection Error!!");
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

            restInteraction.getprojectlist();

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