package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text1;
    private String userID;
    private TextView Btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_logout = (TextView) findViewById(R.id.Btn_logout);
        text1 = (TextView) findViewById(R.id.text1);


        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        Btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        text1.setText(userID);


    }
}