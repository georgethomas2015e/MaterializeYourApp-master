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

public class Recyclerview2 extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    recyclerview2_adapter mainadapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview2);

        recyclerView = (RecyclerView) findViewById(R.id.genreport_dateslist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        generalreportDate gd= new generalreportDate();
        gd.execute();


        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        if (Util.isDeviceOnline(Recyclerview2.this)) {

                            // TODO Handle item click
                        } else {
                            //Util.showMessageDialog(Messages_Activity.this, "Network Connection Error!!");
                        }

                    }
                })
        );
    }




    public class generalreportDate extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            // Util.showProDialog(getActivity(), "Loading....");
            // progressDialog = new SpotsDialog(getActivity(),R.style.Custom);
            progressDialog.show();
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            getgenreportlist_date();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Util.dimissProDialog();
            progressDialog.dismiss();
            mainadapter1 = new recyclerview1_adapter(Recyclerview2.this,
                    R.layout.recyclerview2_listitem, GlobalData.projectlist);
            recyclerView.setAdapter(mainadapter1);




        }
    }



}

