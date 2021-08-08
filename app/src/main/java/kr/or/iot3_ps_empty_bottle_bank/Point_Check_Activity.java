package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

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
import java.util.Arrays;

import PSbankAdapter.Point_Ck_Adapter;
import PSbankVO.Point_ckVO;

public class Point_Check_Activity extends AppCompatActivity {

    TextView Point_Ck_day, Point_Ck_content,Point_Ck_point;

    private ListView Point_main_ck_list;
    private PSbankAdapter.Point_Ck_Adapter Point_Ck_Adapter;
    private ArrayList<Point_ckVO> Point_ck_data;

    RequestQueue Queue;


    private StringRequest request;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_check);


        Queue = Volley.newRequestQueue(getApplicationContext());




        // 접속한 사용자 ID가져오기
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id","");

        String S_my_point_url = "http://rspring41.iptime.org:3000/point/" + login_id;


        request = new StringRequest(Request.Method.GET, S_my_point_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("여기여기", response);

                try {
                    String state;
                    JSONArray jsonArray = new JSONArray(response);
                    Point_ck_data = new ArrayList<>();



                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("살려줘",String.valueOf(jsonArray));;


                        if(jsonObject.getString("point_where").equals("0")) {


                            Point_ck_data.add(new Point_ckVO(
                                    jsonObject.getString("point_date"),
                                    "병반납",
                                    jsonObject.getString("point_point")));

                        }else if (jsonObject.getString("print_where").equals("1")){


                            Point_ck_data.add(new Point_ckVO(
                                    jsonObject.getString("point_date"),
                                    "공병로또",
                                    jsonObject.getString("point_point")));

                        }else if (jsonObject.getString("point_where").equals("2")){


                            Point_ck_data.add(new Point_ckVO(
                                    jsonObject.getString("point_date"),
                                    "상품권 교환",
                                    jsonObject.getString("point_point")));



                        }



                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("살려줘","제발 나좀 사렬주세요12");
                ListView Point_main_ck_list = findViewById(R.id.Point_main_ck_list);
                Point_Ck_Adapter = new Point_Ck_Adapter(getApplicationContext(), R.layout.point_custom_list, Point_ck_data);
                Point_main_ck_list.setAdapter(Point_Ck_Adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("여기여기", "오류났쪙~");

            }
        });


        Queue.add(request);



    }
}