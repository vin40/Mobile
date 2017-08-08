package com.example.shree.materialdesign8.vinod.confirmation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod2.labcategory.Thankyou;

public class ConfirmationMassagePhoto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_massage_photo);
        final TextView n=(TextView)findViewById(R.id.pname);
        final TextView m=(TextView)findViewById(R.id.pmnumber);
        final TextView l=(TextView)findViewById(R.id.landmark);
        final TextView z=(TextView)findViewById(R.id.zipcode);

        Intent intentt =getIntent();
        Bundle bb=intentt.getExtras();
        String namep=bb.getString("patname");
        String mobilep=bb.getString("phonenum");
        String landmarkp=bb.getString("house");
        String pincodep=bb.getString("Ipincode");

        n.setText(namep);
        m.setText(mobilep);
        l.setText(landmarkp);
        z.setText(pincodep);

        Button b1=(Button)findViewById(R.id.confirm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getBaseContext(), Thankyou.class);
                startActivity(i);
            }
        });
    }
}
