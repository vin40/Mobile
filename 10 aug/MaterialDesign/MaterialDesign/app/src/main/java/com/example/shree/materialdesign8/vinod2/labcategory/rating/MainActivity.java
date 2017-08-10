package com.example.shree.materialdesign8.vinod2.labcategory.rating;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;

public class MainActivity extends ListActivity implements FetchDataListener{
    private ProgressDialog dialog;
    private List<Application> items;
    private ApplicationAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.activity_rating2);
        items = new ArrayList<>();
        initView();
    }

    private void initView() {
        // show progress dialog
        dialog = ProgressDialog.show(this, "", "Loading...");
        
        String url = "http://35.154.210.22/dpts/api/ratingwise.php";
        FetchDataTask task = new FetchDataTask(this);
        task.execute(url);
    }
    
    @Override
    public void onFetchComplete(List<Application> data) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // create new adapter
        ApplicationAdapter adapter = new ApplicationAdapter(this, data);

        // set the adapter to list
        setListAdapter(adapter);        
    }

    @Override
    public void onListItemClick(AdapterView<?> parent, View v, int position, long id) {
        super.onListItemClick((ListView) parent, v, position, id);
       Toast.makeText(getApplicationContext(),"You click"+items.get(position).getTitle(),Toast.LENGTH_LONG).show();

    }


    @Override
    public void onFetchFailure(String msg) {
        // dismiss the progress dialog
        if(dialog != null)  dialog.dismiss();
        // show failure message
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();        
    }
}
