package kr.or.iot3_ps_empty_bottle_bank;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import PSbankAdapter.my_eventcontent_Adapter;
import PSbankVO.my_eventcontentVO;

public class My_event_Activity extends AppCompatActivity {


    private ListView my_event_list_view_co;
    private PSbankAdapter.my_eventcontent_Adapter my_eventcontent_Adapter;
    private ArrayList<my_eventcontentVO> my_event_data;


    TextView my_event_name, my_event_point;

    private String[] event_my_day = {"2021.03.14", "2021.03.19", "2021.06.16", "2021.06.17", "2021.08.12"};
    private String[] event_my_content = {"1회차 대박로또이벤트 참여","1회차 대박로또이벤트 당첨","4회차 대박로또이벤트 참여","5회차 대박로또이벤트 참여","6회차 대박로또이벤트 참여"};
    private String[] event_my_point = {"-3000P", "+12000P", "-3000P","-3000P","-3000P"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_event);


        my_event_name = findViewById(R.id.my_event_name);
        my_event_point = findViewById(R.id.my_event_point);

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

                            my_event_name.setText(myinfo.getString("name"));
                            my_event_point.setText(myinfo.getString("point"));


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

        my_event_list_view_co =  findViewById(R.id.my_event_list_view_co);
        my_event_data = new ArrayList<>();
        for (int i = 0; i < event_my_day.length; i++) {
            my_event_data.add(new my_eventcontentVO(event_my_day[i],event_my_content[i],event_my_point[i]));
        }
        my_eventcontent_Adapter = new my_eventcontent_Adapter(getApplicationContext(), R.layout.my_event_content_view, my_event_data);
        my_event_list_view_co.setAdapter(my_eventcontent_Adapter);




    }
}