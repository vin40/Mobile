package com.example.vinod.alertcheckbox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int LIST_ALERTDIALOG = 0, CHECKBOX_ALERTDIALOG = 1, RADIOBUTTON_ALERTDIALOG = 2;
    final boolean checked_state[] = {false, false, false}; //The array that holds the checked state of the checkbox items
    final CharSequence[] day_check = {"Sunday", "Monday", "Tuesday"}; //items in the alertdialog that displays checkboxes
    final CharSequence[] day_list = {"Sunday", "Monday", "Monday"}; //items in the alertdialog that displays list
    final CharSequence[] day_radio = {"Sunday", "Monday", "Monday"}; //items in the alertdialog that displays radiobuttons
    private Button list, check, radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (Button) findViewById(R.id.btnList);
        check = (Button) findViewById(R.id.btnCheckBox);
        radio = (Button) findViewById(R.id.btnRadio);

        list.setOnClickListener(this);
        check.setOnClickListener(this);
        radio.setOnClickListener(this);
    }

    /*triggered by showDialog method. onCreateDialog creates a dialog*/
    @Override
    public Dialog onCreateDialog(int id) {
        switch (id) {
            case LIST_ALERTDIALOG:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose a Day")
                        .setItems(day_list, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                                Toast.makeText(getApplicationContext(), "The selected color is " + day_list[which], Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alertdialog = builder.create();
                return alertdialog;

            case CHECKBOX_ALERTDIALOG:

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose a Days")
                        .setMultiChoiceItems(day_check, null, new DialogInterface.OnMultiChoiceClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
// TODO Auto-generated method stub

//storing the checked state of the items in an array
                                checked_state[which] = isChecked;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                                String display_checked_days = "";
                                for (int i = 0; i < 3; i++) {
                                    if (checked_state[i] == true) {
                                        display_checked_days = display_checked_days + " " + day_check[i];
                                    }
                                }
                                Toast.makeText(MainActivity.this, "The selected day(s) is" + display_checked_days, Toast.LENGTH_LONG).show();

//clears the String used to store the displayed text
                                display_checked_days = null;

//clears the array used to store checked state
                                for (int i = 0; i < checked_state.length; i++) {
                                    if (checked_state[i] == true) {
                                        checked_state[i] = false;
                                    }
                                }

//used to dismiss the dialog upon user selection.
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertdialog1 = builder1.create();
                return alertdialog1;

            case RADIOBUTTON_ALERTDIALOG:

                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Choose a Day")
                        .setSingleChoiceItems(day_radio, -1, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                                Toast.makeText(getApplicationContext(),
                                        "The selected Day is " + day_radio[which], Toast.LENGTH_LONG).show();

//dismissing the dialog when the user makes a selection.
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertdialog2 = builder2.create();
                return alertdialog2;
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
            case RADIOBUTTON_ALERTDIALOG:
                AlertDialog prepare_radio_dialog = (AlertDialog) dialog;
                ListView list_radio = prepare_radio_dialog.getListView();
                for (int i = 0; i < list_radio.getCount(); i++) {
                    list_radio.setItemChecked(i, false);
                }
                break;

        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnList:
//triggering the List alertdialog
                showDialog(LIST_ALERTDIALOG);
                break;
            case R.id.btnCheckBox:
//triggering the checkbox alertdialog
                showDialog(CHECKBOX_ALERTDIALOG);
                break;
            case R.id.btnRadio:
//triggering the radio alertdialog
                showDialog(RADIOBUTTON_ALERTDIALOG);
                break;

            default:
                break;
        }
    }
}
