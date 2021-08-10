package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
    EditText edt_myinfo_name, edt_myinfo_tellnum;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_modify);


        edt_myinfo_name.findViewById(R.id.edt_myinfo_name);
        edt_myinfo_tellnum.findViewById(R.id.edt_myinfo_tellnum);
        myinfo_btn_modify.findViewById(R.id.myinfo_btn_modify);

        queue = Volley.newRequestQueue(getApplicationContext());




        // 화원정보 수정완료 버튼
        myinfo_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (edt_myinfo_name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    edt_myinfo_name.requestFocus();
                    return;
                } else if (edt_myinfo_tellnum.length() == 0) {
                    Toast.makeText(getApplicationContext(), "전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    edt_myinfo_tellnum.requestFocus();
                    return;
                } else {

                    // 접속한 사용자 ID가져오기===================================================
                    SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
                    String login_id = sf.getString("login_id","");

                    String change_name = edt_myinfo_name.getText().toString();
                    String change_tel = edt_myinfo_tellnum.getText().toString();


                    String myinfo_modify = "http://rspring41.iptime.org:3000/myinfo_modify/";
                    myinfo_modify += login_id;




                    StringRequest request = new StringRequest(Request.Method.POST, myinfo_modify,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Log.v("계정내역", response);
                                    if (response.equals("0")) {
                                        Toast.makeText(Myinfo_Modify.this, "정보수정 실패", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Myinfo_Modify.this, "정보수정 성공", Toast.LENGTH_SHORT).show();

                                        // ShardPreference : Android 내 파일로 Data를 저장하는 기술
                                        SharedPreferences pref = getSharedPreferences("myinfo", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = pref.edit();
                                        String name = edt_myinfo_name.getText().toString();
                                        String tel  = edt_myinfo_tellnum.getText().toString();
                                        editor.putString("name", name);
                                        editor.putString("tel", tel);
                                        editor.commit();
                                        Intent intent = new Intent(Myinfo_Modify.this, Myinfo_Modify_Result.class);
                                        startActivity(intent);
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
            }
        });
    }
}