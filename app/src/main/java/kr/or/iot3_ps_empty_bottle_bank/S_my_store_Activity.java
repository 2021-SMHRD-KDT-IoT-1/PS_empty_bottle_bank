package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
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

import PSbankAdapter.main_list_Adapter;
import PSbankAdapter.s_my_stroe_Adapter;
import PSbankVO.fg_MyinfoVO;
import PSbankVO.main_ProductVO;
import PSbankVO.s_my_storeVO;

public class S_my_store_Activity extends AppCompatActivity {


    TextView S_my_store_day, S_my_store_content, S_my_point;

    private ListView S_my_stor;
    private PSbankAdapter.s_my_stroe_Adapter s_my_store_adapter;
    private ArrayList<s_my_storeVO> s_store_data;

    RequestQueue queue;

    private StringRequest request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smy_store);

        //=====여기는 스토어 사용내역 입니다.
        S_my_stor = findViewById(R.id.S_my_stor);

        // 초기화 하는곳
        queue = Volley.newRequestQueue(getApplicationContext());

        S_my_store_day = findViewById(R.id.S_my_store_day);
        S_my_store_content = findViewById(R.id.S_my_store_content);
        S_my_point = findViewById(R.id.S_my_point);

        // 접속한 사용자 ID가져오기
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id","");

        String S_my_store_url = "http://rspring41.iptime.org:3000/mystore/" + login_id;

         request = new StringRequest(Request.Method.GET, S_my_store_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                try {
                    JSONArray jsonArray = new JSONArray(response);

                    s_store_data = new ArrayList<>();

                    for (int i=0; i<jsonArray.length(); i++) {

                        JSONObject json_object = jsonArray.getJSONObject(i);

                        s_store_data.add(new s_my_storeVO(
                                json_object.getString("item_date"),
                                json_object.getString("item_name"),
                                json_object.getString("item_price")
                    ));

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                ListView S_my_stor = findViewById(R.id.S_my_stor);
                s_my_store_adapter = new s_my_stroe_Adapter(getApplicationContext(), R.layout.s_my_store_view, s_store_data);
                S_my_stor.setAdapter(s_my_store_adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Log.d("이거 오류얌", "고쳐줘~");
            }
        });


        queue.add(request);


    }


}





