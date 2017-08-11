package com.example.shree.materialdesign8.allocator.activity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shree.materialdesign8.R;


public class AdapterTodayPatient extends BaseAdapter {

    private Activity activity;
    public ImageLoader imageLoader;


    public AdapterTodayPatient(Activity act) {
        this.activity = act;
        imageLoader = new ImageLoader(act);

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return TodaysPatient.Menu_ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_list_item_todays, null);
            holder = new ViewHolder();

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtText = (TextView) convertView.findViewById(R.id.txtText);
        holder.txtSubText = (TextView) convertView.findViewById(R.id.txtSubText);
        holder.imgThumb = (ImageView) convertView.findViewById(R.id.imgThumb);

        holder.txtText.setText(TodaysPatient.Menu_name.get(position));
       holder.txtSubText.setText(TodaysPatient.Menu_price.get(position)+" "+TodaysPatient.Currency);

       // imageLoader.DisplayImage(Constant.AdminPageURL+TodaysPatient.Menu_image.get(position), holder.imgThumb);

        return convertView;
    }

    static class ViewHolder {
        TextView txtText, txtSubText;
        ImageView imgThumb;
    }


}
