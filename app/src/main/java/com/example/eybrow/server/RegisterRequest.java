package com.example.eybrow.server;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL = "http://kimlg2015.dothome.co.kr/UserRegister.php";
    private Map<String,String> parameters;

    public RegisterRequest(String userID,String username, String userPassword, String userGender, String userMajor, String userEmail, Response.Listener<String> listener) {
       super(Method.POST,URL,listener,null); //해당 요청을 숨겨서 보내줌
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("username",username);
        parameters.put("userPassword",userPassword);
        parameters.put("userGender",userGender);
        parameters.put("userMajor",userMajor);
        parameters.put("userEmail",userEmail); //값들을 parameters로 매치
    }
    @Override
    public Map<String, String> getParams() {

        return parameters;
    }
} //해당 php 정보를 보내서 회원가입 시켜주는 코드
