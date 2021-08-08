package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import PSbankAdapter.bottle_king_Adapter;
import PSbankAdapter.event_list_Adapter;
import PSbankVO.bottle_kongVO;
import PSbankVO.event_ProductVO;
import PSbankVO.lotto_winVO;

public class Bottle_king_Activity extends AppCompatActivity {




    private ListView bottle_king_view;
    private PSbankAdapter.bottle_king_Adapter bottle_king_Adapter;
    private ArrayList<bottle_kongVO> bottle_king_data;


    // 큐 객체 생성
    RequestQueue queue;

    private StringRequest request;


    private int[] bottle_img_Array = {R.drawable.profile2, R.drawable.profile1, R.drawable.profile3, R.drawable.profile3, R.drawable.profile3};
//    private String[] bottle_round = {"1", "2", "3", "4", "5"};
//    private String[] bottle_id = {"홍진석", "콩진석", "콩콩진석", "콩콩콩진석", "콩콩콩콩진석"};
//    private String[] bottle_score = {"150ECO", "130ECO", "120ECO", "110ECO", "100ECO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_king);


        queue = Volley.newRequestQueue(getApplicationContext());


        String event_num =  getIntent().getStringExtra("event_num");



        // 여기가 접속 주소
        /*String bottleking_url = "http://222.102.104.159:8081/AndroidServer/Bottle_king_Activity";*/
        String bottleking_url = "http://rspring41.iptime.org:3000/bottleking";


        request = new StringRequest(Request.Method.GET, bottleking_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // 여기서 서버에서 받은 반환값 (response)를  JSONArray에 담에서 저장함
                        try {

                            JSONArray db_array = new JSONArray(response);

                            bottle_king_data = new ArrayList<>();
                            for (int i = 0; i < db_array.length(); i++) {
                                /*JSONObject db_object = (JSONObject) db_array.get(row);*/
                                JSONObject db_object = db_array.getJSONObject(i);
                                    bottle_king_data.add(new bottle_kongVO(

                                            bottle_img_Array[i],
                                            db_object.getString("rank"),
                                            db_object.getString("name"),
                                            db_object.getString("sum_count")

                                            ) );

                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        ListView bottle_list_king = findViewById(R.id.bottle_list_king);
                        bottle_king_Adapter = new bottle_king_Adapter(getApplicationContext(), R.layout.bottle_king_win, bottle_king_data);
                        bottle_list_king.setAdapter(bottle_king_Adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Bottle_king_Activity.this, "서버 오류", Toast.LENGTH_SHORT).show();
                    }
                }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                // 서버로 값을 보내줌
                params.put("event_num", event_num);

                return params;
            }
        };

        queue.add(request);



        /*bottle_king_Adapter = new bottle_king_Adapter(getApplicationContext(), R.layout.bottle_king_win, bottle_king_data);*/
        // 여기는 ViewList에 대한 ID를 찾고 위에서 계속 더해서 만든 array를 출력하는 부분
       /* ListView bottle_list_king = findViewById(R.id.bottle_list_king);*/
        /*bottle_list_king.setAdapter(bottle_king_Adapter);*/
        /*for(int i = 0; i<bottle_img_Array.length; i++) {
            bottle_king_data.add(new bottle_kongVO(bottle_img_Array[i], bottle_round[i], bottle_id[i], bottle_score[i]));
        }*/



    }
}