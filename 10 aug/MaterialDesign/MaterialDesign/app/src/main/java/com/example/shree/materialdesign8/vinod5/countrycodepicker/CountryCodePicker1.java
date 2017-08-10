package com.example.shree.materialdesign8.vinod5.countrycodepicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.hbb20.CountryCodePicker;

public class CountryCodePicker1 extends AppCompatActivity {

    CountryCodePicker ccp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_code_picker);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                Toast.makeText(CountryCodePicker1.this, "Updated " + ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();
            }
        });

        Button setting=(Button)findViewById(R.id.setting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS));
            }
        });
    }
}
