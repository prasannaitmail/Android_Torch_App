package com.example.test.tenettorchapplication;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class TenetTorchApplication extends Activity {
    private boolean isFlashOn = false;
    private Camera camera;
    private ToggleButton button;

    @Override
    protected void onStop() {
        super.onStop();

        if (camera != null) {
            camera.release();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenet_torch_application);
        button = (ToggleButton)findViewById(R.id.toggleButton1);
        Context context = this;
        PackageManager pm = context.getPackageManager();


        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Device has no camera!");
            Toast.makeText(getApplicationContext(),
                    "Your device doesn't have camera!",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        camera = Camera.open();
        final Camera.Parameters p = camera.getParameters();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.isChecked()==true){

                    button.setBackgroundResource(R.drawable.ontorch);
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(p);
                    isFlashOn = true;
                }
                if(button.isChecked()==false){
                    button.setBackgroundResource(R.drawable.offstate);
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(p);
                    isFlashOn = false;
                }
            }
        });



















        /*button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (isFlashOn) {
                    button.setBackgroundResource(R.drawable.offstate);
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(p);
                    isFlashOn = false;

                } else {
                    button.setBackgroundResource(R.drawable.ontorch);
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(p);
                    isFlashOn = true;

                }
            }
        });*/

    }
}
