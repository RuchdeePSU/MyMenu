package com.example.ruchee.mymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        
        // add comment to test updating master
        
        Toast.makeText(MainActivity.this,
                    Test Toast Message",
                    Toast.LENGTH_SHORT)
                    .show();
    }
}
