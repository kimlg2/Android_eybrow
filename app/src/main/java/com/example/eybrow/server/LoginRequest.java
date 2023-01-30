package com.example.eybrow.server;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    final static private String URL = "http://kimlg2015.dothome.co.kr/Userlogin.php";
    private Map<String,String> parameters;

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener) {
        super(Request.Method.POST,URL,listener,null); //해당 요청을 숨겨서 보내줌
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
          }
    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
