package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView username;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("demo") && password.getText().toString().equals("demo")){
                    //correct
                    sendData("LOGIN SUCCESSFUL");
                 //   Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                }else
                    //incorrect
                    sendData("LOGIN FAILED");
                   // Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void sendData(String response)
    {
       // name = username.getText().toString().trim();
        name = response;
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra(SecondActivity.name, name);
        startActivity(i);
    }
}