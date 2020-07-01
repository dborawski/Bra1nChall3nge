package com.example.brainchall3nge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
    public void freeStyle(View view){
        Intent fs = new Intent(this, Freestyle.class);
        startActivity(fs);
        finish();
    }
    public void speedRun(View view){
        Intent sr = new Intent(this, Freestyle.class);
        startActivity(sr);
        finish();
    }
}
