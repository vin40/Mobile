package com.example.shree.materialdesign8.vinod6.autocompletetextviewjson;

import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;


public class SuggestionAdapterState extends ArrayAdapter<String> {

	protected static final String TAG = "SuggestionAdapterState";
	private List<String> suggestions;
	public SuggestionAdapterState(Activity context, String nameFilter) {
		super(context, android.R.layout.simple_dropdown_item_1line);
		suggestions = new ArrayList<String>();
	}

	@Override
	public int getCount() {
		return suggestions.size();
	}

	@Override
	public String getItem(int index) {
		return suggestions.get(index);
	}

	@Override
	public Filter getFilter() {
		Filter myFilter = new Filter() {
			@Override
			protected FilterResults performFiltering(CharSequence constraint) {
				FilterResults filterResults = new FilterResults();
				JsonParseState jp=new JsonParseState();
				if (constraint != null) {
					// A class that queries a web API, parses the data and
					// returns an ArrayList<GoEuroGetSet>
					List<SuggestGetSetState> new_suggestions =jp.getParseJsonWCF(constraint.toString());
					suggestions.clear();
					for (int i=0;i<new_suggestions.size();i++) {
						Log.d("statelist",new_suggestions.get(i).getCity_name());
						suggestions.add(new_suggestions.get(i).getCity_name());

					}
					
					// Now assign the values and count to the FilterResults
					// object
					filterResults.values = suggestions;
					filterResults.count = suggestions.size();
				}
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence contraint,
					FilterResults results) {
				if (results != null && results.count > 0) {
					notifyDataSetChanged();
				} else {
					notifyDataSetInvalidated();
				}
			}
		};
		return myFilter;
	}

	

}
