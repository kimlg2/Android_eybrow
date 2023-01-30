package com.example.eybrow.server;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest {
    final static private String URL = "http://kimlg2015.dothome.co.kr/UserVaildate.php";
    private Map<String,String> parameters;

    public ValidateRequest(String userID, Response.Listener<String> listener) {
        super(Method.POST,URL,listener,null); //해당 요청을 숨겨서 보내줌
        parameters = new HashMap<>();
        parameters.put("userID",userID);

    }
    @Override
    public Map<String, String> getParams()throws AuthFailureError {
        return parameters;
    }
} //중복 체크 해주는 클래스
