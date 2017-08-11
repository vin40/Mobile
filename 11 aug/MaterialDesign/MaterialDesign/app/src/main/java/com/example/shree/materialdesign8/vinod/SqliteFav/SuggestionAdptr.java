package com.example.shree.materialdesign8.vinod.SqliteFav;


import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import android.widget.AutoCompleteTextView;
import android.widget.Filter;

public class SuggestionAdptr extends ArrayAdapter<String>
{

	protected static final String TAG = "SuggestionAdptr";
	private List<String> suggestions;
	public SuggestionAdptr(Activity context, String nameFilter) {
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
				JsonP jp=new JsonP();
				if (constraint != null) {
					// A class that queries a web API, parses the data and
					// returns an ArrayList<GoEuroGetSet>
					List<SuggestGS> new_suggestions =jp.getParseJsonWCF(constraint.toString());
					suggestions.clear();
					for (int i=0;i<new_suggestions.size();i++) {
						suggestions.add(new_suggestions.get(i).getName());

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
