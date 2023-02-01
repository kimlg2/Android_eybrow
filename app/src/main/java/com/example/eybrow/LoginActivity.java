package com.example.eybrow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.eybrow.server.LoginRequest;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText idText, passwordText;
    Button Btn_login;
    TextView Btn_register,Btn_IDPWfind;
    private AlertDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        Btn_login = (Button) findViewById(R.id.Btn_login);
        Btn_register = (TextView)findViewById(R.id.Btn_register);
        Btn_IDPWfind = (TextView)findViewById(R.id.Btn_IDPWfind);



        Btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
        Btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();


                Response.Listener<String> responseLister = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response); //해당 결과값

                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                               AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                               dialog = builder.setMessage("로그인 성공")
                                       .setPositiveButton("확인",null)
                                       .create();
                               dialog.show();
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("userID",userID);
                                LoginActivity.this.startActivity(intent);
                                finish();
                            }//로그인 성공
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                dialog = builder.setMessage("계정을 다시 확인해주세요.")
                                        .setNegativeButton("다시시도",null)
                                        .create();
                                    dialog.show();
                            } //로그인을 실패시
                        }
                       catch (Exception e) {
                        e.printStackTrace();
                        }
                    }
                };//결과를 받아오는 코드
                LoginRequest loginRequest = new LoginRequest(userID,userPassword,responseLister);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }

        });
        Btn_IDPWfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent idpwintent = new Intent(LoginActivity.this,IDPWfindActivity.class);
                LoginActivity.this.startActivity(idpwintent);
            }
        });



    }
    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    } //함부로 종료되지 않게 해주는것
}