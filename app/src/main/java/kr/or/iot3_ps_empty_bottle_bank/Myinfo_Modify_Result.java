package kr.or.iot3_ps_empty_bottle_bank;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import PSbankFagment.Fragment_Myinfo;
import PSbankVO.Myinfo_VO;

public class Myinfo_Modify_Result extends AppCompatActivity {

    Button myinfo_result_btn_modify;
    TextView myinfo_result_name, myinfo_result_id, myinfo_result_tellnum;

    RequestQueue queue;

    private ArrayList<Myinfo_VO> Myinfo_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_modify_result);


        myinfo_result_name = findViewById(R.id.myinfo_result_name);
        myinfo_result_id = findViewById(R.id.myinfo_result_id);
        myinfo_result_tellnum = findViewById(R.id.myinfo_result_tellnum);



        queue = Volley.newRequestQueue(getApplicationContext());

        // 접속한 사용자 ID가져오기===================================================
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");


        String myinfo_url = "http://rspring41.iptime.org:3000/myinfo";
        myinfo_url += "/" + login_id;

        StringRequest request = new StringRequest(Request.Method.GET, myinfo_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray myinfo_array = new JSONArray(response);
                            JSONObject myinfo = myinfo_array.getJSONObject(0);

                            myinfo_result_name.setText("이름 : " + myinfo.getString("name"));
                            myinfo_result_id.setText("아이디 : " + myinfo.getString("id"));
                            myinfo_result_tellnum.setText("전화번호 : " + myinfo.getString("tel"));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("오류", "접속실패");
                Toast.makeText(getApplicationContext(), "접속 실패", Toast.LENGTH_SHORT).show();

            }
        });


        //요청큐에 요청 객체 생성
        queue.add(request);


        myinfo_result_btn_modify = findViewById(R.id.myinfo_result_btn_modify);



        myinfo_result_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Myinfo_Modify.class);
                startActivityForResult(intent,1000);


            }
        });


//
//        myinfo_result_btn_modify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Myinfo_Modify.class);
//                startActivity(intent);
//            }
//        });


    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1000){

            myinfo_result_name.setText("이름 : " + data.getStringExtra("name"));
            myinfo_result_id.setText("아이디 : " + data.getStringExtra("id"));
            myinfo_result_tellnum.setText("전화번호 : " + data.getStringExtra("tel"));

        }


    }
}