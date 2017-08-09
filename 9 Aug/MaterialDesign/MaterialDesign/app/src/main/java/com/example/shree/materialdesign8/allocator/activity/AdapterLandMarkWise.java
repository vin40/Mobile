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


public class AdapterLandMarkWise extends BaseAdapter {

    private Activity activity;
    public ImageLoader imageLoader;


    public AdapterLandMarkWise(Activity act) {
        this.activity = act;
    //    imageLoader = new ImageLoader(act);

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return LandmarkWise.Menu_ID.size();
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
            convertView = inflater.inflate(R.layout.menu_list_item_area, null);
            holder = new ViewHolder();

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtText = (TextView) convertView.findViewById(R.id.txtText);
        holder.txtSubText = (TextView) convertView.findViewById(R.id.txtSubText);
       /* holder.timeline1 = (TextView) convertView.findViewById(R.id.timeline1);
        holder.rating1 = (TextView) convertView.findViewById(R.id.rating1);
        holder.mobileno = (TextView) convertView.findViewById(R.id.mobileno);*/
        holder.discount = (TextView) convertView.findViewById(R.id.discount);
        holder.Area = (TextView) convertView.findViewById(R.id.area);
        /*holder.landline = (TextView) convertView.findViewById(R.id.landline);*/



       // holder.imgThumb = (ImageView) convertView.findViewById(R.id.imgThumb);

        holder.txtText.setText(LandmarkWise.Menu_name.get(position));
        holder.txtSubText.setText(LandmarkWise.address1.get(position));
/*
        holder.mobileno.setText(LandmarkWise.mobile.get(position));
        holder.landline.setText(LandmarkWise.landline.get(position));
        holder.timeline1.setText(LandmarkWise.Timeline.get(position));
        holder.rating1.setText(LandmarkWise.Rating.get(position));
*/
        holder.Area.setText(LandmarkWise.landmark.get(position));
        /*holder.discount.setText(LandmarkWise.Discount.get(position));*/
   // holder.txtSubText.setText(LandmarkWise.Menu_price.get(position)+" "+NamePatient.Currency);

       // imageLoader.DisplayImage(Constant.AdminPageURL+NamePatient.Menu_image.get(position), holder.imgThumb);

        return convertView;
    }

    static class ViewHolder {
        TextView txtText, txtSubText,mobileno,timeline1,rating1,discount,landline,Area;
        ImageView imgThumb;
    }


}
