package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String name = "NAME";
    private TextView msgText;
    private String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        msgText = findViewById(R.id.sName);

        Intent i = getIntent();
        msg = i.getStringExtra(name);

        msgText.setText( msg + "!!");

    }
}