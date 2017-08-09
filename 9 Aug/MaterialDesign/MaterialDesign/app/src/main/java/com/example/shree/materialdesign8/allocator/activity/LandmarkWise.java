package com.example.shree.materialdesign8.allocator.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter1;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter2;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class LandmarkWise extends Activity {
    ListView listMenu;
    ProgressBar prgLoading;
    EditText edtKeyword;
    ImageButton btnSearch;
    TextView txtAlert;

    // declare static variable to store tax and currency symbol
    static double Tax;
    static String Currency;

    // declare adapter object to create custom menu list
    AdapterLandMarkWise mla;

    // create arraylist variables to store data from server
    static ArrayList<Long> Menu_ID = new ArrayList<Long>();
    static ArrayList<String> Menu_name = new ArrayList<String>();
    static ArrayList<String> address1 = new ArrayList<String>();
    static ArrayList<String> mobile = new ArrayList<String>();
    static ArrayList<String> Timeline = new ArrayList<String>();
    static ArrayList<String> Rating = new ArrayList<String>();
    static ArrayList<String>  Discount = new ArrayList<String>();
    static ArrayList<String>  landline  = new ArrayList<String>();
    static ArrayList<String>  landmark  = new ArrayList<String>();
     /*  static ArrayList<Double> Menu_price = new ArrayList<Double>();
    static ArrayList<String> Menu_image = new ArrayList<String>();*/

    String SpareAPI;
    String TaxCurrencyAPI;
    int IOConnect = 0;
    // long Category_ID;
    // String Category_name;
    String Keyword;
    DecimalFormat formatData = new DecimalFormat("#.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list_area);
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.header)));
        bar.setTitle("Search Lab");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        prgLoading = (ProgressBar) findViewById(R.id.prgLoading);
        listMenu = (ListView) findViewById(R.id.listMenu);
        final AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.edtKeyword);
        acTextView.setAdapter(new SuggestionAdapter2(this, acTextView.getText().toString()));
        //edtKeyword = (EditText) findViewById(R.id.edtKeyword);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);
        txtAlert = (TextView) findViewById(R.id.txtAlert);

        // menu API url
        SpareAPI = Constant.SpareAPI2 + "?accesskey=" + Constant.AccessKey;
        // tax and currency API url
        TaxCurrencyAPI = Constant.TaxCurrencyAPI + "?accesskey=" + Constant.AccessKey;

        // get category id and category name that sent from previous page
        Intent iGet = getIntent();
        //  Category_ID = iGet.getLongExtra("category_id", 0);
        //  Category_name = iGet.getStringExtra("category_name");
        //  MenuAPI += Category_ID;

        mla = new AdapterLandMarkWise(LandmarkWise.this);

        // call asynctask class to request tax and currency data from server
        new getTaxCurrency().execute();

        // event listener to handle search button when clicked
        btnSearch.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                // get keyword and send it to server
                try {
                    Keyword = URLEncoder.encode(acTextView.getText().toString(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SpareAPI += "&keyword=" + Keyword;
                IOConnect = 0;
                listMenu.invalidateViews();
                clearData();
                new getDataTask().execute();
            }
        });

        // event listener to handle list when clicked
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                // TODO Auto-generated method stub
                // go to menu detail page
                Intent iDetail = new Intent(LandmarkWise.this, ActivityDetailLabArea.class);
                iDetail.putExtra("menu_id", Menu_ID.get(position));
                startActivity(iDetail);
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            /*case R.id.cart:
                // refresh action
                Intent iMyOrder = new Intent(SpareList.this, ActivityCart.class);
                startActivity(iMyOrder);
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
                return true;*/

            case R.id.refresh:
                IOConnect = 0;
                listMenu.invalidateViews();
                clearData();
                new getDataTask().execute();
                return true;

            case android.R.id.home:
                // app icon in action bar clicked; go home
                this.finish();
                overridePendingTransition(R.anim.open_main, R.anim.close_next);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // asynctask class to handle parsing json in background
    public class getTaxCurrency extends AsyncTask<Void, Void, Void> {

        // show progressbar first
        getTaxCurrency() {
            if (!prgLoading.isShown()) {
                prgLoading.setVisibility(0);
                txtAlert.setVisibility(8);
            }
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            // parse json data from server in background
            parseJSONDataTax();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            // when finish parsing, hide progressbar
            prgLoading.setVisibility(8);
            // if internet connection and data available request menu data from
            // server
            // otherwise, show alert text
            if ((Currency != null) && IOConnect == 0) {
                new getDataTask().execute();
            } else {
                txtAlert.setVisibility(0);
            }
        }
    }

    // method to parse json data from server
    public void parseJSONDataTax() {
        try {
            // request data from tax and currency API
            HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 15000);
            HttpConnectionParams.setSoTimeout(client.getParams(), 15000);
            HttpUriRequest request = new HttpGet(TaxCurrencyAPI);
            HttpResponse response = client.execute(request);
            InputStream atomInputStream = response.getEntity().getContent();

            BufferedReader in = new BufferedReader(new InputStreamReader(atomInputStream));

            String line;
            String str = "";
            while ((line = in.readLine()) != null) {
                str += line;
            }

            // parse json data and store into tax and currency variables
            JSONObject json = new JSONObject(str);
            JSONArray data = json.getJSONArray("data"); // this is the "items: [
            // ] part

            JSONObject object_tax = data.getJSONObject(0);
            JSONObject tax = object_tax.getJSONObject("tax_n_currency");

            Tax = Double.parseDouble(tax.getString("Value"));

            JSONObject object_currency = data.getJSONObject(1);
            JSONObject currency = object_currency.getJSONObject("tax_n_currency");

            Currency = currency.getString("Value");

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            IOConnect = 1;
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // clear arraylist variables before used
    void clearData() {
        Menu_ID.clear();
        Menu_name.clear();
        address1.clear();
        Rating.clear();
        Timeline.clear();
        mobile.clear();
        landline.clear();
        landmark.clear();
    }

    // asynctask class to handle parsing json in background
    public class getDataTask extends AsyncTask<Void, Void, Void> {

        // show progressbar first
        getDataTask() {
            if (!prgLoading.isShown()) {
                prgLoading.setVisibility(0);
                txtAlert.setVisibility(8);
            }
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            // parse json data from server in background
            parseJSONData();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            // when finish parsing, hide progressbar
            prgLoading.setVisibility(8);

            // if data available show data on list
            // otherwise, show alert text
            if (Menu_ID.size() > 0) {
                listMenu.setVisibility(0);
                listMenu.setAdapter(mla);
            } else {
                txtAlert.setVisibility(0);
            }

        }
    }

    // method to parse json data from server
    public void parseJSONData() {

        clearData();

        try {
            // request data from menu API
            HttpClient client = new DefaultHttpClient();
            HttpConnectionParams.setConnectionTimeout(client.getParams(), 15000);
            HttpConnectionParams.setSoTimeout(client.getParams(), 15000);
            HttpUriRequest request = new HttpGet(SpareAPI);
            HttpResponse response = client.execute(request);
            InputStream atomInputStream = response.getEntity().getContent();

            BufferedReader in = new BufferedReader(new InputStreamReader(atomInputStream));

            String line;
            String str = "";
            while ((line = in.readLine()) != null) {
                str += line;
            }

            // parse json data and store into arraylist variables
            JSONObject json = new JSONObject(str);
            JSONArray data = json.getJSONArray("data"); // this is the "items: [
            // ] part

            for (int i = 0; i < data.length(); i++) {
                JSONObject object = data.getJSONObject(i);

                JSONObject menu = object.getJSONObject("Menu");

                Menu_ID.add(Long.parseLong(menu.getString("Menu_ID")));
                Menu_name.add(menu.getString("Menu_Name"));
                address1.add(menu.getString("address1"));
                Timeline.add(menu.getString("Timeline"));
                Rating.add(menu.getString("Rating"));
                Discount.add(menu.getString("Discount"));
                mobile.add(menu.getString("mobile"));
                landline.add(menu.getString("landline"));
                landmark.add(menu.getString("landmark"));
          /*     Menu_price.add(Double.valueOf(formatData.format(menu.getDouble("Price"))));
                Menu_image.add(menu.getString("Menu_image"));*/

            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        // mla.imageLoader.clearCache();
        listMenu.setAdapter(null);
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(final Configuration newConfig) {
        // Ignore orientation change to keep activity from restarting
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.open_main, R.anim.close_next);




    }
}
