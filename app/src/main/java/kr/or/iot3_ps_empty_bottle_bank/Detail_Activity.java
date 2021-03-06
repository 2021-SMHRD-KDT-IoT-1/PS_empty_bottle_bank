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
    TextView Detail_bottle_set_num, Detail_bottle_now_num, machine_name_tlt, Detail_broken;
    Button Check_loc_btn;
    RequestQueue detail_queue;
    private ArrayList<main_DetailVO> Detail_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String machine_num = getIntent().getStringExtra("machine_num");

        Detail_img = findViewById(R.id.Detail_img);
        //회수기 이름
        machine_name_tlt = findViewById(R.id.machine_name_tlt);
        //회수기 투입가능 갯수
        Detail_bottle_set_num = findViewById(R.id.Detail_bottle_set_num);
        //회수기 현재
        Detail_bottle_now_num = findViewById(R.id.Detail_bottle_now_num);
        //고장여부
        Detail_broken = findViewById(R.id.Detail_broken);


        detail_queue = Volley.newRequestQueue(getApplicationContext());

        Detail_img.setImageResource(R.drawable.machine);

        String Detail_url = "http://rspring41.iptime.org:3000/machine/" + machine_num;


        StringRequest request = new StringRequest(Request.Method.GET, Detail_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject machine_info = new JSONObject(response);

                            String broken;
                            if(machine_info.getString("broken").equals("0")){
                                broken = "정상";
                            }else{
                                broken = "고장";
                            }


                            machine_name_tlt.setText(machine_info.getString("machine_name"));
                            Detail_bottle_set_num.setText(machine_info.getString("storable_bottle"));
                            Detail_bottle_now_num.setText(machine_info.getString("now_bottle"));
                            Detail_broken.setText(broken);


                            //                            for (int i = 0; i < machine_infos.length(); i++) {
//                                JSONObject machine_info = machine_infos.getJSONObject(i);
//
//                                machine_name_tlt.setText(machine_info.getString("machine_name"));
//                                Detail_bottle_set_num.setText(machine_info.getString("max_bottle"));
//                                Detail_bottle_now_num.setText(machine_info.getString("now_bottle"));
//
//                            }


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