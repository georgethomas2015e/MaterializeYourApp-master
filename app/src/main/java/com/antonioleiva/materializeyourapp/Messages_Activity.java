package com.antonioleiva.materializeyourapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.materialdesign.model.commonMsgData_model;
import com.materialdesign.myapplicationmaterial.restintrection.Base64Coder;
import com.materialdesign.myapplicationmaterial.restintrection.GlobalData;
import com.materialdesign.myapplicationmaterial.restintrection.ParsingJSon;
import com.materialdesign.myapplicationmaterial.restintrection.Util;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import dmax.dialog.SpotsDialog;


/**
 * Created by kishan on 6/9/2016.
 */
public class Messages_Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
     private RecyclerView.LayoutManager layoutManager;
    Messages_adapter adapter;
    private AlertDialog progressDialog;
    String projectid,projectname;
    TextView tv_projectname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages_activity);
        toolbar = (Toolbar) findViewById(R.id.tool_bar1);
        tv_projectname=(TextView)findViewById(R.id.project_nameId);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_backarrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        getSupportActionBar().setTitle("Project Messages");

        recyclerView = (RecyclerView) findViewById(R.id.messageslist_id);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        projectid= getIntent().getStringExtra("projectId");
        projectname=getIntent().getStringExtra("projectName");
        tv_projectname.setText(projectname);

        sendRequest();

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if (Util.isDeviceOnline(Messages_Activity.this)) {
                            commonMsgData_model cm = new commonMsgData_model();
                            cm.setMessagebody(adapter.data3.get(position).getMessagebody());
                            cm.setMessagedate(adapter.data3.get(position).getPostedOn());
                            cm.setMessagetitle(adapter.data3.get(position).getMessagetitle());
                            cm.setMsgauthoravator(adapter.data3.get(position).getAuthoravatorurl());
                            cm.setMsgauthorfname(adapter.data3.get(position).getAuthorfirstname());
                            cm.setMsgauthorlname(adapter.data3.get(position).getAuthorlastname());
                            saveObject(cm);


                            Intent nt = new Intent(Messages_Activity.this, DetailsMessage.class);
                            nt.putExtra("messageId", adapter.data3.get(position).getMessageId());
                            // nt.putExtra("messagetitle",adapter.data3.get(position).getMessagetitle());
                            // nt.putExtra("messagedate",adapter.data3.get(position).getPostedOn());
                            // nt.putExtra("messageauthorfname",adapter.data3.get(position).getAuthorfirstname());
                            // nt.putExtra("messageauthorlname",adapter.data3.get(position).getAuthorlastname());
                            // nt.putExtra("messagebody",adapter.data3.get(position).getMessagebody());
                            //  nt.putExtra("messageauthoravator",adapter.data3.get(position).getAuthoravatorurl());
                            startActivity(nt);
                            // TODO Handle item click
                        }

                     else {
                            Util.showMessageDialog(Messages_Activity.this,"Network Connection Error!!");
                        }

                    }
                })
        );

    }
    public void saveObject(commonMsgData_model p){
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/sdcard/save_object.bin"))); //Select where you wish to save the file...
            oos.writeObject(p); // write the class as an 'object'
            oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
            oos.close();// close the stream
        }
        catch(Exception ex)
        {
            Log.v("Serialization Error : ", ex.getMessage());
            ex.printStackTrace();
        }
    }
    private void sendRequest() {
        progressDialog = new SpotsDialog(Messages_Activity.this, R.style.Custom);
        progressDialog.show();
        String url = "http://proman.oliveglobal.com/projects/" + projectid + "/posts.json";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();

                        ParsingJSon pj = new ParsingJSon(response);
                        pj.parseJSON(response);
                     adapter = new Messages_adapter(Messages_Activity.this,
                                R.layout.submsglist_item, GlobalData.messagelist);
                        if(GlobalData.messagelist.isEmpty()){

                            Util.showMessageDialog(Messages_Activity.this, "NO Messages!!");

                        }else {
                            recyclerView.setAdapter(adapter);
                        }
                       /* adapter = new Messages_adapter(adapter.data3);
                        recyclerView.setAdapter(adapter);*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                })

        {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                String APIKey = GlobalData.loginkey;
                String userpassword = APIKey + ":" + "";
                String encodedAuthorization = Base64Coder.encodeString(userpassword);
                headers.put("Authorization", "Basic " + encodedAuthorization);
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }



}
