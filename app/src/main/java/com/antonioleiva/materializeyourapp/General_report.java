package com.antonioleiva.materializeyourapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by kishan on 7/1/2016.
 */
public class General_report extends AppCompatActivity {
Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ui);
        toolbar = (Toolbar) findViewById(R.id.tool_bar1);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backarrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setTitle("General Report");


    }
}
