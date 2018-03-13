package com.example.apurva.useofcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button camera,set_wallpaper;
    Intent intent;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageview);
        camera=findViewById(R.id.btn_open_camera);
        set_wallpaper=findViewById(R.id.btn_set_wallpaper);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data!=null){
            Bundle b=data.getExtras();

           bitmap=(Bitmap) b.get("data");

            imageView.setImageBitmap(bitmap);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
