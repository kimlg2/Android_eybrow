package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text1;
    private String userID;
    private Button Btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_logout = (Button) findViewById(R.id.Btn_logout);
        text1 = (TextView) findViewById(R.id.text1);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        text1.setText(userID);

    }
}