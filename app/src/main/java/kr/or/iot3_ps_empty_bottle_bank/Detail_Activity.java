package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import PSbankVO.main_DetailVO;
import PSbankVO.main_ProductVO;

public class Detail_Activity extends AppCompatActivity {


    ImageView Detail_img;
    TextView Detail_bottle_set_num, Detail_bottle_now_num, machine_name_tlt;
    Button Check_loc_btn;
    RequestQueue detail_queue;
    private ArrayList<main_DetailVO> Detail_data;


    // Detail에 들어갈


    private String machine_name;
    private String max_bottle;
    private String now_bottle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        int machine_num = getIntent().getIntExtra();


        //회수기 이름
        machine_name_tlt = findViewById(R.id.machine_name_tlt);
        //회수기 투입가능 갯수
        Detail_bottle_set_num = findViewById(R.id.Detail_bottle_set_num);
        //회수기 현재
        Detail_bottle_now_num = findViewById(R.id.Detail_bottle_now_num);
        detail_queue = Volley.newRequestQueue(getApplicationContext());

        String Detail_url = "http://rspring41.iptime.org:3000/machine/1";

        StringRequest request = new StringRequest(Request.Method.GET, Detail_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //tv_data.setText(response);
                        //response 객체에는 JSONARRay형태 정보가 담겨있기 때문에
                        //JSONArray 타입으로 객체생성 필요

                        try {

                            JSONArray machine_infos = new JSONArray(response);


                        for (int i=0; i<machine_infos.length(); i++) {
                            JSONObject machine_info = machine_infos.getJSONObject(i);

                            String machine_name = machine_info.getString("machine_name");
                            String max_bottle = machine_info.getString(" max_bottle");
                            String now_bottle = machine_info.getString("now_bottle");

                            Log.d("몽키 D 루피 해적왕이 될꺼야!", "machineㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ_name");
                            Log.d("몽키 D 루피 해적왕이 될꺼야!", "machineㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ_name");
                            Log.d("몽키 D 루피 해적왕이 될꺼야!", "machineㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ_name");
                            Log.d("몽키 D 루피 해적왕이 될꺼야!", "machineㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗㅗ_name");

                            Detail_data.add(new main_DetailVO(machine_name, max_bottle, now_bottle));

                        }
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
        detail_queue.add(request);






//                StringRequest stringRequest = new StringRequest(Request.Method.GET, Detail_url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//
//                            Log.d("데이터 받음", jsonObject.getString("now_bottle"));
//                            String machine_name = jsonObject.getString("machine_name");
//                            String max_bottle = jsonObject.getString("max_bottle");
//                            String now_bottle = jsonObject.getString("now_bottle");
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.v("오류", "요청실패");
//                Toast.makeText(getApplicationContext(), "접속 실패", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });

//                detail_queue.add(stringRequest);
//            detail_queue.add(jsonobjectrequest);










        // 위치보기 == 여기에 API 기능 넣어줘야 함
                Check_loc_btn = findViewById(R.id.Check_loc_btn);




        Check_loc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_loc = new Intent(getApplicationContext(), Check_Loc_Activity.class);
                startActivity(intent_loc);
            }
        });


    }
}