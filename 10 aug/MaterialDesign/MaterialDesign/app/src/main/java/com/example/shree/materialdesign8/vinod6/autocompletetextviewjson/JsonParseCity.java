package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParseCity {
	 double current_latitude,current_longitude;
	 public JsonParseCity(){}
	 public JsonParseCity(double current_latitude, double current_longitude){
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGetSetCity> getParseJsonWCF(String sName)
		{
		 List<SuggestGetSetCity> ListData = new ArrayList<SuggestGetSetCity>();
		 try {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://sujwalinsure.com/insure/ws/fetch_areapincodelist.php?city_name="+temp);
			URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("area_pincodelist");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new SuggestGetSetCity(r.getString("ap_id"),r.getString("area_name")));
        	}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
