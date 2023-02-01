package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private String username;
    private Button Btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_logout = (Button) findViewById(R.id.Btn_logout);
        text = (TextView) findViewById(R.id.text);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        text.setText(userID);

    }
}