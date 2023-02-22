package com.example.eybrow;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eybrow.Fragment.Fragment1;
import com.example.eybrow.Fragment.Fragment2;
import com.example.eybrow.Fragment.Fragment3;
import com.example.eybrow.Fragment.Fragment4;
import com.example.eybrow.Fragment.FragmentCallback;
import com.example.eybrow.Register.LoginActivity;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView slide_nametext1;
    private String userID, username;
    private Button btnLogout;
    private ImageView iv_menu;
    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        btnLogout = (Button) findViewById(R.id.btnLogout);
        slide_nametext1 = (TextView) findViewById(R.id.slide_nametext1);
//        iv_menu = (ImageView) findViewById(R.id.iv_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String username = intent.getStringExtra("username");
                slide_nametext1.setText(username.toString() + "님 환영합니다!!");
                slide_nametext1.setText(username);
            }

        });
    }
}

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                Toast.makeText( getApplicationContext(), "로그아웃", Toast.LENGTH_SHORT ).show();
//            }
//        });


