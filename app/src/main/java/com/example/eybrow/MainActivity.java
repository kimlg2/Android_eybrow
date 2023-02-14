package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eybrow.Register.LoginActivity;

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
        String username = intent.getStringExtra("username");


        Btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText( getApplicationContext(), "로그아웃", Toast.LENGTH_SHORT ).show();
            }
        });
        text1.setText(username);
        text1.setText(username.toString()+"님 환영합니다!!");

    }
}