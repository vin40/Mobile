package com.example.shree.materialdesign8.vinod4.setfavorite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.SqliteFav.MainActivity;
import com.example.shree.materialdesign8.vinod.SqliteFav.ShowDb;
import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod10.SqliteFav.Fav5;
import com.example.shree.materialdesign8.vinod10.SqliteFav.ShowDb5;
import com.example.shree.materialdesign8.vinod7.sqlFav.Fav2;
import com.example.shree.materialdesign8.vinod7.sqlFav.ShowDb2;
import com.example.shree.materialdesign8.vinod8.sqliteFav.Fav3;
import com.example.shree.materialdesign8.vinod8.sqliteFav.ShowDb3;
import com.example.shree.materialdesign8.vinod9.sqliteFav.Fav4;
import com.example.shree.materialdesign8.vinod9.sqliteFav.ShowDb4;

public class SetFavorite extends AppCompatActivity {
    SharedPreferences  sharedPreferences;
    String Fav11,Fav12,Fav13,Fav14,Fav15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_favorite);

        Button fav1=(Button)findViewById(R.id.setfav1);
        Button fav2=(Button)findViewById(R.id.setfav2);
        Button fav3=(Button)findViewById(R.id.setfav3);
        Button fav4=(Button)findViewById(R.id.setfav4);
        Button fav5=(Button)findViewById(R.id.setfav5);

                SharedPreferences prefs = getSharedPreferences(ShowDb.Fav1, MODE_PRIVATE);
                String restoredText = prefs.getString("text", null);

                Fav11 = prefs.getString("favrename", null);
                if(Fav11 == null)
                {
                    Toast.makeText(SetFavorite.this,"nothing set",Toast.LENGTH_LONG).show();
                }
                else
                {
                    fav1.setText(Fav11.toString());
                }

        SharedPreferences prefs2 = getSharedPreferences(ShowDb2.Fav2, MODE_PRIVATE);
        String restoredText2 = prefs2.getString("text", null);

        Fav12 = prefs2.getString("favrename", null);
        if(Fav12 == null)
        {
            Toast.makeText(SetFavorite.this,"nothing set",Toast.LENGTH_LONG).show();
        }
        else
        {
            fav2.setText(Fav12.toString());
        }

        SharedPreferences prefs3 = getSharedPreferences(ShowDb3.Fav3, MODE_PRIVATE);
        String restoredText3 = prefs3.getString("text", null);

        Fav13 = prefs3.getString("favrename", null);
        if(Fav13 == null)
        {
            Toast.makeText(SetFavorite.this,"nothing set",Toast.LENGTH_LONG).show();
        }
        else
        {
            fav3.setText(Fav13.toString());
        }

        SharedPreferences prefs4 = getSharedPreferences(ShowDb4.Fav4, MODE_PRIVATE);
        String restoredText4 = prefs4.getString("text", null);

        Fav14 = prefs4.getString("favrename", null);
        if(Fav14 == null)
        {
            Toast.makeText(SetFavorite.this,"nothing set",Toast.LENGTH_LONG).show();
        }
        else
        {
            fav4.setText(Fav14.toString());
        }

        SharedPreferences prefs5 = getSharedPreferences(ShowDb5.Fav5, MODE_PRIVATE);
        String restoredText5 = prefs5.getString("text", null);

        Fav15 = prefs5.getString("favrename", null);
        if(Fav15 == null)
        {
            Toast.makeText(SetFavorite.this,"nothing set",Toast.LENGTH_LONG).show();
        }
        else
        {
            fav5.setText(Fav15.toString());
        }



//fav1.setText(Fav11.toString());
        fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav1();
            }

            private void fav1() {
                sharedPreferences = getSharedPreferences("Fav1", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), ShowDb.class);
                    startActivity(intent);
                }

            }
        });

        fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav2();
            }

            private void fav2() {
                sharedPreferences = getSharedPreferences("Fav2", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), Fav2.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),ShowDb2.class);
                    startActivity(intent);
                }

            }
        });

        fav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fav3();
            }

            private void fav3() {
                sharedPreferences = getSharedPreferences("Fav3", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), Fav3.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), ShowDb3.class);
                    startActivity(intent);
                }

            }


        });

        fav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fav4();

            }

            private void fav4() {
                sharedPreferences = getSharedPreferences("Fav4", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), Fav4.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), ShowDb4.class);
                    startActivity(intent);
                }

            }

        });

        fav5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fav5();
            }

            private void fav5() {
                sharedPreferences = getSharedPreferences("Fav5", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), Fav5.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(),ShowDb5.class);
                    startActivity(intent);
                }

            }


        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i=new Intent(SetFavorite.this, Dashboard.class);
        startActivity(i);
    }
}
