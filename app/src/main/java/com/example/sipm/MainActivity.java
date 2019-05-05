package com.example.sipm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(  "LOGCAT", "Entra en metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(  "LOGCAT", "Entra en metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(  "LOGCAT", "Entra en metodo onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(  "LOGCAT", "Entra en metodo onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(  "LOGCAT", "Entra en metodo onStart");
    }
}
