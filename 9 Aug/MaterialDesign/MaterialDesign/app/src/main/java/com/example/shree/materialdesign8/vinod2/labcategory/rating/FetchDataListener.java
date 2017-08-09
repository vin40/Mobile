package com.example.shree.materialdesign8.vinod2.labcategory.rating;

import android.view.View;
import android.widget.AdapterView;

import java.util.List;

public interface FetchDataListener {
    public void onFetchComplete(List<Application> data);

    void onListItemClick(AdapterView<?> parent, View v, int position, long id);

    public void onFetchFailure(String msg);
}
