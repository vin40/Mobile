package com.example.shree.materialdesign8;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shree.materialdesign8.allocator.activity.ActivityCategoryLabAreaList;
import com.example.shree.materialdesign8.allocator.activity.LabCategoryRating;
import com.example.shree.materialdesign8.allocator.activity.LandmarkWise;
import com.example.shree.materialdesign8.login.MainActivity;

import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod1.alertregistration.Address;
import com.example.shree.materialdesign8.vinod1.alertregistration.Address1;
import com.example.shree.materialdesign8.vinod2.labcategory.area.Areawise;
import com.example.shree.materialdesign8.vinod5.countrycodepicker.CountryCodePicker1;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;

public class Main4Activity extends AppCompatActivity {

    ImageView imageView,imageView1;
    Thread splashTread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main4);

        imageView=(ImageView)findViewById(R.id.img10);
        imageView1=(ImageView)findViewById(R.id.img11);

        LinearLayout patient1 = (LinearLayout) findViewById (R.id.patient1);
        patient1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent alertreg=new Intent(getApplicationContext(), Login.class);
                startActivity(alertreg);
               // Toast.makeText(Main4Activity.this, "Patient1", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout patient2 = (LinearLayout) findViewById (R.id.patient2);
        patient2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main4Activity.this,LandmarkWise.class);
                startActivity(i);
                Toast.makeText(Main4Activity.this, "Pathalogy", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout patient3=(LinearLayout)findViewById(R.id.patient3);
        patient3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent i = new Intent(Main4Activity.this, Dashboard.class);
                    startActivity(i);
                    Toast.makeText(Main4Activity.this, "Question & Answer", Toast.LENGTH_SHORT).show();

            }
        });

        LinearLayout patient4=(LinearLayout)findViewById(R.id.patient4);
        patient4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Main4Activity.this, "Hellow Patient", Toast.LENGTH_SHORT).show();
               /* Intent alertreg=new Intent(getApplicationContext(), LoginAlert.class);
                startActivity(alertreg);*/
            }
        });

        LinearLayout patient5=(LinearLayout)findViewById(R.id.patient5);
        patient5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
                builder.setTitle("Coming Soon");
                builder.setCancelable(true);
                builder.setMessage(getResources().getString(R.string.ComingSoon));
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();*/
                Intent in=new Intent(Main4Activity.this,ImageAttachment1.class);
                startActivity(in);
                Toast.makeText(Main4Activity.this, "Ambulance", Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayout patient6=(LinearLayout)findViewById(R.id.patient6);
        patient6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Main4Activity.this,Areawise.class);
                startActivity(in);
                Toast.makeText(Main4Activity.this, "Patient6", Toast.LENGTH_SHORT).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main4Activity.this, "Job For Doctor", Toast.LENGTH_SHORT).show();

                //overridePendingTransition(R.anim.zoom_in,R.anim.zoom_out);

                StartAnimations();

            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent in=new Intent(Main4Activity.this, ActivityCategoryLabAreaList.class);
                startActivity(in);*/
                Toast.makeText(Main4Activity.this, "Medicine", Toast.LENGTH_SHORT).show();
                StartAnimations1();

            }
        });

    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.patient7);
        l.clearAnimation();
        l.startAnimation(anim);

       anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.img10);
        iv.clearAnimation();
        iv.startAnimation(anim);

     splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 1200) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Main4Activity.this.finish();
                } catch (InterruptedException e) {
                    // doc nothing
                } finally {
                    Main4Activity.this.finish();
                }

            }
        };
        splashTread.start();

    }

    private void StartAnimations1() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.patient8);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.img11);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 1200) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Main4Activity.this,Address1.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Main4Activity.this.finish();
                } catch (InterruptedException e) {
                    // doc nothing
                } finally {
                    Main4Activity.this.finish();
                }

            }
        };
        splashTread.start();

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
}
