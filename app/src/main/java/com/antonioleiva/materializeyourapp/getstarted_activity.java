package com.antonioleiva.materializeyourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kishan on 5/5/2016.
 */
public class getstarted_activity extends AppCompatActivity {

    Button getstartedbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getstarted_activity);
        getstartedbtn= (Button)findViewById(R.id.getstrtdbtn);
        getstartedbtn= (Button)findViewById(R.id.getstrtdbtn);
        getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getstarted_activity.this,LoginActivity.class);
                startActivity(in);
            }
        });
    }
}
