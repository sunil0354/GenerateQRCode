package com.app.generateqrcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private String TAG="tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LinearLayout line1=findViewById(R.id.line1);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        // Register ourselves as a handler for scan results.
        mScannerView.setResultHandler(this);
        // Start camera on resume
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.e(TAG, "handleResult: "+result);
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
        mScannerView.stopCameraPreview();
    }

    @Override
    public void onPause() {
        super.onPause();
        // Stop camera on pause
        mScannerView.stopCamera();
    }
}
