package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {


    EditText Login_edt_ID, Login_edt_PW;
    Button Login_btn_login, Login_btn_join;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 초기화 작업 진행 했습니다.
        queue = Volley.newRequestQueue(getApplicationContext());
        Login_edt_ID = findViewById(R.id.Login_edt_ID);
        Login_edt_PW = findViewById(R.id.Login_edt_PW);
        Login_btn_login = findViewById(R.id.Login_btn_login);
        Login_btn_join = findViewById(R.id.Login_btn_join);

        //우선 간단하게 회원가입 페이지로 넘어가기만 하게 만들어놨어요
        // 회원가입 페이지 레이아웃은 안만들어 놨구 흰 화면 만 뜨는데 정상인겁니다!
        Login_btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Join_Activity2.class);
                startActivity(intent);
                // 액티비티 화면 전환 할 일 있을때 Intent객채 활용하여 액티비티 화면 전환해 주세요~ 정현이형띠!
            }
        });


        Login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = Login_edt_ID.getText().toString();
                String pw = Login_edt_PW.getText().toString();

                String login_url = "http://rspring41.iptime.org:3000/login";

                if(id.length() == 0){
                    Toast.makeText(Login_Activity.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    Login_edt_ID.requestFocus();
                    return;
                }
                if(pw.length() == 0){
                    Toast.makeText(Login_Activity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    Login_edt_PW.requestFocus();
                    return;
                }

                StringRequest request = new StringRequest(Request.Method.POST, login_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.v("계정내역", response);
                                if(response.equals("0")){
                                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Login_Activity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                                    // ShardPreference : Android 내 파일로 Data를 저장하는 기술
                                    SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = pref.edit();
                                    String login_id = Login_edt_ID.getText().toString();
                                    editor.putString("login_id", login_id);
                                    editor.commit();
                                    Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("오류", "요청실패");
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();

                        params.put("id", id);
                        params.put("pw", pw);

                        return params;
                    }
                };
                queue.add(request);


            }
        });
    }
}
