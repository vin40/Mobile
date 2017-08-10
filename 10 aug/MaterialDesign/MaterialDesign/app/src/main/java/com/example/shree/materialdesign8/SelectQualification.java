package com.example.shree.materialdesign8;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SelectQualification extends Activity implements AlertDialogRadio.AlertPositiveListener,AlertDialogRadio1.AlertPositiveListener1{
    /*
     * Stores the selected item's position
    */
    int position = 0;
    Button next;
    RadioButton radioBtn,radioBtn1;
    RadioGroup rg;


    /*
     * Called when the activity is first created.
    */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_qualification);
        Button iam=(Button)findViewById(R.id.iam);
        iam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelectQualification.this,Otp.class);
                finish();
                startActivity(i);
            }
        });
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup);
        radioBtn=(RadioButton)findViewById(R.id.radioButton1);
        radioBtn1=(RadioButton)findViewById(R.id.radioButton2);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton1:
                        View.OnClickListener listener = new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                /** Getting the fragment manager */
                                FragmentManager manager = getFragmentManager();

                                /** Instantiating the DialogFragment class */
                                AlertDialogRadio1 alert = new AlertDialogRadio1();

                                /** Creating a bundle object to store the selected item's index */
                                Bundle b = new Bundle();

                                /** Storing the selected item's index in the bundle object*/
                                b.putInt("position", position);

                                /** Setting the bundle object to the dialog fragment object*/
                                alert.setArguments(b);

                                /** Creating the dialog fragment object, which will in turn open the alert dialog window*/
                                alert.show(manager, "alert_dialog_radio");
                            }


                        };
                        radioBtn.setOnClickListener(listener);
                        break;
                    case R.id.radioButton2:
                        // do operations specific to this selection
                       // Toast.makeText(getApplicationContext(), "You Select Student", Toast.LENGTH_SHORT).show();
                        View.OnClickListener listener1 = new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                /** Getting the fragment manager */
                                FragmentManager manager = getFragmentManager();

                                /** Instantiating the DialogFragment class */
                                AlertDialogRadio alert = new AlertDialogRadio();

                                /** Creating a bundle object to store the selected item's index */
                                Bundle b = new Bundle();

                                /** Storing the selected item's index in the bundle object*/
                                b.putInt("position", position);

                                /** Setting the bundle object to the dialog fragment object*/
                                alert.setArguments(b);

                                /** Creating the dialog fragment object, which will in turn open the alert dialog window*/
                                alert.show(manager, "alert_dialog_radio");
                            }


                        };
                        radioBtn1.setOnClickListener(listener1);
                        break;

                }
            }
        });

       /* radioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You Select Trainee", Toast.LENGTH_SHORT).show();

            }
        });

        radioBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "You Select Intern", Toast.LENGTH_SHORT).show();

            }
        });
*/



        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nxt=new Intent(getApplicationContext(),ImageAttachment.class);
                startActivity(nxt);
            }
        });


    /*    View.OnClickListener listener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                *//** Getting the fragment manager *//*
                FragmentManager manager = getFragmentManager();

                *//** Instantiating the DialogFragment class *//*
                AlertDialogRadio alert = new AlertDialogRadio();

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
*/
        /** Getting the reference of the button from the main layout */
        //Button btn = (Button) findViewById(R.id.btn);
        /*TextView txt=(TextView)findViewById(R.id.tv_android);

        *//** Setting a button click listener for the choose button *//*
        //btn.setOnClickListener(listener);
        txt.setOnClickListener(listener);*/
    }

    /**
     * Defining button click listener for the OK button of the alert dialog window
     */
    @Override
    public void onPositiveClick(int position)
    {
        this.position = position;

        /** Getting the reference of the textview from the main layout */
        TextView tv = (TextView) findViewById(R.id.tv_android);

        /** Setting the selected android version in the textview */
        tv.setText(Notification.code[this.position]);
    }

    @Override
    public void onPositiveClick1(int position) {
        this.position = position;

        /** Getting the reference of the textview from the main layout */
        TextView tv = (TextView) findViewById(R.id.tv_android);

        /** Setting the selected android version in the textview */
        tv.setText(Notification1.code[this.position]);

    }





   /* @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }*/
}

