package com.example.shree.materialdesign8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

public class SelectTest extends AppCompatActivity {


    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner8;
    private Spinner spinner7;
    private EditText editText;
    private DataObject a,b,c,d,e,f,g;

    private static final String PATH_TO_SERVER = "http://35.154.210.22/dpts/api/getAlltest.php";
    protected List<DataObject> spinnerData;
    //volly   queue responce  add
    private RequestQueue queue2;
    private RequestQueue queue3;
    private RequestQueue queue4;
    private RequestQueue queue5;
    private RequestQueue queue6;
    private RequestQueue queue7;
    private RequestQueue queue8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_select_test);

        editText=(EditText)findViewById(R.id.editTexttestadd);

        queue2 = Volley.newRequestQueue(this);
        queue3 = Volley.newRequestQueue(this);
        queue4 = Volley.newRequestQueue(this);
        queue5 = Volley.newRequestQueue(this);
        queue6 = Volley.newRequestQueue(this);
        queue7 = Volley.newRequestQueue(this);
        queue8 = Volley.newRequestQueue(this);


        requestJsonObject2();
        requestJsonObject3();
        requestJsonObject4();
        requestJsonObject5();
        requestJsonObject6();
        requestJsonObject7();
        requestJsonObject8();


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
                    SpinnerAdapter2 spinnerAdapter = new SpinnerAdapter2(SelectTest.this,spinnerData);
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
                    SpinnerAdapter3 spinnerAdapter = new SpinnerAdapter3(SelectTest.this,spinnerData);
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
                    SpinnerAdapter4 spinnerAdapter = new SpinnerAdapter4(SelectTest.this,spinnerData);
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


    private void requestJsonObject5(){
        RequestQueue queue5 = Volley.newRequestQueue(this);
        StringRequest stringRequest5 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner5 = (Spinner) findViewById(R.id.spinner5);
                    assert spinner5 != null;
                    spinner5.setVisibility(View.VISIBLE);
                    SpinnerAdapter5 spinnerAdapter = new SpinnerAdapter5(SelectTest.this,spinnerData);
                    spinner5.setAdapter(spinnerAdapter);

                    spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            d= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=d.getName();

                          //  Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    d= (DataObject) ( spinner5 = (Spinner) findViewById(R.id.spinner5) ).getSelectedItem();
                    d.getName();
                   // Toast.makeText(getApplication(),"you "+d.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue5.add(stringRequest5);
    }


    private void requestJsonObject6(){
        RequestQueue queue6 = Volley.newRequestQueue(this);
        StringRequest stringRequest6 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner6 = (Spinner) findViewById(R.id.spinner6);
                    assert spinner6 != null;
                    spinner6.setVisibility(View.VISIBLE);
                    SpinnerAdapter6 spinnerAdapter = new SpinnerAdapter6(SelectTest.this,spinnerData);
                    spinner6.setAdapter(spinnerAdapter);

                    spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            e= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=e.getName();

                            //Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    e= (DataObject) ( spinner6 = (Spinner) findViewById(R.id.spinner6) ).getSelectedItem();
                    e.getName();
                   // Toast.makeText(getApplication(),"you "+e.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue6.add(stringRequest6);
    }

    private void requestJsonObject7(){
        RequestQueue queue7 = Volley.newRequestQueue(this);
        StringRequest stringRequest7 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner7 = (Spinner) findViewById(R.id.spinner7);
                    assert spinner7 != null;
                    spinner7.setVisibility(View.VISIBLE);
                    SpinnerAdapter7 spinnerAdapter = new SpinnerAdapter7(SelectTest.this,spinnerData);
                    spinner7.setAdapter(spinnerAdapter);

                    spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            f= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=f.getName();

                           // Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    f= (DataObject) ( spinner7 = (Spinner) findViewById(R.id.spinner7) ).getSelectedItem();
                    f.getName();
                    //Toast.makeText(getApplication(),"you "+f.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue7.add(stringRequest7);
    }



    private void requestJsonObject8(){
        RequestQueue queue8 = Volley.newRequestQueue(this);
        StringRequest stringRequest8 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner8 = (Spinner) findViewById(R.id.spinner8);
                    assert spinner8 != null;
                    spinner8.setVisibility(View.VISIBLE);
                    SpinnerAdapter8 spinnerAdapter = new SpinnerAdapter8(SelectTest.this,spinnerData);
                    spinner8.setAdapter(spinnerAdapter);

                    spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            g= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=g.getName();

                           // Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    g= (DataObject) ( spinner8 = (Spinner) findViewById(R.id.spinner8) ).getSelectedItem();
                    g.getName();
                    //Toast.makeText(getApplication(),"you "+g.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue8.add(stringRequest8);
    }

}

