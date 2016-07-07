package com.antonioleiva.materializeyourapp;

/**
 * Created by kishan on 7/6/2016.
 */
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

public class Recyclerview1 extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    recyclerview1_adapter mainadapter1;
    String year="",team_individual="",user="", type="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview1);


        year=getIntent().getStringExtra("yeark");
        team_individual=getIntent().getStringExtra("teamindi_rdk");
        user=getIntent().getStringExtra("userk");
        type=getIntent().getStringExtra("typek");


        if(year.equals("")){

        }
        else {
            //team_individual(add to name value pair)
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
        }









        recyclerView = (RecyclerView) findViewById(R.id.genreport_dayslist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
generalreportDays gd= new generalreportDays();
        gd.execute();


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (Util.isDeviceOnline(Recyclerview1.this)) {

                            // TODO Handle item click
                        } else {
                            //Util.showMessageDialog(Messages_Activity.this, "Network Connection Error!!");
                        }

                    }
                })
        );
    }




    public class generalreportDays extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // Util.showProDialog(getActivity(), "Loading....");
            // progressDialog = new SpotsDialog(getActivity(),R.style.Custom);
            progressDialog.show();
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            getgenreportlist_days();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Util.dimissProDialog();
            progressDialog.dismiss();
            mainadapter1 = new recyclerview1_adapter(Recyclerview1.this,
                    R.layout.recyclerview1_listitem, GlobalData.projectlist);
            recyclerView.setAdapter(mainadapter1);




        }
    }



}

