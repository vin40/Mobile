package com.example.shree.materialdesign8.vinod.navigationdrawer;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shree.materialdesign8.AlertDialogRadio2;

import com.example.shree.materialdesign8.DataObject;
import com.example.shree.materialdesign8.DataObject1;
import com.example.shree.materialdesign8.ImageAttachment;
import com.example.shree.materialdesign8.Imageutils;
import com.example.shree.materialdesign8.Login;
import com.example.shree.materialdesign8.Main4Activity;
import com.example.shree.materialdesign8.Notification2;
import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.RequestHandler;
import com.example.shree.materialdesign8.SpinnerAdapter;
import com.example.shree.materialdesign8.SpinnerAdapter1;


import com.example.shree.materialdesign8.SpinnerAdapter9;
import com.example.shree.materialdesign8.adapter.Internet_Connection;
import com.example.shree.materialdesign8.allocator.activity.ActivityCategoryList;
import com.example.shree.materialdesign8.allocator.activity.NamePatient;
import com.example.shree.materialdesign8.allocator.activity.RefUploadPhoto1;
import com.example.shree.materialdesign8.allocator.activity.TodaysPatient;
import com.example.shree.materialdesign8.vinod.SqliteFav.SQLiteHelper;
import com.example.shree.materialdesign8.vinod.SqliteFav.ShowDb;
import com.example.shree.materialdesign8.vinod.confirmation.ConfirmationMassage;
import com.example.shree.materialdesign8.vinod.confirmation.ConfirmationMassagePhoto;
import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation;
import com.example.shree.materialdesign8.vinod10.SqliteFav.Fav5;
import com.example.shree.materialdesign8.vinod10.SqliteFav.ShowDb5;
import com.example.shree.materialdesign8.vinod11.editprofile.EditProfile;
import com.example.shree.materialdesign8.vinod11.editprofile.RegisterProfile;
import com.example.shree.materialdesign8.vinod2.labcategory.LabCategoty;
import com.example.shree.materialdesign8.vinod2.labcategory.Thankyou;
import com.example.shree.materialdesign8.vinod3.selectTestDisease.SelectDTest;
import com.example.shree.materialdesign8.vinod3.selectTestDisease.SelectDTest1;
import com.example.shree.materialdesign8.vinod4.setfavorite.SetFavorite;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.HttpServicesClass;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter1;


import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapterArea;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapterCity;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapterState;
import com.example.shree.materialdesign8.vinod7.sqlFav.ShowDb2;
import com.example.shree.materialdesign8.vinod8.sqliteFav.ShowDb3;
import com.example.shree.materialdesign8.vinod9.sqliteFav.ShowDb4;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.example.shree.materialdesign8.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.guna.libmultispinner.MultiSelectionSpinner;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener,Imageutils.ImageAttachmentListener, AlertDialogRadio2.AlertPositiveListener2,MultiSelectionSpinner.OnMultipleItemsSelectedListener, AdapterView.OnItemSelectedListener {
    String Fav11, Fav12, Fav13, Fav14, Fav15;
    ProgressBar MobileProgressBar;
    SharedPreferences sharedPreferences;
    String HttpUrl = "http://35.154.210.22/dpts/api/onclickfilter/MobileData.php";
    List<String> MobileList = new ArrayList<String>();
    ArrayAdapter<String> MobileArrayAdapter;

    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;

    int position = 0;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5, floatingActionButton6;
    private String k;
    private TextView tv;
    private EditText editTextName;
    private AutoCompleteTextView acTextView, acTextView1, acTextView2;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private DataObject d, f;
    private Spinner spinner;
    private Spinner spinner1;
    String count;
    String a1, j, l;
    private DataObject1 d1, f1;
    Internet_Connection internet_conn;

    private static final String PATH_TO_SERVER = "http://35.154.210.22/dpts/api/getAlltest.php";
    private static final String PATH_TO_SERVER1 = "http://35.154.210.22/dpts/api/getallzipcode.php";
    protected List<DataObject> spinnerData;
    protected List<DataObject1> spinnerData1;
    //volly   queue responce  add
    private RequestQueue queue;
    private RequestQueue queue1;
    private RequestQueue queueCity;
    private RequestQueue queue1Area;


    ImageView iv_attachment;
    ProgressDialog loading;
    //For Image Attachment
    private Bitmap bitmap;
    private String file_name;
    Imageutils imageutils;

    public static final String UPLOAD_URL1 = "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/upload.php";
    public static final String UPLOAD_KEY1 = "image";


    public static final String UPLOAD_URL = "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/upload1.php";
    public static final String UPLOAD_KEY = "image";
    public static final String ref = "ref";
    public static final String specility = "specility";
    public static final String email = "email";
    public static final String address = "address";
    public static final String dieses = "dieses";
    public static final String mobile = "mobile";
    public static final String name = "name";
    public static String items = "items";
    public static String items1 = "items1";
    String n1, m, a, e;
    private Button buttonUpload, buttonUpload1;
    String email2;
   public static String autostate,autocity;
    //String  Doctname;
    LinearLayout recentadvice, cameradiscription;
    Spinner spinnerfav;
    TextView favraoutetitle;

    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        internet_conn = new Internet_Connection(getApplicationContext());

        tv = (TextView) findViewById(R.id.ptn);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);

        iv_attachment = (ImageView) findViewById(R.id.imageView);

        recentadvice = (LinearLayout) findViewById(R.id.recentadvice);
        cameradiscription = (LinearLayout) findViewById(R.id.cameradiscription);
        spinnerfav = (Spinner) findViewById(R.id.spinner2);
        favraoutetitle = (TextView) findViewById(R.id.favraoutetitle);

        //  editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        //  editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        n1 = editTextName.getText().toString();
        m = editTextUsername.getText().toString();
        /*String[] array = {"Blood test", "Skin test", "Allergy test", "X-ray test", "Arterigraphy test", "autopsy", "Digoxin"};
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
        multiSelectionSpinner.setItems(array);
        StringBuilder builder = new StringBuilder();

        multiSelectionSpinner.setSelection(new int[]{2, 5});

        multiSelectionSpinner.setListener(this);
*/
        //start it accept from otp

        //EditText fnameotp=(EditText)findViewById(R.id.editTextName);

        /*SharedPreferences prefs1 = getSharedPreferences(EditProfile.EDITPROFILE, MODE_PRIVATE);
        String restoredText1 = prefs1.getString("text1", null);
        Doctname = prefs1.getString("Doctorname", null);
        //int idName = 0;
        if (restoredText1 != null) {
            String name = prefs1.getString("Doctorname", "No name defined");//"No name defined" is the default value.
            //idName = prefs.getInt("idName", 0);
        }
        editTextName.setText(Doctname);*/


        //end (otp)
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        SharedPreferences prefs1 = getSharedPreferences(ShowDb.Fav1, MODE_PRIVATE);
        String restoredText1 = prefs1.getString("text", null);

        Fav11 = prefs1.getString("favrename", null);
        if (Fav11 == null) {
            Toast.makeText(Dashboard.this, "nothing set", Toast.LENGTH_LONG).show();
            Fav11 = "Favourite-1";
        } else {
            Fav11.toString();
        }

        SharedPreferences prefs2 = getSharedPreferences(ShowDb2.Fav2, MODE_PRIVATE);
        String restoredText2 = prefs2.getString("text", null);

        Fav12 = prefs2.getString("favrename", null);
        if (Fav12 == null) {
            Toast.makeText(Dashboard.this, "nothing set", Toast.LENGTH_LONG).show();
            Fav12 = "Favourite-2";
        } else {
            Fav12.toString();
        }

        SharedPreferences prefs3 = getSharedPreferences(ShowDb3.Fav3, MODE_PRIVATE);
        String restoredText3 = prefs3.getString("text", null);

        Fav13 = prefs3.getString("favrename", null);
        if (Fav13 == null) {
            Toast.makeText(Dashboard.this, "nothing set", Toast.LENGTH_LONG).show();
            Fav13 = "Favourite-3";
        } else {
            Fav13.toString();
        }

        SharedPreferences prefs4 = getSharedPreferences(ShowDb4.Fav4, MODE_PRIVATE);
        String restoredText4 = prefs4.getString("text", null);

        Fav14 = prefs4.getString("favrename", null);
        if (Fav14 == null) {
            Toast.makeText(Dashboard.this, "nothing set", Toast.LENGTH_LONG).show();
            Fav14 = "Favourite-4";
        } else {
            Fav14.toString();
        }

        SharedPreferences prefs5 = getSharedPreferences(ShowDb5.Fav5, MODE_PRIVATE);
        String restoredText5 = prefs5.getString("text", null);

        Fav15 = prefs5.getString("favrename", null);
        if (Fav15 == null) {
            Toast.makeText(Dashboard.this, "nothing set", Toast.LENGTH_LONG).show();
            Fav15 = "Favourite-5";
        } else {
            Fav15.toString();
        }

        List<String> categories = new ArrayList<String>();
        categories.add("Select-Category");
        categories.add(Fav11.toString());
        categories.add(Fav12.toString());
        categories.add(Fav13.toString());
        categories.add(Fav14.toString());
        categories.add(Fav15.toString());

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        Button addmoretest = (Button) findViewById(R.id.addmoretest);
        // a=editTextPassword.getText().toString();
        // e=editTextEmail.getText().toString();
        addmoretest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Dashboard.this, SelectDTest1.class);
                startActivity(i);
            }
        });

        final CheckBox satView = (CheckBox) findViewById(R.id.chk);
        satView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplication(), "checked", Toast.LENGTH_LONG).show();
                    View.OnClickListener listener1 = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //** Getting the fragment manager *//*
                            FragmentManager manager = getFragmentManager();

                            //** Instantiating the DialogFragment class *//*
                            AlertDialogRadio2 alert = new AlertDialogRadio2();


                            //** Creating a bundle object to store the selected item's index *//*
                            Bundle b = new Bundle();

                            //** Storing the selected item's index in the bundle object*//*
                            b.putInt("position", position);

                            //** Setting the bundle object to the dialog fragment object*//*
                            alert.setArguments(b);

                            //** Creating the dialog fragment object, which will in turn open the alert dialog window*//*
                            alert.show(manager, "alert_dialog_radio");
                        }


                    };
                    satView.setOnClickListener(listener1);
                } else {
                    Toast.makeText(getApplication(), "Unchecked", Toast.LENGTH_LONG).show();
                    satView.setChecked(false);
                }
            }
        });
        /*satView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                if (satView.isChecked())
                {
                    Toast.makeText(getApplication(), "checked", Toast.LENGTH_LONG).show();
                    View.OnClickListener listener1 = new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            *//** Getting the fragment manager *//*
                            FragmentManager manager = getFragmentManager();

                            *//** Instantiating the DialogFragment class *//*
                            AlertDialogRadio2 alert = new AlertDialogRadio2();

                            *//** Creating a bundle object to store the selected item's index *//*
                            Bundle b = new Bundle();

                            *//** Storing the selected item's index in the bundle object*//*
                            b.putInt("position", position);

                            *//** Setting the bundle object to the dialog fragment object*//*
                            alert.setArguments(b);

                            *//** Creating the dialog fragment object, which will in turn open the alert dialog window*//*
                            alert.show(manager, "alert_dialog_radio");
                        }


                    };
                    satView.setOnClickListener(listener1);
                } else {
                    Toast.makeText(getApplication(), "Unchecked", ToastacTextView.LENGTH_LONG).show();
                }
            }
        });*/
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
        //buttonUpload = (Button) findViewById(R.id.buttonUpload);
        //Adding listener to button


        queue = Volley.newRequestQueue(this);
        queue1 = Volley.newRequestQueue(this);


        requestJsonObject();

        //requestJsonObject1();


        imageutils = new Imageutils(this);
        iv_attachment = (ImageView) findViewById(R.id.imageView);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        buttonUpload1 = (Button) findViewById(R.id.buttonUpload1);
        iv_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageutils.imagepicker(1);
            }
        });
        buttonUpload.setOnClickListener(this);
        buttonUpload1.setOnClickListener(this);
        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (internet_conn.isConnectingToInternet() == true) {
                    String editTextName1 = editTextName.getText().toString();
                    String editTextUsername1 = editTextUsername.getText().toString();

                    String acTextView1 = acTextView.getText().toString();
                    // String zipcode=name1.toString();
                    String zipcode = d1.getPincode().toString();
                    if (editTextName.getText().toString().length() == 0 && editTextUsername.getText().toString().length() == 0 && acTextView.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();
                    } else {

                        //Converting phnumber to long type
                        //long phno = Long.parseLong(phnumber1);
                        //Creating Bundle object
                        // uploadImage();
                        //editTextUsername1;
                        String serverURL = "http://sujwalinsure.com/insure/ws/testmysmsapi.php?testname=Hemraj&mobileno="+editTextUsername1;

                        send_sms1(serverURL);
                       // send_sms(editTextUsername1);
                        Bundle k = new Bundle();

                        //Storing data into bundle
                        k.putString("pname", editTextName1);
                        k.putString("phnum", editTextUsername1);
                        k.putString("landmark", acTextView1);
                        k.putString("ZipCode", zipcode);
                        k.putString("abc", j.toString());
                        k.putString("notice", tv.getText().toString());
                        //Creating Intent object
                        Intent in = new Intent(Dashboard.this, ConfirmationMassage.class);
                        //Storing bundle object into intent
                        in.putExtras(k);
                        startActivity(in);

                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
                    builder.setTitle("PLease Check Internet");
                    builder.setCancelable(true);
                    builder.setMessage(getResources().getString(R.string.Internet));
                    builder.setPositiveButton("OK", null);
                    //builder.setNegativeButton("Cancel", null);
                    builder.show();
                }

                //  uploadImage();
            }
        });

        buttonUpload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (internet_conn.isConnectingToInternet() == true) {
                    if (editTextName.getText().toString().length() == 0 && editTextUsername.getText().toString().length() == 0 && acTextView.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();
                    } else {
                        uploadImage1();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
                    builder.setTitle("Please Check Internet");
                    builder.setCancelable(true);
                    builder.setMessage(getResources().getString(R.string.Internet));
                    builder.setPositiveButton("OK", null);
                    //builder.setNegativeButton("Cancel", null);
                    builder.show();
                }

            }
        });

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        //  floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        // floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item4);
        floatingActionButton5 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item5);
        floatingActionButton6 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item6);
       /* floatingActionButton1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //TODO something when floating action menu first item clicked
                Toast.makeText(Dashboard.this, "Patient1", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Dashboard.this,Login.class);

                startActivity(i);
            }
        });*/
       /* floatingActionButton2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //TODO something when floating action menu second item clicked
                Toast.makeText(Dashboard.this, "Patient2", Toast.LENGTH_SHORT).show();
                Intent patient=new Intent(Dashboard.this, PatientInfo.class);
                startActivity(patient);

            }
        });*/
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Toast.makeText(Dashboard.this, "Set Favourite", Toast.LENGTH_SHORT).show();
                Intent labcat = new Intent(Dashboard.this, SetFavorite.class);
                startActivity(labcat);
            }
        });
        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selecttest = new Intent(Dashboard.this, Dashboard.class);
                startActivity(selecttest);
                recentadvice.setVisibility(View.VISIBLE);
                spinnerfav.setVisibility(View.VISIBLE);

                cameradiscription.setVisibility(View.GONE);  //show layout2
                buttonUpload1.setVisibility(View.GONE);
                buttonUpload.setVisibility(View.VISIBLE);
                iv_attachment.setVisibility(View.GONE);
                floatingActionButton4.setVisibility(View.GONE);
                floatingActionButton5.setVisibility(View.VISIBLE);


            }
        });
        floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*String editTextName1 = editTextName.getText().toString();
                String editTextUsername1 = editTextUsername.getText().toString();

                String acTextView1 = acTextView.getText().toString();
                // String zipcode=name1.toString();
                String zipcode=d1.getPincode().toString();
                if (editTextName.getText().toString().length() == 0 && editTextUsername.getText().toString().length() == 0 && acTextView.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();
                } else {

                    //Converting phnumber to long type
                    //long phno = Long.parseLong(phnumber1);
                    //Creating Bundle object
                    Bundle b = new Bundle();

                    //Storing data into bundle
                    b.putString("pname", editTextName1);
                    b.putString("phnum", editTextUsername1);
                    b.putString("landmark", acTextView1);
                    b.putString("ZipCode",zipcode);
                    //Creating Intent object
                            Intent in = new Intent(Dashboard.this,RefUploadPhoto1.class);
                    //Storing bundle object into intent
                    in.putExtras(b);
                    startActivity(in);


                }
*/
                Intent in = new Intent(Dashboard.this, Dashboard.class);

                recentadvice.setVisibility(View.GONE);
                spinnerfav.setVisibility(View.GONE);
                favraoutetitle.setVisibility(View.GONE);
                cameradiscription.setVisibility(View.VISIBLE);  //show layout2
                buttonUpload.setVisibility(View.GONE);
                buttonUpload1.setVisibility(View.VISIBLE);
                iv_attachment.setVisibility(View.VISIBLE);
                floatingActionButton4.setVisibility(View.VISIBLE);
                floatingActionButton5.setVisibility(View.GONE);


            }
        });
        floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent setfav = new Intent(Dashboard.this, SelectDTest.class);
                startActivity(setfav);
            }
        });


        //set name on profile USING SHAREPREFERENCE

        SharedPreferences prefs = getSharedPreferences(Otp.OTP, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        email2 = prefs.getString("name", null);
        int idName = 0;
        if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            idName = prefs.getInt("idName", 0);
        }

        // editTextName.setText(email2);

        //set name end USING SHARD PREFERENCE

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*SharedPreferences profile = getSharedPreferences(UserInformation.user, MODE_PRIVATE);
        String profile1 = profile.getString("text", null);

        email2 = profile.getString("name1", null);*/

        SharedPreferences profile = getSharedPreferences(Login.user, MODE_PRIVATE);
        String profile1 = profile.getString("text", null);

        email2 = profile.getString("username", null);


        TextView txtProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textView);
        txtProfileName.setText("Hi " + email2);

        ImageView profilePictureView = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.circleView);

        Picasso.with(this)
                .load("http://35.154.210.22/dpts/doctor/ecommerce/upload/images/9524-2017-04-21.png")
                .placeholder(R.drawable.address)   // optional
                .error(R.drawable.jobb)      // optional
                .resize(200, 200)
                // .rotate(10)// optional
                .into(profilePictureView);


        acTextView = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        acTextView.setAdapter(new SuggestionAdapterState(this, acTextView.getText().toString()));

        acTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autostate = (String) parent.getItemAtPosition(position);
                Toast.makeText(Dashboard.this, "hi " + autostate, Toast.LENGTH_LONG).show();
                acTextView1.setVisibility(View.VISIBLE);

            }
        });

        acTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acTextView1.setVisibility(View.GONE);
                acTextView2.setVisibility(View.GONE);
                acTextView1.setText("");
                acTextView2.setText("");

            }
        });
//SuggestionAdapter1
        acTextView1 = (AutoCompleteTextView) findViewById(R.id.autoComplete1);
        acTextView1.setAdapter(new SuggestionAdapterCity(this, acTextView1.getText().toString()));

        acTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acTextView2.setVisibility(View.GONE);
               acTextView2.setText("");

            }
        });

        acTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                autocity = (String) parent.getItemAtPosition(position);
                Toast.makeText(Dashboard.this, "hi " + autocity, Toast.LENGTH_LONG).show();
                acTextView2.setVisibility(View.VISIBLE);
            }
        });

        acTextView2 = (AutoCompleteTextView) findViewById(R.id.autoComplet2);
        acTextView2.setAdapter(new SuggestionAdapterArea(this, acTextView2.getText().toString()));
        acTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        MobileProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        new GetHttpResponse(Dashboard.this).execute();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent ib = new Intent(Dashboard.this, Main4Activity.class);
            startActivity(ib);
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Specilist) {
            Intent i = new Intent(Dashboard.this, ActivityCategoryList.class);
            startActivity(i);
            //Handle the camera action
        } else if (id == R.id.nav_fontchange) {
            startActivity(new Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS));
        } else if (id == R.id.nav_EditProfile) {
            Intent editIntent = new Intent(Dashboard.this, RegisterProfile.class);
            startActivity(editIntent);
        } else if (id == R.id.nav_TodaysPatient) {
            Intent I = new Intent(Dashboard.this, TodaysPatient.class);
            startActivity(I);

        } else if (id == R.id.nav_PrivousHistory) {
            Intent i = new Intent(Dashboard.this, NamePatient.class);
            startActivity(i);

        } else if (id == R.id.nav_LabCategory) {
            Intent i = new Intent(Dashboard.this, LabCategoty.class);
            startActivity(i);
        } else if (id == R.id.nav_setFavourate) {
            Intent setfav = new Intent(Dashboard.this, SetFavorite.class);
            startActivity(setfav);

        } else if (id == R.id.nav_logout) {


            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Logout")
                    .setMessage("Are you sure you want to Logout?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent setfav = new Intent(Dashboard.this, Login.class);
                            startActivity(setfav);
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void requestJsonObject() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, PATH_TO_SERVER1, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData1 = Arrays.asList(mGson.fromJson(response, DataObject1[].class));
                spinner = (Spinner) findViewById(R.id.spinner);
                //display first question to the user
                if (null != spinnerData1) {

                    assert spinner != null;
                    spinner.setVisibility(View.VISIBLE);
                    SpinnerAdapter9 spinnerAdapter = new SpinnerAdapter9(Dashboard.this, spinnerData1);
                    spinner.setAdapter(spinnerAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            final String selected1 = parent.getItemAtPosition(position).toString();
                            // String Text = String.valueOf(selected1.getSelectedItem());
                            //  String value = String.valueOf(selected1.getString(0));

                            d1 = (DataObject1) parent.getItemAtPosition(position);
                            String a = spinner.getItemAtPosition(position).toString();
                            String item = String.valueOf(parent.getItemAtPosition(position));
                            String p = item.toString();
                            final String name1 = d1.getPincode();
                            Log.d("pincode id", d1.getId().toString());
                            //remmember this points
                            Toast.makeText(getApplicationContext(), "you selected" + name1.toString(), Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    final String city = spinner.getSelectedItem().toString();
                    //    Toast.makeText(getApplicationContext(),"you selected"+city.toString(),Toast.LENGTH_LONG).show();

                    d1 = (DataObject1) (spinner = (Spinner) findViewById(R.id.spinner)).getSelectedItem();
                    d1.getPincode();
                    Toast.makeText(getApplication(), "you selected " + d1.getPincode(), Toast.LENGTH_LONG).show();
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
        queue.add(stringRequest1);
    }

    private void requestJsonObject1() {
        RequestQueue queue1 = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, PATH_TO_SERVER, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData = Arrays.asList(mGson.fromJson(response, DataObject[].class));
                //display first question to the user
                if (null != spinnerData) {
                    spinner1 = (Spinner) findViewById(R.id.spinner1);
                    assert spinner1 != null;
                    spinner1.setVisibility(View.VISIBLE);
                    SpinnerAdapter1 spinnerAdapter = new SpinnerAdapter1(Dashboard.this, spinnerData);
                    spinner1.setAdapter(spinnerAdapter);

                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            final String selected = parent.getItemAtPosition(position).toString();
                            String p1 = selected.toString();
                            f = (DataObject) parent.getItemAtPosition(position);
                            final String spin1 = f.getName();

                            //Toast.makeText(getApplicationContext(),"you selected "+spin1.toString(),Toast.LENGTH_LONG).show();
                           /* String Text = selected.getSelectedItem().toString();
                            Toast.makeText(getApplicationContext(),"you selected"+Text.toString(),Toast.LENGTH_LONG).show();*/
                            // Toast.makeText(getApplicationContext(),"you selected"+p1,Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }


                    });

                    f = (DataObject) (spinner1 = (Spinner) findViewById(R.id.spinner1)).getSelectedItem();
                    f.getName();
                    Toast.makeText(getApplication(), "you " + f.getName(), Toast.LENGTH_LONG).show();
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue1.add(stringRequest1);
    }


    /*private void requestJsonObjectCity() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, PATH_TO_SERVER1, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData1 = Arrays.asList(mGson.fromJson(response, DataObject1[].class));
                spinner = (Spinner) findViewById(R.id.spinnerCity);
                //display first question to the user
                if (null != spinnerData1) {

                    assert spinner != null;
                    spinner.setVisibility(View.VISIBLE);
                    SpinnerAdapter9 spinnerAdapter = new SpinnerAdapter9(Dashboard.this, spinnerData1);
                    spinner.setAdapter(spinnerAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            final String selected1 = parent.getItemAtPosition(position).toString();
                            // String Text = String.valueOf(selected1.getSelectedItem());
                            //  String value = String.valueOf(selected1.getString(0));

                            d1 = (DataObject1) parent.getItemAtPosition(position);
                            String a = spinner.getItemAtPosition(position).toString();
                            String item = String.valueOf(parent.getItemAtPosition(position));
                            String p = item.toString();
                            final String name1 = d1.getPincode();
                            Log.d("pincode id",d1.getId().toString());
                            //remmember this points
                            Toast.makeText(getApplicationContext(),"you selected"+name1.toString(),Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    final String city = spinner.getSelectedItem().toString();
                    //    Toast.makeText(getApplicationContext(),"you selected"+city.toString(),Toast.LENGTH_LONG).show();

                    d1 = (DataObject1) (spinner = (Spinner) findViewById(R.id.spinner)).getSelectedItem();
                    d1.getPincode();
                    Toast.makeText(getApplication(), "you selected " + d1.getPincode(), Toast.LENGTH_LONG).show();
                    //    Toast.makeText(getApplication(),"you"+b,Toast.LENGTH_LONG).show();
                   *//* String Text = String.valueOf(spinner.getSelectedItem());
                    Toast.makeText(getApplication(),"you"+Text.toString(),Toast.LENGTH_LONG).show();*//*
                 *//* a1=spinner.getSelectedItem().toString();
*//*
//
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest1);
    }

*/
    /*private void requestJsonObjectArea() {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, PATH_TO_SERVER1, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();
                spinnerData1 = Arrays.asList(mGson.fromJson(response, DataObject1[].class));
                spinner = (Spinner) findViewById(R.id.spinnerArea);
                //display first question to the user
                if (null != spinnerData1) {

                    assert spinner != null;
                    spinner.setVisibility(View.VISIBLE);
                    SpinnerAdapter9 spinnerAdapter = new SpinnerAdapter9(Dashboard.this, spinnerData1);
                    spinner.setAdapter(spinnerAdapter);
                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            final String selected1 = parent.getItemAtPosition(position).toString();
                            // String Text = String.valueOf(selected1.getSelectedItem());
                            //  String value = String.valueOf(selected1.getString(0));

                            d1 = (DataObject1) parent.getItemAtPosition(position);
                            String a = spinner.getItemAtPosition(position).toString();
                            String item = String.valueOf(parent.getItemAtPosition(position));
                            String p = item.toString();
                            final String name1 = d1.getPincode();
                            Log.d("pincode id",d1.getId().toString());
                            //remmember this points
                            Toast.makeText(getApplicationContext(),"you selected"+name1.toString(),Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    final String city = spinner.getSelectedItem().toString();
                    //    Toast.makeText(getApplicationContext(),"you selected"+city.toString(),Toast.LENGTH_LONG).show();

                    d1 = (DataObject1) (spinner = (Spinner) findViewById(R.id.spinner)).getSelectedItem();
                    d1.getPincode();
                    Toast.makeText(getApplication(), "you selected " + d1.getPincode(), Toast.LENGTH_LONG).show();
                    //    Toast.makeText(getApplication(),"you"+b,Toast.LENGTH_LONG).show();
                   *//* String Text = String.valueOf(spinner.getSelectedItem());
                    Toast.makeText(getApplication(),"you"+Text.toString(),Toast.LENGTH_LONG).show();*//*
                 *//* a1=spinner.getSelectedItem().toString();
*//*
//
                }


            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest1);
    }
*/
    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp = ((BitmapDrawable) iv_attachment.getDrawable()).getBitmap();
        bmp.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }


    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {
        this.bitmap = file;
        this.file_name = filename;
        iv_attachment.setImageBitmap(file);

        String path = Environment.getExternalStorageDirectory() + File.separator + "ImageAttach" + File.separator;
        imageutils.createImage(file, filename, path, false);
    }


    private void uploadImage() {
        class UploadImage extends AsyncTask<Bitmap, Void, String> {


            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Dashboard.this, "Uploading...", null, true, true);
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                loading.dismiss();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Dashboard.this);

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
                        Toast.makeText(getApplicationContext(), "thanks", Toast.LENGTH_LONG).show();
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

                int n = rand.nextInt(00145) + 1;
                count = String.valueOf(n);
                //   String n2= n1.toString();
                String n1 = editTextName.getText().toString();
                String a = editTextUsername.getText().toString();
                String m = editTextPassword.getText().toString();
                // String e=editTextEmail.getText().toString();


            /* final  String s1= spinner.getSelectedItem().toString();
              final  String s2= spinner1.getSelectedItem().toString();*/
                // spinner.getSelectedItem().toString();


                // final  String s1=spinner.getSelectedItem().toString();


                //    Toast.makeText(getApplication(),"you"+b,Toast.LENGTH_LONG).show();

                final String s2 = spinner1.getSelectedItem().toString();

                HashMap<String, String> data = new HashMap<>();

                data.put(UPLOAD_KEY, uploadImage);
                data.put(ref, count);
                data.put(name, n1);
                data.put(address, a);
                data.put(mobile, m);
                // data.put(email,e);
                data.put(dieses, d.getName());
                data.put(specility, f.getName());


                String result = rh.sendPostRequest(UPLOAD_URL, data);
                Log.d("resultdata1", result);
                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }


    //Overriding onclick method


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imageutils.onActivityResult(requestCode, resultCode, data);

    }


    @Override
    public void onClick(View v) {
        Intent I = new Intent(Dashboard.this, ConfirmationMassage.class);
        startActivity(I);
    }


    private void uploadImage1() {
        class UploadImage1 extends AsyncTask<Bitmap, Void, String> {


            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Dashboard.this, "Uploading...", null, true, true);
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                loading.dismiss();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Dashboard.this);

                // Setting Dialog Title
                alertDialog.setTitle("Your Information...");
            /*    Random rand = new Random();

                int  n = rand.nextInt(00145) + 1;

                 count=String.valueOf(n);
                Log.d("count",String.valueOf(n));*/
                Log.d("countref", String.valueOf(n));
                // Setting Dialog Message
                alertDialog.setMessage("Your Reference id is " + String.valueOf(n));

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.save);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed YES button. Write Logic Here
                        Intent intentt = new Intent(Dashboard.this, Thankyou.class);
                        //Storing bundle object into intent
                        //  intentt.putExtras(bb);
                        startActivity(intentt);


                     /*  Intent i=new Int ent(Main2Activity.this,ActivityMenuList.class);
                        startActivity(i);*/
                        Toast.makeText(getApplicationContext(), "thanks", Toast.LENGTH_LONG).show();
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

                n = rand.nextInt(00145) + 1;
                count = String.valueOf(n);
                String count = String.valueOf(n);
                Log.d("count", String.valueOf(n));
                HashMap<String, String> data = new HashMap<>();

                data.put(UPLOAD_KEY1, uploadImage);
                data.put(ref, count);

                String result = rh.sendPostRequest(UPLOAD_URL1, data);
                Log.d("resultdata", result);
                return result;
            }
        }

        UploadImage1 ui = new UploadImage1();
        ui.execute(bitmap);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        imageutils.request_permission_result(requestCode, permissions, grantResults);
    }

    @Override
    public void onPositiveClick2(int position) {
        this.position = position;

        /** Getting the reference of the textvie from the main layout */


        /** Setting the selected android version in the textview */
        tv.setText("Report with notification  " + Html.fromHtml("<b>" + Notification2.code[this.position] + "</b>"));
        //String l= Notification2.code[this.position];

    }

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {
        Toast.makeText(this, strings.toString(), Toast.LENGTH_LONG).show();
        String separator = ", ";
        StringBuilder builder = new StringBuilder();

        for (String value : strings) {
            builder.append(value).append('\n');
        }
        String text = builder.toString();
        editTextName.setText(builder.toString().substring(0).replaceFirst(",", ""));
        //editTextName.append("\n");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (position == 0) {
            Toast.makeText(Dashboard.this, "Select-Category", Toast.LENGTH_SHORT).show();
        } else if (position == 1) {
            sharedPreferences = getSharedPreferences("Fav1", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            boolean firstTime = sharedPreferences.getBoolean("first", true);
            if (firstTime) {
                editor.putBoolean("first", false);
                editor.commit();  //or  editor.apply();
                Intent intent = new Intent(getApplicationContext(), Fav5.class);
                startActivity(intent);
            } else {
                TextView tekst = (TextView) findViewById(R.id.editText1);
                StringBuffer b = new StringBuffer();
                SQLITEHELPER = new SQLiteHelper(getApplicationContext());
                Cursor res = SQLITEHELPER.getAll();
                if (res != null)

                    while (res.moveToNext()) {
                        // b.append(res.getString(0));

                   /* b.append(res.getString(1));
                    b.append("\n");*/
                        String emailList = res.getString(1);
                        emailList = emailList.replaceAll(",", "\n");
                        b.append(emailList);

//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                    }


                //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

                SQLITEHELPER.close();
                // set text to your TextView
                // set text to your TextView
                //tekst.setText(b.toString());\
                j = b.toString();
            /*Bundle c=new Bundle();
            c.getString("abc",b.toString());
            c.putString("pname", editTextName.getText().toString());
            c.putString("phnum", editTextName.getText().toString());
            c.putString("landmark", editTextName.getText().toString());
            c.putString("ZipCode",editTextName.getText().toString());
            Intent a=new Intent(Dashboard.this,ConfirmationMassage.class);
            a.putExtras(c);
            startActivity(a);
            Toast.makeText(Dashboard.this,"you "+b.toString(),Toast.LENGTH_LONG).show();
*/

                //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

          /*  Intent i=new Intent(this,MainActivity.class);
            startActivity(i);*/

            }


        } else if (position == 2) {
            StringBuffer b = new StringBuffer();
            SQLITEHELPER = new SQLiteHelper(getApplicationContext());
            Cursor res = SQLITEHELPER.getAll1();
            if (res != null)

                while (res.moveToNext()) {
                    // b.append(res.getString(0));
                    b.append(res.getString(1));
                    b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                }


            //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

            SQLITEHELPER.close();
            // set text to your TextView
            // set text to your TextView
            //tekst.setText(b.toString());\
            j = b.toString();
          /*  Bundle c=new Bundle();
            c.getString("abc",b.toString());
            Intent a=new Intent(Dashboard.this,ConfirmationMassage.class);
            a.putExtras(c);
            startActivity(a);
            Toast.makeText(Dashboard.this,"you selcected fav 1 "+b.toString(),Toast.LENGTH_LONG).show();
*/
            //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            /*Intent i1=new Intent(this, Fav2.class);
            startActivity(i1);*/
        } else if (position == 3) {

            StringBuffer b = new StringBuffer();
            SQLITEHELPER = new SQLiteHelper(getApplicationContext());
            Cursor res = SQLITEHELPER.getAll2();
            if (res != null)

                while (res.moveToNext()) {
                    // b.append(res.getString(0));
                    b.append(res.getString(1));
                    b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                }


            //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

            SQLITEHELPER.close();
            // set text to your TextView
            // set text to your TextView
            //tekst.setText(b.toString());\
            j = b.toString();
           /* Bundle c=new Bundle();
            c.getString("abc",b.toString());
            Intent a=new Intent(Dashboard.this,ConfirmationMassage.class);
            a.putExtras(c);
            startActivity(a);
            Toast.makeText(Dashboard.this,"you selcected fav 3 "+b.toString(),Toast.LENGTH_LONG).show();
*/
            //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            /*Intent i3=new Intent(this, Fav3.class);
            startActivity(i3);*/
        } else if (position == 4) {
            StringBuffer b = new StringBuffer();
            SQLITEHELPER = new SQLiteHelper(getApplicationContext());
            Cursor res = SQLITEHELPER.getAll3();
            if (res != null)

                while (res.moveToNext()) {
                    // b.append(res.getString(0));
                    b.append(res.getString(1));
                    b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                }


            //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

            SQLITEHELPER.close();
            // set text to your TextView
            // set text to your TextView
            // tekst.setText(b.toString());\
            j = b.toString();
            /*Bundle c=new Bundle();
            c.getString("abc",b.toString());
            Intent a=new Intent(Dashboard.this,ConfirmationMassage.class);
            a.putExtras(c);
            startActivity(a);
            Toast.makeText(Dashboard.this,"you selcected fav 4 "+b.toString(),Toast.LENGTH_LONG).show();
*/
            //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
           /* Intent i4=new Intent(this,Fav4.class);
            startActivity(i4);*/
        } else {

            StringBuffer b = new StringBuffer();
            SQLITEHELPER = new SQLiteHelper(getApplicationContext());
            Cursor res = SQLITEHELPER.getAll4();
            if (res != null)

                while (res.moveToNext()) {
                    // b.append(res.getString(0));
                    b.append(res.getString(1));
                    b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
                }


            //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

            SQLITEHELPER.close();
            // set text to your TextView
            // set text to your TextView
            //tekst.setText(b.toString());\
            j = b.toString();
           /* Bundle c=new Bundle();
            c.getString("abc",b.toString());
            Intent a=new Intent(Dashboard.this,ConfirmationMassage.class);
            a.putExtras(c);
            startActivity(a);
            Toast.makeText(Dashboard.this,"you selcected fav 5 "+b.toString(),Toast.LENGTH_LONG).show();
*/
            //Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            /*Intent i5=new Intent(this,Fav5.class);
            startActivity(i5);*/
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void> {
        public Context context;

        String JSonResult;

        public GetHttpResponse(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpServicesClass httpServicesClass = new HttpServicesClass(HttpUrl);
            try {
                httpServicesClass.ExecutePostRequest();

                if (httpServicesClass.getResponseCode() == 200) {
                    JSonResult = httpServicesClass.getResponse();

                    if (JSonResult != null) {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(JSonResult);

                            JSONObject jsonObject;

                            for (int i = 0; i < jsonArray.length(); i++) {
                                jsonObject = jsonArray.getJSONObject(i);

                                MobileList.add(jsonObject.getString("Specility").toString());

                            }
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } else {
                    Toast.makeText(context, httpServicesClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

    }

    void send_sms(final String mobile) {
        class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected Boolean doInBackground(String... urls) {
                try {

                    //------------------>>
                    HttpGet httppost = new HttpGet("http://sujwalinsure.com/insure/ws/testmysmsapi.php?testname=Vilas&mobileno="+mobile);
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse response = httpclient.execute(httppost);

                    // StatusLine stat = response.getStatusLine();
                    int status = response.getStatusLine().getStatusCode();

                    if (status == 200) {
                        HttpEntity entity = response.getEntity();
                        String data = EntityUtils.toString(entity);


                        JSONObject jsono = new JSONObject(data);

                        return true;
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {

                    e.printStackTrace();
                }
                return false;
            }

            protected void onPostExecute(Boolean result) {

            }
        }
    }


    void send_sms1(String urlsend)
    {
        // Class with extends AsyncTask class
        class LongOperation  extends AsyncTask<String, Void, Void> {

            private final HttpClient Client = new DefaultHttpClient();
            private String Content;
            private String Error = null;
            private ProgressDialog Dialog = new ProgressDialog(Dashboard.this);

           // TextView uiUpdate = (TextView) findViewById(R.id.output);

            protected void onPreExecute() {
                // NOTE: You can call UI Element here.

                //UI Element
               // uiUpdate.setText("Output : ");
                Dialog.setMessage("Send Sms..");
                Dialog.show();
            }

            // Call after onPreExecute method
            protected Void doInBackground(String... urls) {
                try {

                    // Call long running operations here (perform background computation)
                    // NOTE: Don't call UI Element here.

                    // Server url call by GET method
                    HttpGet httpget = new HttpGet(urls[0]);
                    ResponseHandler<String> responseHandler = new BasicResponseHandler();
                    Content = Client.execute(httpget, responseHandler);

                } catch (ClientProtocolException e) {
                    Error = e.getMessage();
                    cancel(true);
                } catch (IOException e) {
                    Error = e.getMessage();
                    cancel(true);
                }

                return null;
            }

            protected void onPostExecute(Void unused) {
                // NOTE: You can call UI Element here.

                // Close progress dialog
                Dialog.dismiss();

                if (Error != null) {

                   // uiUpdate.setText("Output : "+Error);
                    Toast.makeText(Dashboard.this, "Error", Toast.LENGTH_SHORT).show();

                } else {

                   // uiUpdate.setText("Output : "+Content);
                    Toast.makeText(Dashboard.this, "sucess", Toast.LENGTH_SHORT).show();

                }
            }

        }
        new LongOperation().execute(urlsend);
    }

    }

