package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eybrow.Register.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main_Activity";
    private TextView slide_nametext1;
    private String userID;
    private Button btnLogout;
    private ImageView iv_menu;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        btnLogout = (Button) findViewById(R.id.btnLogout);
        slide_nametext1 = (TextView) findViewById(R.id.slide_nametext1);
        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar= findViewById(R.id.toolbar);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");


        setSupportActionBar(toolbar);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide_nametext1.setText(username);
                slide_nametext1.setText(username.toString()+"님 환영합니다!!");
                Log.d(TAG,"onClick: 클릭됨");
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                Toast.makeText( getApplicationContext(), "로그아웃", Toast.LENGTH_SHORT ).show();
//            }
//        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu,menu);
        return false;
    }
}