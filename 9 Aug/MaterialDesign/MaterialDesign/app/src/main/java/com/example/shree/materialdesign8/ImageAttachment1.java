package com.example.shree.materialdesign8;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shree.materialdesign8.vinod2.labcategory.Varify;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class ImageAttachment1 extends AppCompatActivity implements Imageutils.ImageAttachmentListener {

    ImageView iv_attachment;
    ProgressDialog loading;
    //For Image Attachment

    private Bitmap bitmap;
    private String file_name;
    String count = "5";
  int n;
    Imageutils imageutils;
 // public static final String UPLOAD_URL = "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/dpts/doctor/ecommerce/upload.php";
  public static final String UPLOAD_URL ="http://vilasjadhav.16mb.com/ecommerce/upload.php";
    public static final String UPLOAD_KEY = "image";
    public static final String ref = "ref";
    private Button buttonUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_image_atachment_t);

        imageutils =new Imageutils(this);

        iv_attachment=(ImageView)findViewById(R.id.imageView);
        buttonUpload = (Button) findViewById(R.id.buttonUpload);
        iv_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageutils.imagepicker(1);
            }
        });


        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadImage();
            }
        });

    }
    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp = ((BitmapDrawable) iv_attachment.getDrawable()).getBitmap();
        bmp.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    public void image_attachment(int from, String filename, Bitmap file, Uri uri) {
        this.bitmap=file;
        this.file_name=filename;
        iv_attachment.setImageBitmap(file);

        String path =  Environment.getExternalStorageDirectory() + File.separator + "ImageAttach" + File.separator;
        imageutils.createImage(file,filename,path,false);
    }
    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String> {

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ImageAttachment1.this, "Uploading...", null,true,true);
            }

            @Override
            protected void onPostExecute(final String s) {
                super.onPostExecute(s);
                loading.dismiss();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ImageAttachment1.this);

                // Setting Dialog Title
                alertDialog.setTitle("Your Information...");
                alertDialog.setCancelable(false);
                // Setting Dialog Message
                alertDialog.setMessage("Your Reference id is"+String.valueOf(n));

                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.save);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed YES button. Write Logic Here

                       Intent i=new Intent(ImageAttachment1.this,Varify.class);
                        startActivity(i);
                      //  Toast.makeText(getApplicationContext(),"thanks",Toast.LENGTH_LONG).show();
                    }
                });

                /*// Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed No button. Write Logic Here
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                    }
                });*/

                // Setting Netural "Cancel" Button
               alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User pressed Cancel button. Write Logic Here
                        Toast.makeText(getApplicationContext(), "You clicked on Cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                // Showing Alert Message
                alertDialog.show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
               // String uploadImage = image_attachment(0,null,bitmap,Uri);
                String uploadImage = getStringImage(bitmap);
                Random rand = new Random();

                n = rand.nextInt(00145) + 1;
                count=String.valueOf(n);
              String count=String.valueOf(n);
                HashMap<String,String> data = new HashMap<>();

                data.put(UPLOAD_KEY, uploadImage);
                data.put(ref,count);

                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        imageutils.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        imageutils.request_permission_result(requestCode, permissions, grantResults);
    }



}
