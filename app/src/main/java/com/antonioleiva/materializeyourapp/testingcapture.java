package com.antonioleiva.materializeyourapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

/**
 * Created by kishan on 7/7/2016.
 */
public class testingcapture extends AppCompatActivity {

    Spinner year_spin,user_spin,type_spin;
    RadioGroup rdgrp_temindi;
    RadioButton rdbtn_team,rdbtn_individual,radioButton;
    Button submit_filterbtn;
    String year,user,type,team_or_indi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);

        year_spin=(Spinner)findViewById(R.id.year_spin);
        user_spin=(Spinner)findViewById(R.id.user_spin);
        type_spin=(Spinner)findViewById(R.id.type_spin);
        rdgrp_temindi=(RadioGroup)findViewById(R.id.rdgrp_temindi);
        rdbtn_team=(RadioButton)findViewById(R.id.rdbtn_team);
        rdbtn_individual=(RadioButton)findViewById(R.id.rdbtn_individual);
        submit_filterbtn=(Button)findViewById(R.id.submit_filterbtn);
        submit_filterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year  = year_spin.getSelectedItem().toString();
                user  = user_spin.getSelectedItem().toString();
                type  = type_spin.getSelectedItem().toString();

                if (rdgrp_temindi.getCheckedRadioButtonId() == -1)
                {
                    int selectedId = rdgrp_temindi.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioButton = (RadioButton) findViewById(selectedId);
                    team_or_indi=radioButton.getText().toString();
                }
                else
                {
                   team_or_indi="";
                }

                Intent inte= new Intent(testingcapture.this,Recyclerview1.class);
                inte.putExtra("yeark",year);
                inte.putExtra("userk",user);
                inte.putExtra("typek",type);
                inte.putExtra("teamindi_rdk",team_or_indi);
                startActivity(inte);



            }
        });


    }

    public class generalreportDays extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
           Util.showProDialog(testingcapture.this, "Loading....");
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

           getgenreportlist_days();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
           Util.dimissProDialog();
            user_spin.setAdapter(new ArrayAdapter<String>(testingcapture.this, android.R.layout.simple_spinner_dropdown_item, students));


        }
    }



}
