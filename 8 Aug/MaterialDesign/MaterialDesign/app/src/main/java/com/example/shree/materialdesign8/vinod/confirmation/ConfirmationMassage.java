package com.example.shree.materialdesign8.vinod.confirmation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod2.labcategory.Thankyou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ConfirmationMassage extends AppCompatActivity {
    String phnumber,message,route;
    String mainUrl,authkey,senderId;
    String encoded_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_massage);
        Button button=(Button)findViewById(R.id.confirm);
        TextView notice = (TextView)findViewById(R.id.notice);
        TextView pname1 = (TextView)findViewById(R.id.pname);
        TextView pmnumber1 = (TextView)findViewById(R.id.pmnumber);
        TextView landmark1 = (TextView)findViewById(R.id.landmark);
        TextView zipcode1 = (TextView)findViewById(R.id.zipcode);
        TextView test = (TextView)findViewById(R.id.test);
        Intent in = getIntent();
        Bundle b = in.getExtras();

        String name = b.getString("pname");
        //long phnumber = b.getLong("phnum");
        String phnumber = b.getString("phnum");
        String land=b.getString("landmark");
        String ZipCode=b.getString("ZipCode");
        String test1=b.getString("abc");
       String n=b.getString("notice");
        // String phno = Long.toString(phnumber);


        pname1.setText(name);
        pmnumber1.setText(phnumber);
        landmark1.setText(land);
        zipcode1.setText(ZipCode);
        test.setText(test1);
        notice.setText(n);


        //Your authentication key
        authkey = "148346AHIawKdxFhXS58eb2c55";
//Multiple mobiles numbers separated by comma
        String mobiles = "9999999";
//Sender ID,While using route4 sender id should be 6 characters long.
      senderId = "Doctor";
//Your message to send, Add URL encoding here.
        message = "Hi%20There%20is%20Msg%20";
//define route
        String route="4";

        encoded_message= URLEncoder.encode(message);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sendsms1();
                Intent i=new Intent(getBaseContext(), Thankyou.class);
                startActivity(i);

            }
        });

    }
    /*void SendSms()
    {
        class UploadImage extends AsyncTask<String, Void, String> {



            @Override
            protected String doInBackground(String... params) {

                try
                {
                    URL myURL=null;
                    URLConnection myURLConnection=null;
                    BufferedReader reader=null;

//encoding message
                    String encoded_message= URLEncoder.encode(message);






//Send SMS API
                    mainUrl="http://api.msg91.com/api/sendhttp.php?";


                    //Prepare parameter string
                    StringBuilder sbPostData= new StringBuilder(mainUrl);
                    sbPostData.append("authkey="+authkey);
                    sbPostData.append("&mobiles="+"+91"+phnumber);
                    sbPostData.append("&message="+encoded_message);
                    sbPostData.append("&sender="+senderId);
                    sbPostData.append("&route="+route);
                    sbPostData.append("&country="+"91");
                    sbPostData.append("&response="+"json");
                    sbPostData.append("&campaign="+"dpts");




//final string
                    mainUrl = sbPostData.toString();

                    //prepare connection


                    myURL = new URL(mainUrl);
                    myURLConnection = myURL.openConnection();
                    myURLConnection.connect();
                    reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

                    //reading response
                    String response;
                    while ((response = reader.readLine()) != null)
                        //print response
                        Log.d("RESPONSE", ""+response);
                   // Toast.makeText(ConfirmationMassage.this,"Sms Send Sucessfully!",Toast.LENGTH_LONG).show();

                    //finally close connection
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute();

    }*/

    void sendsms1()
    {
        try {
            String data = "";
            data += "authkey=" + URLEncoder.encode(authkey, "ISO-8859-1");
            data += "&mobiles=" + URLEncoder.encode(phnumber, "ISO-8859-1");
            data += "&message=" + URLEncoder.encode(encoded_message, "ISO-8859-1");
            data += "&sender=4&country=91&response=json&campaign=dpts";


          //  authkey="+authkey+"&mobiles="+phnumber+"&message="+encoded_message+"&sender="+senderId+"&route=4&country=91&response=json&campaign=dpts

            // Send data
            URL url = new URL("http://api.msg91.com/api/sendhttp.php?");

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                // Print the response output...
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
