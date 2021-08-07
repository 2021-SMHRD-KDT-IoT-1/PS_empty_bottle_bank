package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import PSbankAdapter.notice_Adapter;
import PSbankVO.noticeVO;

public class Notice_Activity extends AppCompatActivity {



    private ListView notice_listview;
    private PSbankAdapter.notice_Adapter notice_Adapter;
    private ArrayList<noticeVO> notice_data;

    RequestQueue queue;

    private StringRequest request;

    private String[] notice_title = {"긴급공지","슬리퍼","케이스","인형","피규어","안마봉",
            "마우스패드","노트","필통","파우치","티셔츠"};

    private String[] notice_content = {"긴급공지 서버 과부하로 인한 서버점검","슬리퍼가 다 떨어졌습니다.","케이스가 다 떨어졌습니다","인형이 다 떨어졌습니다","피규어가 다 떨어졌습니다","안마봉이 다 떨어졌습니다",
            "마우스패드가 다 떨어졌습니다","노트가 다 떨어졌습니다","필통이 다 떨어졌습니다","파우치가 다 떨어졌습니다","티셔츠가 다 떨어졌습니다"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        queue = Volley.newRequestQueue(getApplicationContext());

       /* String notice_url = "http://rspring41.iptime.org:3000/notice";*/
        String notice_url = "http://222.102.104.159:8081/AndroidServer/Notice_Activity";


        request = new StringRequest(Request.Method.POST, notice_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray notice_array = new JSONArray(response);

                            notice_data = new ArrayList<>();
                            for (int i = 0; i < notice_array.length(); i++) {
                                /*JSONObject db_object = (JSONObject) db_array.get(row);*/
                                JSONObject db_object = notice_array.getJSONObject(i);
                                notice_data.add(new noticeVO(

                                        db_object.getString("notice_num"),
                                        db_object.getString("notice_title"),
                                        db_object.getString("notice_content")

                                ) );

                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        ListView notice_listview = findViewById(R.id.notice_listview);
                        notice_Adapter = new notice_Adapter(getApplicationContext(), R.layout.notice_list_view, notice_data);
                        notice_listview.setAdapter(notice_Adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Notice_Activity.this, "서버 오류", Toast.LENGTH_SHORT).show();
                    }
                }

        );

        queue.add(request);










//        notice_listview = findViewById(R.id.notice_listview);
//        notice_data = new ArrayList<>();
//
//        for(int i =0; i<notice_title.length; i++){
//            notice_data.add(new noticeVO(notice_title[i],notice_content[i]));
//        }
//        notice_Adapter = new notice_Adapter(getApplicationContext(), R.layout.notice_list_view, notice_data);
//
//        notice_listview.setAdapter(notice_Adapter);



    }
}