package com.example.shree.materialdesign8.vinod.SqliteFav;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonP {
	 double current_latitude,current_longitude;
	 public JsonP(){}
	 public JsonP(double current_latitude, double current_longitude)
	 {
		 this.current_latitude=current_latitude;
		 this.current_longitude=current_longitude;
	 }
	 public List<SuggestGS> getParseJsonWCF(String sName)
		{
		 List<SuggestGS> ListData = new ArrayList<SuggestGS>();
		 try
		 {
			String temp=sName.replace(" ", "%20");
			URL js = new URL("http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/onclickfilter/testautocomplte.php?Name="+temp);
			URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("results");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
                ListData.add(new SuggestGS(r.getString("Id"),r.getString("Name")));
        	}
		}
		 catch (Exception e1)
		 {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 return ListData;
		 
		}
	 
}
