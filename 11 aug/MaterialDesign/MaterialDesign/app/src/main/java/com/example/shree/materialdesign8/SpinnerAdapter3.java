package com.example.shree.materialdesign8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vinod on 4/6/2017.
 */
public class SpinnerAdapter3 extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<DataObject> listData;
    private Context context;
    public SpinnerAdapter3(Context context, List<DataObject> listData) {
        this.context = context;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return (DataObject)listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder spinnerHolder;
        if(convertView == null){
            spinnerHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.spinner_list3, parent, false);
            spinnerHolder.spinnerItemList3 = (TextView)convertView.findViewById(R.id.spinner_list_item3);
            convertView.setTag(spinnerHolder);
        }
        else{
            spinnerHolder = (ViewHolder)convertView.getTag();
        }
        spinnerHolder.spinnerItemList3.setText(listData.get(position).getName());
        return convertView;
    }
    class ViewHolder
    {
        TextView spinnerItemList3;
    }
}
