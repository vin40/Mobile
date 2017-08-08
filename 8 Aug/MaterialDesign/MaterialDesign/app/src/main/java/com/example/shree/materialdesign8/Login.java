package com.example.shree.materialdesign8;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Login extends ActionBarActivity {
    private EditText Username;
    private EditText Password;
    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="login_username";
    public static String PREF_PASSWORD="login_password";
    public static final String USER_NAME = "USERNAME";

    String username1;
    String password1;
    private  String username2;
    private  String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.login);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.password);
        TextView forgot = (TextView) findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Forgot.class);
                startActivity(i);
            }
        });
        Button sinup = (Button) findViewById(R.id.signup);

        sinup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), LoginAlert.class);
                startActivity(intent1);
            }
        });

    }



        public void invokeLogin(View view){
           /* username1 =Username.getText().toString();
            password1 = Password.getText().toString();

            login(username1,password1);
*/
            Intent intent1 = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent1);


        }




        private void login(final String username1, String password1) {

            class LoginAsync extends AsyncTask<String, Void, String> {

                private Dialog loadingDialog;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loadingDialog = ProgressDialog.show(Login.this, "Please wait", "Loading...");
                }

                @Override
                protected String doInBackground(String... params) {
                    String uname = params[0];
                    String pass = params[1];

                    InputStream is = null;
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("username", uname));
                    nameValuePairs.add(new BasicNameValuePair("password", pass));
                    String result = null;

                    try{
                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost(
                                "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/api/login.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                        HttpResponse response = httpClient.execute(httpPost);

                        HttpEntity entity = response.getEntity();

                        is = entity.getContent();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                        StringBuilder sb = new StringBuilder();

                        String line = null;
                        while ((line = reader.readLine()) != null)
                        {
                            sb.append(line + "\n");
                        }
                        result = sb.toString();
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return result;
                }

                @Override
                protected void onPostExecute(String result){
                    String s = result.trim();
                    loadingDialog.dismiss();
                    if(s.equalsIgnoreCase("success")){



                    Intent intent = new Intent(Login.this, Dashboard.class);
                        intent.putExtra(USER_NAME, username1);
                        finish();
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                    }
                }
            }

            LoginAsync la = new LoginAsync();
            la.execute(username1, password1);

        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(Login.this,Main4Activity.class);
        finish();
        startActivity(i);
    }
}




