package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Detail_Activity extends AppCompatActivity {


    TextView Detail_bottle_set_num, Detail_bottle_now_num, machine_name_tlt;
    Button Check_loc_btn;

    RequestQueue detail_queue;

    private String machine_name;
    private String max_bottle;
    private String now_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String machine_num = getIntent().getStringExtra("machine_num");

        //회수기 이름
        machine_name_tlt = findViewById(R.id.machine_name_tlt);
        //회수기 투입가능 갯수
        Detail_bottle_set_num = findViewById(R.id.Detail_bottle_set_num);
        //회수기 현재
        Detail_bottle_now_num = findViewById(R.id.Detail_bottle_now_num);
        detail_queue = Volley.newRequestQueue(getApplicationContext());

        String Detail_url = "http://psbottle94.iptime.org:3000/machine/1";

        StringRequest request = new StringRequest(Request.Method.POST, Detail_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray array = new JSONArray(response);

                    for(int i = 0; i<array.length(); i++ ){
                        JSONObject  machine = (JSONObject)array.get(i);


                        machine_name = machine.getString("machine_name");
                        max_bottle = machine.getString("max_bottle");
                        now_bottle = machine.getString("now_bottle");

                    }


                } catch (JSONException e) {
                    e.printStackTrace();

                    machine_name_tlt.setText(machine_name);
                    Detail_bottle_set_num.setText(max_bottle);
                    Detail_bottle_now_num.setText(now_bottle);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("오류", "요청실패");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();



                return params;
            }
        };
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