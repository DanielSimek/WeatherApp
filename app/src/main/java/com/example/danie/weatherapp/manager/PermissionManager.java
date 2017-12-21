package com.example.danie.weatherapp.manager;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.danie.weatherapp.Interface.OnPermissionRequest;

public class PermissionManager {
    private static final int REQUEST_CODE = 1;
    private OnPermissionRequest onPermissionRequest;

    public PermissionManager(OnPermissionRequest onPermissionRequest) {
        this.onPermissionRequest = onPermissionRequest;
    }

    public void onRequestPermissionsResult(
            int requestCode, String permissions[], int[] grantResults
    ) {
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onPermissionRequest.onPermissionAccepted();
            } else {
                onPermissionRequest.OnPermissionDeclined();
            }
        }
    }

    public void checkPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            int result = ContextCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
            );
            int result2 = ContextCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            );
            if (result == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED) {
                onPermissionRequest.onPermissionAccepted();
            } else {
                ActivityCompat.requestPermissions(
                        activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_CODE
                );
            }
        } else {
            onPermissionRequest.onPermissionAccepted();
        }
    }
}