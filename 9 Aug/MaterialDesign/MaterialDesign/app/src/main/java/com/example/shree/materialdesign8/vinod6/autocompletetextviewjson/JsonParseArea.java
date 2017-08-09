package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParseArea {
	 double current_latitude,current_longitude;
	 public JsonParseArea(){}
	 public JsonParseArea(double current_latitude, double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSetArea> getParseJsonWCF(String sName)
		{
		 List<SuggestGetSetArea> ListData = new ArrayList<SuggestGetSetArea>();
		 try {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://sujwalinsure.com/insure/ws/fetch_lablist.php?area="+temp);
			URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("area_pincodelist");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new SuggestGetSetArea(r.getString("lab_id"),r.getString("state_id")));
        	}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
