package com.example.shree.materialdesign8;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shree.materialdesign8.vinod.confirmation.ConfirmationMassage;
import com.example.shree.materialdesign8.vinod3.selectTestDisease.SelectDTest1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PatientInfo extends AppCompatActivity implements View.OnClickListener,Imageutils.ImageAttachmentListener {
    private  String b;
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
private DataObject d,f;
    private Spinner spinner;
    private Spinner spinner1;
    String count;
    String a1;



    private static final String PATH_TO_SERVER = "http://35.154.210.22/dpts/api/getAlltest.php";
    protected List<DataObject> spinnerData;
    //volly   queue responce  add
    private RequestQueue queue;
    private RequestQueue queue1;


    ImageView iv_attachment;
    ProgressDialog loading;
    //For Image Attachment
    private Bitmap bitmap;
    private String file_name;
    Imageutils imageutils;


    public static final String UPLOAD_URL = "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/upload1.php";
    public static final String UPLOAD_KEY = "image";
    public static final String ref = "ref";
    public static final String specility="specility";
    public static final String email="email";
    public static final String address="address";
    public static final String dieses="dieses";
    public static final String mobile="mobile";
    public static final String name="name";
    public static String items = "items";
    public static String items1 = "items1";
    String n1,m,a,e;
    private Button buttonUpload;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.patient_info);

        //Initializing Views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
      //  editTextPassword = (EditText) findViewById(R.id.editTextPassword);
      //  editTextEmail = (EditText) findViewById(R.id.editTextEmail);
                n1=editTextName.getText().toString();
                m=editTextUsername.getText().toString();
              //  a=editTextPassword.getText().toString();
            //    e=editTextEmail.getText().toString();
         editTextName.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i=new Intent(PatientInfo.this, SelectDTest1.class);
                 startActivity(i);
             }
         });
         /*Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Toast.makeText(getApplicationContext(),"selected item :"+arg2,Toast.LENGTH_LONG);


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
//       items = spinner.getSelectedItem().toString();
      //  Toast.makeText(PatientInfo.this, ""+spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),"selected item :"+arg2,Toast.LENGTH_LONG);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

         //items1 = spinner.getSelectedItem().toString();

*/
       buttonUpload = (Button) findViewById(R.id.buttonUpload);
        //Adding listener to button
        buttonUpload.setOnClickListener(this);



        queue = Volley.newRequestQueue(this);
        queue1 = Volley.newRequestQueue(this);
        requestJsonObject();
        requestJsonObject1();



        imageutils =new Imageutils(this);
        iv_attachment=(ImageView)findViewById(R.id.imageView);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
      /*  iv_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageutils.imagepicker(1);
            }
        });*/
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // uploadImage();
                Intent I=new Intent(PatientInfo.this,ConfirmationMassage.class);
                startActivity(I);
            }
        });

    }


    private void requestJsonObject(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                spinner = (Spinner) findViewById(R.id.spinner);
                //display first question to the user
                if(null != spinnerData){

                    assert spinner != null;
                    spinner.setVisibility(View.VISIBLE);
                    SpinnerAdapter spinnerAdapter = new SpinnerAdapter(PatientInfo.this,spinnerData);
                    spinner.setAdapter(spinnerAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        final    String selected1 = parent.getItemAtPosition(position).toString();
                           // String Text = String.valueOf(selected1.getSelectedItem());
                          //  String value = String.valueOf(selected1.getString(0));

                            d= (DataObject) parent.getItemAtPosition(position);
                            String a= spinner.getItemAtPosition(position).toString();
                            String item = String.valueOf(parent.getItemAtPosition(position));
                           String p= item.toString();
                            final String name1=d.getName();

                           // Toast.makeText(getApplicationContext(),"you selected"+name1.toString(),Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                   final String city= spinner.getSelectedItem().toString();
                //    Toast.makeText(getApplicationContext(),"you selected"+city.toString(),Toast.LENGTH_LONG).show();

                    d = (DataObject) ( spinner = (Spinner) findViewById(R.id.spinner) ).getSelectedItem();
                    d.getName();
                    Toast.makeText(getApplication(),"you selected "+d.getName(),Toast.LENGTH_LONG).show();
                    //    Toast.makeText(getApplication(),"you"+b,Toast.LENGTH_LONG).show();
                   /* String Text = String.valueOf(spinner.getSelectedItem());
                    Toast.makeText(getApplication(),"you"+Text.toString(),Toast.LENGTH_LONG).show();*/
                 /* a1=spinner.getSelectedItem().toString();
*/
//
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }

    private void requestJsonObject1(){
        RequestQueue queue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if(null != spinnerData){
                    spinner1 = (Spinner) findViewById(R.id.spinner1);
                    assert spinner1 != null;
                    spinner1.setVisibility(View.VISIBLE);
                    SpinnerAdapter1 spinnerAdapter = new SpinnerAdapter1(PatientInfo.this,spinnerData);
                    spinner1.setAdapter(spinnerAdapter);

                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        final    String selected = parent.getItemAtPosition(position).toString();
                            String p1=selected.toString();
                            f= (DataObject) parent.getItemAtPosition(position);
                            final String spin1=f.getName();

                            //Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                           // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    f = (DataObject) ( spinner1 = (Spinner) findViewById(R.id.spinner1) ).getSelectedItem();
                    f.getName();
                    Toast.makeText(getApplication(),"you "+f.getName(),Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue1.add(stringRequest1);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp = ((BitmapDrawable) iv_attachment.getDrawable()).getBitmap();
        bmp.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {
        this.bitmap=file;
        this.file_name=filename;
        iv_attachment.setImageBitmap(file);

        String path =  Environment.getExternalStorageDirectory() + File.separator + "Hospital" + File.separator;
        imageutils.createImage(file,filename,path,false);
    }
    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {


            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PatientInfo.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                loading.dismiss();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(PatientInfo.this);

                // Setting Dialog Title
                alertDialog.setTitle("Your Information...");

                // Setting Dialog Message
                alertDialog.setMessage("Your Data is Inserted");

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.save);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed YES button. Write Logic Here

                     /*  Intent i=new Int ent(Main2Activity.this,ActivityMenuList.class);
                        startActivity(i);*/
                        Toast.makeText(getApplicationContext(),"thanks",Toast.LENGTH_LONG).show();
                    }
                });

                /*// Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed No button. Write Logic Here
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    }
                });*/

                // Setting Netural "Cancel" Button
                alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed Cancel button. Write Logic Here
                        Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                // String uploadImage = image_attachment(0,null,bitmap,Uri);
                String uploadImage = getStringImage(bitmap);
                Random rand = new Random();

                int  n = rand.nextInt(00145) + 1;

                 count=String.valueOf(n);
                 //   String n2= n1.toString();
                String n1=editTextName.getText().toString();
                String a=editTextUsername.getText().toString();
                String m=editTextPassword.getText().toString();
               // String e=editTextEmail.getText().toString();


            /* final  String s1= spinner.getSelectedItem().toString();
              final  String s2= spinner1.getSelectedItem().toString();*/
               // spinner.getSelectedItem().toString();



               // final  String s1=spinner.getSelectedItem().toString();



                //    Toast.makeText(getApplication(),"you"+b,Toast.LENGTH_LONG).show();

               final String s2=spinner1.getSelectedItem().toString();

                HashMap<String,String> data = new HashMap<>();

                data.put(UPLOAD_KEY, uploadImage);
                data.put(ref,count);
                data.put(name,n1);
                data.put(address,a);
                data.put(mobile,m);
               // data.put(email,e);
                data.put(dieses,d.getName());
                data.put(specility,f.getName());


                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }


    //Overriding onclick method
    @Override
    public void onClick(View view)
    {
        //insertUser();
        Intent I=new Intent(PatientInfo.this,ConfirmationReport.class);
        startActivity(I);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        imageutils.onActivityResult(requestCode, resultCode, data);

    }


}
