package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParseState {
	 double current_latitude,current_longitude;
	 public JsonParseState(){}
	 public JsonParseState(double current_latitude, double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSetState> getParseJsonWCF(String sName)
		{
		 List<SuggestGetSetState> ListData = new ArrayList<SuggestGetSetState>();
		 try {
			String temp=sName.replace(" ", "%20");
			 //http://sujwalinsure.com/insure/ws/fetch_citylist.php?state_id=13
			 //
			//URL js = new URL("http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/onclickfilter/autocomptejson.php?Specility="+temp);
			 URL js = new URL("http://sujwalinsure.com/insure/ws/fetch_citylist.php?state_name="+temp);

			 URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("citylist");
			 Log.d("citylist",jsonArray.toString());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
				Log.d("citylistid",r.getString("city_id"));
                ListData.add(new SuggestGetSetState(r.getString("city_id"),r.getString("city_name")));
        	}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
