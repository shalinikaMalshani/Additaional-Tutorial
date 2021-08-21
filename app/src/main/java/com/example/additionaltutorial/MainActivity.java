 package com.example.additionaltutorial;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

 public class MainActivity extends AppCompatActivity {

     private static final int CAMERA_REQUEST=1888;
     ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPhoto=(Button)this.findViewById(R.id.btnPhoto);
        imageView=(ImageView)this.findViewById(R.id.imageView);

        btnPhoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent cameraInt=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraInt,CAMERA_REQUEST);
            }
        });


    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         if(requestCode==CAMERA_REQUEST){}
         Bitmap photo=(Bitmap)data.getExtras().get("data");
         imageView.setImageBitmap(photo);
     }
 }