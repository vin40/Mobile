package com.example.shree.materialdesign8;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.shree.materialdesign8.R;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class LoginWithDiff extends AppCompatActivity implements View.OnClickListener {
public static final int RC_SIGN_IN=0;
private FirebaseAuth auth;

@Override
protected void onCreate(Bundle savedInstanceState)
{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_with_diff);
        auth=FirebaseAuth.getInstance();

        if (auth.getCurrentUser() !=null)
        {
        //user already signed in
        Log.d("Auth", auth.getCurrentUser().getEmail());

        }
        else
        {
        startActivityForResult(AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setProviders(
        AuthUI.FACEBOOK_PROVIDER,
        AuthUI.EMAIL_PROVIDER,
        AuthUI.GOOGLE_PROVIDER)
        .build(), RC_SIGN_IN);
        }

        findViewById(R.id.log_out_button).setOnClickListener(this);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SIGN_IN)
        {
        if (resultCode==RESULT_OK)
        {
        //user logd in

        Log.d("Auth", auth.getCurrentUser().getEmail());

        }
        else {
        //user not authentiocated
        Log.d("Auth","Not Authenticated");
        }
        }
        }
        @Override
        public void onClick(View view)
        {
        if (view.getId()==R.id.log_out_button){
        AuthUI.getInstance()
        .signOut(this)
        .addOnCompleteListener(new OnCompleteListener<Void>()
        {
        @Override
        public void onComplete(@NonNull Task<Void> task)
        {
        Log.d("Auth","User Loged Out.!");
        finish();
        }
        });
        }
        }
}
