package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eybrow.Register.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private TextView text1;
    private String userID;
    private Button Btn_logout;
    private ImageView iv_menu;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Btn_logout = (Button) findViewById(R.id.Btn_logout);
        text1 = (TextView) findViewById(R.id.text1);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer_layout);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
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