package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Myinfo_Modify extends AppCompatActivity {

   Button myinfo_btn_modify;
    EditText edt_name, edt_pw, edt_tellnum;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_modify);


        edt_name = findViewById(R.id.edt_name);
        edt_pw = findViewById(R.id.edt_pw);
        edt_tellnum = findViewById(R.id.edt_tellnum);
        myinfo_btn_modify = findViewById(R.id.myinfo_btn_modify);

        queue = Volley.newRequestQueue(getApplicationContext());



        myinfo_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replace_user_info();


            }
        });
    }


    // 사용자 이름 검사
    public void replace_user_info() {
        String name = edt_name.getText().toString();
        String pw = edt_pw.getText().toString();
        String tel = edt_tellnum.getText().toString();
        // 접속한 사용자 ID가져오기
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");


        if (name.length() == 0) {
            Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
            edt_name.requestFocus();
            return;
        } else if (pw.length() == 0) {
            Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
            edt_pw.requestFocus();
            return;
        } else if (tel.length() == 0) {
            Toast.makeText(getApplicationContext(), "전화번호를 입력해주세요", Toast.LENGTH_SHORT).show();
            edt_tellnum.requestFocus();
            return;
        } else {


            String requestURL = "http://rspring41.iptime.org:3000/myinfo_modify/";
            requestURL += login_id + "?name=" + name + "&tel=" + tel + "&pw=" + pw;


            StringRequest request = new StringRequest(Request.Method.GET, requestURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("계정내역", response);
                            if (response.equals("0")) {
                                Toast.makeText(getApplicationContext(), "변경 실패", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "변경 성공", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.v("오류", "요청실패");
                        }
                    });
            queue.add(request);


        }


        Intent intent =  new Intent();
        intent.putExtra("name",name);
        intent.putExtra("id",login_id);
        intent.putExtra("tel",tel);
        setResult(RESULT_OK,intent);
        finish();
    }
}