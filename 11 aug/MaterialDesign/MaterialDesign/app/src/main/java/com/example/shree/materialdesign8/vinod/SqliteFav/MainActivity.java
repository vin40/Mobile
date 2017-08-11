package com.example.shree.materialdesign8.vinod.SqliteFav;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.Login;
import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.spinnerFav.FavEdit;
import com.example.shree.materialdesign8.spinnerFav.FavName;
import com.example.shree.materialdesign8.vinod4.setfavorite.SetFavorite;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.HttpServicesClass;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.ShowDetailsActivity;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapterFav;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Vinod on 5/14/2017.
 */
public class MainActivity extends AppCompatActivity {
    ArrayList<String> selectedItems;
    private MultiAutoCompleteTextView acTextView;
Button btn;
    EditText GetName,GetPhoneNumber,GetSubject ;
    Button Submit, EditData, DisplayData;
    SQLiteDatabase SQLITEDATABASE;
    String Name, PhoneNumber, Subject ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;
   ListView MobileDetailsListView;
    ProgressBar MobileProgressBar;
    String HttpUrl = "http://35.154.210.22/dpts/api/onclickfilter/setfav1.php";
    List<String> MobileList = new ArrayList<String>();
    ArrayAdapter<String> MobileArrayAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav1);

        acTextView = (MultiAutoCompleteTextView) findViewById(R.id.editText1);
        btn=(Button)findViewById(R.id.button2);
      /*  acTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                acTextView.showDropDown();
                return false;
            }
        });*/

    /*  acTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {//cut last probel
                if (charSequence.length() > 1) {
                    if (charSequence.charAt(charSequence.length() - 1) == ' ') {
                        acTextView.setText(charSequence.subSequence(0, charSequence.length() - 1));
                       acTextView.setSelection(charSequence.length() - 1);
                    }
                }
            }
*/

           /* @Override
            public void afterTextChanged(Editable editable) {
            }
        });*/
       /* acTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    acTextView.showDropDown();
                }
            }
        });*/
        //acTextView.setThreshold(-1);
        //acTextView.setAdapter(new SuggestionAdptr(this, acTextView.getText().toString()));

        acTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        acTextView.setThreshold(1);
        acTextView.setAdapter(new SuggestionAdapterFav(this,  acTextView.getText().toString()));

      //  MobileDetailsListView = (ListView)findViewById(R.id.listview1);
        //MobileDetailsListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //create an ArrayList object to store selected items
        selectedItems=new ArrayList<String>();

        MobileProgressBar = (ProgressBar)findViewById(R.id.progressBar);

//        new GetHttpResponse(MainActivity.this).execute();

        /*MobileDetailsListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Auto-generated method stub

                                *//*Intent intent = new Intent(getApplicationContext(),ShowDetailsActivity.class);

                intent.putExtra("ListViewValue", MobileList.get(position).toString());

                startActivity(intent);*//*

                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }
        });
*/


        acTextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                acTextView.showDropDown();
                return false;
            }
        });
        //acTextView.setThreshold(-1);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                acTextView.showDropDown();
            }
        }, 500);


        GetName = (EditText)findViewById(R.id.editText1);

      /*  GetPhoneNumber = (EditText)findViewById(R.id.editText2);

        GetSubject = (EditText)findViewById(R.id.editText3);*/

        Submit = (Button)findViewById(R.id.button1);

        EditData = (Button)findViewById(R.id.button2);

        //DisplayData = (Button)findViewById(R.id.button3);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();



            }
        });

       /* EditData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, EditDataActivity.class);
                startActivity(intent);

            }
        });*/

      /*  DisplayData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);

            }
        });*/


       /* Button edit=(Button)findViewById(R.id.button_edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),FavEdit.class);
                startActivity(intent);
            }
        });
*/
       /* Button name=(Button)findViewById(R.id.button_change);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1=new Intent(getApplicationContext(),FavName.class);
                startActivity(intent1);}
        });*/
    }


    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String JSonResult;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpServicesClass httpServicesClass = new HttpServicesClass(HttpUrl);
            try
            {
                httpServicesClass.ExecutePostRequest();

                if(httpServicesClass.getResponseCode() == 200)
                {
                    JSonResult = httpServicesClass.getResponse();

                    if(JSonResult != null)
                    {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(JSonResult);

                            JSONObject jsonObject;

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                jsonObject = jsonArray.getJSONObject(i);

                                MobileList.add(jsonObject.getString("Name").toString()) ;

                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpServicesClass.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            MobileProgressBar.setVisibility(View.GONE);

            MobileDetailsListView.setVisibility(View.VISIBLE);

            // Start code for remove duplicate listview values.

            HashSet<String> hashSet = new HashSet<String>();

            hashSet.addAll(MobileList);
            MobileList.clear();
            MobileList.addAll(hashSet);

            //End code here for remove duplicate values.

            MobileArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, MobileList);
            MobileDetailsListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            MobileDetailsListView.setAdapter(MobileArrayAdapter);

        }
    }


    public void showSelectedItems(View view){
        String selItems="";
        for(String item:selectedItems){
            if(selItems=="")
                selItems=item;
            else
                selItems+="\n"+item;
        }
        Toast.makeText(this, selItems, Toast.LENGTH_LONG).show();
       /* SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_SUBSEPC, MODE_PRIVATE).edit();
        editor.putString("subspec",selItems.toString());
        editor.commit();
*/
        /*Intent i=new Intent(MainActivity.this, Otp.class);

        startActivity(i);*/
    }


    public void DBCreate(){


        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);
        SQLITEDATABASE.execSQL("DROP TABLE IF EXISTS demoTable1 ");
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable1(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        /*PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();
        */
        CheckEditTextIsEmptyOrNot(Name);

        if(CheckEditTextEmpty == true)
        {


            SQLiteQuery = "INSERT INTO demoTable1 (name) VALUES('"+Name+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(MainActivity.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("favourite list...!!");
            builder.setCancelable(false);
            builder.setMessage(getResources().getString(R.string.favadd));
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(MainActivity.this, SetFavorite.class);
                    startActivity(i);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.show();
            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(MainActivity.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name){

        if(TextUtils.isEmpty(Name) ){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        GetName.getText().clear();
       /* GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();auto*/

    }

}
