package com.fwd.testapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.droids.apppermission.AppPermissionHandler;
import com.droids.apppermission.AppPermissions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    private MainActivityViewModel viewModel;

    private ModelClass modelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        AppPermissions.check(MainActivity.this, permissions, null, null, new AppPermissionHandler() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(Context context, ArrayList<String> deniedPermissions) {
                super.onDenied(context, deniedPermissions);
                Toast.makeText(MainActivity.this, "Permission required", Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.getData();

        viewModel.getResponseData().observe(this, modelClass1 -> {
            modelClass = modelClass1;
        });



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(MainActivity.this, MapsActivity.class));
//            }
//        }, 5000);
    }
}