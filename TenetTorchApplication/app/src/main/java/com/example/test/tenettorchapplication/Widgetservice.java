package com.example.test.tenettorchapplication;
import android.app.Service;
import android.content.Intent;
import android.hardware.Camera;
import android.os.IBinder;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.test.tenettorchapplication.R;

public class Widgetservice extends Service {
    private Camera mCamera;
    private boolean isOn = false;
    @Override
    public void onCreate() {
        super.onCreate();
       }
    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        if(!isOn){
            mCamera = Camera.open();
            if(mCamera != null){
                Toast.makeText(this, "Torch is On", Toast.LENGTH_SHORT).show();
                Camera.Parameters params = mCamera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                mCamera.setParameters(params);
                isOn = true;
            }
        }else{
            Toast.makeText(this, "Torch is off", Toast.LENGTH_SHORT).show();
            mCamera.release();
            mCamera = null;
            isOn = false;
            stopSelf();
        }
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
