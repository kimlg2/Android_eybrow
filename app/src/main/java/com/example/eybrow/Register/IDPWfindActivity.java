package com.example.eybrow.Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.eybrow.LodingActivity;
import com.example.eybrow.MainActivity;
import com.example.eybrow.R;
import com.example.eybrow.server.IDPWfindRequest;
import com.example.eybrow.server.LoginRequest;
import com.example.eybrow.server.RegisterRequest;

import org.json.JSONObject;

public class IDPWfindActivity extends AppCompatActivity {
    Button id_search,pwd_search;
    EditText id_name,id_password,pwd_id,pwd_name;
    TextView id_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idpwfind);
        id_search = (Button) findViewById(R.id.id_search);
        pwd_search = (Button) findViewById(R.id.pwd_search);
        id_name = (EditText) findViewById(R.id.id_name);
        id_password = (EditText) findViewById(R.id.id_password);
        pwd_id = (EditText) findViewById(R.id.pwd_id);
        pwd_name = (EditText) findViewById(R.id.pwd_name);
        id_id = (TextView) findViewById(R.id.id_id);

        id_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = id_name.getText().toString();
                String userPassword = id_password.getText().toString();
                String userID = id_id.getText().toString();
                Response.Listener<String> responseLister = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response); //해당 결과값

                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = getIntent();
                                String userID = intent.getStringExtra("userID");
                                id_id.setText(userID);
                                intent.putExtra("userID", userID);
                                id_id.setText(userID.toString()+"입니다.");
                                startActivity(intent);
                            }//아이디 찾기 성공
                            else {
                                Toast.makeText( getApplicationContext(), "이름와 비밀번호를 다시확인..", Toast.LENGTH_SHORT ).show();
                                return;
                            } //아이디 찾기 실패시
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };//결과를 받아오는 코드
            }
        });


    }
}