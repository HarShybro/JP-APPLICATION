package com.example.justplay;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class AllowAccessActivity extends AppCompatActivity {
    public static final int STORAGE_PERMISSION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allow_access);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)  != PackageManager.PERMISSION_GRANTED){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }else{
            ActivityCompat.requestPermissions(AllowAccessActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},STORAGE_PERMISSION);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode== STORAGE_PERMISSION){
            for (int i=0; i<permissions.length;i++){
                String per= permissions[i];
                if(grantResults[i]== PackageManager.PERMISSION_DENIED){
                    
                }
            }
        }
    }
}