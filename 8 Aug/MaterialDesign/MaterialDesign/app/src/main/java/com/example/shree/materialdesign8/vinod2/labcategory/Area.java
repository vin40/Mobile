package com.example.shree.materialdesign8.vinod2.labcategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shree.materialdesign8.DataObject;
import com.example.shree.materialdesign8.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class Area extends AppCompatActivity {
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;

    private DataObject a,b,c;

    private static final String PATH_TO_SERVER = "http://35.154.210.22/dpts/api/getAlltest.php";
    protected List<DataObject> spinnerData;
    //volly   queue responce  add

    private RequestQueue queue2;
    private RequestQueue queue3;
    private RequestQueue queue4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_area);

        queue2 = Volley.newRequestQueue(this);
        queue3 = Volley.newRequestQueue(this);
        queue4 = Volley.newRequestQueue(this);



        requestJsonObject2();
        requestJsonObject3();
        requestJsonObject4();

        Button b2=(Button)findViewById(R.id.back);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intentbb=new Intent(getApplicationContext(),LabCategoty.class);
                startActivity(intentbb);
            }
        });
    }

    private void requestJsonObject2()
    {
        RequestQueue queue2 = Volley.newRequestQueue(this);
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner2 = (Spinner) findViewById(R.id.spinner2);
                    assert spinner2 != null;
                    spinner2.setVisibility(View.VISIBLE);
                    SpinnertAAdapter2 spinnerAdapter = new SpinnertAAdapter2(Area.this,spinnerData);
                    spinner2.setAdapter(spinnerAdapter);

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            a= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=a.getName();

                            //Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    a = (DataObject) ( spinner2 = (Spinner) findViewById(R.id.spinner2) ).getSelectedItem();
                    a.getName();
                    //Toast.makeText(getApplication(),"you "+a.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue2.add(stringRequest2);
    }

    private void requestJsonObject3(){
        RequestQueue queue3 = Volley.newRequestQueue(this);
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner3 = (Spinner) findViewById(R.id.spinner3);
                    assert spinner3 != null;
                    spinner3.setVisibility(View.VISIBLE);
                    SpinnertAAdapter3 spinnerAdapter = new SpinnertAAdapter3(Area.this,spinnerData);
                    spinner3.setAdapter(spinnerAdapter);

                    spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            b= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=b.getName();

                            //Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    b = (DataObject) ( spinner3 = (Spinner) findViewById(R.id.spinner3) ).getSelectedItem();
                    b.getName();
                    //Toast.makeText(getApplication(),"you "+b.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue3.add(stringRequest3);
    }

    private void requestJsonObject4(){
        RequestQueue queue4 = Volley.newRequestQueue(this);
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner4 = (Spinner) findViewById(R.id.spinner4);
                    assert spinner4 != null;
                    spinner4.setVisibility(View.VISIBLE);
                    SpinnertAAdapter4 spinnerAdapter = new SpinnertAAdapter4(Area.this,spinnerData);
                    spinner4.setAdapter(spinnerAdapter);

                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            c= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=c.getName();

                            // Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    c = (DataObject) ( spinner4 = (Spinner) findViewById(R.id.spinner4) ).getSelectedItem();
                    c.getName();
                    //Toast.makeText(getApplication(),"you "+c.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue4.add(stringRequest4);
    }
}
