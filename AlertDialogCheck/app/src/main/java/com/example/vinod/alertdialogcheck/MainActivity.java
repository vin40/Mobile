package com.example.vinod.alertdialogcheck;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int CHECKBOX_ALERTDIALOG = 1;
    final boolean checked_state[] = {false, false, false}; //The array that holds the checked state of the checkbox items
    final CharSequence[] day_check = {"Sunday", "Monday", "Tuesday"}; //items in the alertdialog that displays checkboxes
     private Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = (Button) findViewById(R.id.btnCheckBox);
        check.setOnClickListener(this);
    }

    /*triggered by showDialog method. onCreateDialog creates a dialog*/
    @Override
    public Dialog onCreateDialog(int id) {
        switch (id) {


            case CHECKBOX_ALERTDIALOG:

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose a Days")
                        .setMultiChoiceItems(day_check, null, new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                                checked_state[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String display_checked_days = "";
                                for (int i = 0; i < 3; i++) {
                                    if (checked_state[i] == true) {
                                        display_checked_days = display_checked_days + " " + day_check[i];
                                    }
                                }
                                Toast.makeText(MainActivity.this, "The selected day(s) is" + display_checked_days, Toast.LENGTH_LONG).show();


                                for (int i = 0; i < checked_state.length; i++) {
                                    if (checked_state[i] == true) {
                                        checked_state[i] = false;
                                    }
                                }

                                dialog.dismiss();
                            }
                        });
                AlertDialog alertdialog1 = builder1.create();
                return alertdialog1;

        }
        return null;

    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
// TODO Auto-generated method stub

        switch (id) {
            case CHECKBOX_ALERTDIALOG:
                AlertDialog prepare_checkbox_dialog = (AlertDialog) dialog;
                ListView list_checkbox = prepare_checkbox_dialog.getListView();
                for (int i = 0; i < list_checkbox.getCount(); i++) {
                    list_checkbox.setItemChecked(i, false);
                }
                break;

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnCheckBox:

                showDialog(CHECKBOX_ALERTDIALOG);
                break;
        }
    }
}
