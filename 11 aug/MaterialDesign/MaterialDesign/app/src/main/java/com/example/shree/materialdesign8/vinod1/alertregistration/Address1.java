package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.shree.materialdesign8.R;

import java.util.ArrayList;




import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Address1 extends AppCompatActivity {
    // Out custom adapter
    MySimpleArrayAdapter adapter;

    // contains our listview items
    ArrayList<MyNotes> listItems;

    // database
    DatabaseHelper DatabaseHelper;

    // list of todo titles
    ArrayList<String> newData;

    // contains the id of the item we are about to delete
    public int deleteItem;

    // EditText field for adding new items to the list
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_address);

        // We're getting our listView by the id
        ListView listView = (ListView) findViewById(R.id.list);

        // Creating a new instance of our DatabaseHelper, which we've created
        // earlier
        DatabaseHelper = new DatabaseHelper(this);

        // This returns a list of all our current available notes
        listItems = DatabaseHelper.getAllNotes();

        newData = new ArrayList<String>();

        // Assigning the title to our global property so we can access it
        // later after certain actions (deleting/adding)
        for (MyNotes note : listItems) {
            newData.add(note.Title);
        }

        // We're initialising our custom adapter with all our data from the
        // database
        adapter = new MySimpleArrayAdapter(this, newData);

        // Assigning the adapter to ListView
        listView.setAdapter(adapter);

        // Assigning an event to the listview
        // This event will be used to delete records
        listView.setOnItemLongClickListener(myClickListener);
    }

    /**
     * This adapter will create your list view row by row
     */
    public class MySimpleArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final ArrayList<String> values;

        public MySimpleArrayAdapter(Context context, ArrayList<String> values) {
            super(context, R.layout.rowlayout, values);

            this.context = context;
            this.values = values;
        }

        /**
         * Here we go and get our rowlayout.xml file and set the textview text.
         * This happens for every row in your listview.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

            TextView textView = (TextView) rowView.findViewById(R.id.label);

            // Setting the text to display
            textView.setText(values.get(position));

            return rowView;
        }
    }

    /**
     * On a long click delete the selected item
     */
    public OnItemLongClickListener myClickListener = new OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
            // Assigning the item position to our global variable
            // So we can access it within our AlertDialog below
            deleteItem = arg2;

            // Creating a new alert dialog to confirm the delete
            AlertDialog alert = new AlertDialog.Builder(arg1.getContext())
                    .setTitle("Delete " + listItems.get(deleteItem).Title)
                    .setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    // Retrieving the note from our listItems
                                    // property, which contains all notes from
                                    // our database
                                    MyNotes note = listItems.get(deleteItem);

                                    // Deleting it from the ArrayList<string>
                                    // property which is linked to our adapter
                                    newData.remove(deleteItem);

                                    // Deleting the note from our database
                                    DatabaseHelper.deleteNote(note.Id);

                                    // Tell the adapter to update the list view
                                    // with the latest changes
                                    adapter.notifyDataSetChanged();

                                    dialog.dismiss();
                                }
                            })
                    .setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    // When you press cancel, just close the
                                    // dialog
                                    //dialog.cancel();
                                    Toast.makeText(Address1.this, "Set "+listItems.get(deleteItem).Title, Toast.LENGTH_SHORT).show();
                                }
                            }).show();

            return false;
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main1, menu);

        return true;
    }

    /**
     * This method is called when you press any button in your menu We've named
     * our add button action_add in our menu.xml file
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add:
                showCreateNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This simply shows a alert dialog asking for the todo text
     */
    public void showCreateNote() {
        // Creating a dynamical edittext for our alert dialog
        editText2 = new EditText(this);
        editText2.setId(9999);
        editText2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        editText2.setHint("Enter your Address");

        AlertDialog alert = new AlertDialog.Builder(this)
                .setTitle("Create New Address")
                .setView(editText2)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        if (editText2.getText().toString().length() > 0) {
                            // Adding the new todo text to our database
                            long Id = DatabaseHelper.addRecord(editText2.getText().toString());
                            // global property listItems
                            MyNotes note = new MyNotes();
                            note.Id = (int) Id;
                            note.Title = editText2.getText().toString();

                            listItems.add(note);

                            newData.add(note.Title);

                            adapter.notifyDataSetChanged();
                        }

                        dialog.dismiss();
                        // This hides the android keyboard
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(
                                InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dialog.cancel();

                                // This hides the android keyboard
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(
                                        InputMethodManager.HIDE_IMPLICIT_ONLY,
                                        0);

                            }
                        }).show();

        // We are automatically focusing on the editText field
        if (editText2.requestFocus())
            ;
        {
            // This brings out the android keyboard as soon as we focus on the
            // editText area
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }
}
