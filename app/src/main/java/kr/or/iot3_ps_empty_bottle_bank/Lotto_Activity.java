package kr.or.iot3_ps_empty_bottle_bank;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import java.util.List;
import java.util.Map;

import PSbankAdapter.bottle_king_Adapter;
import PSbankAdapter.lotto_win_Adapter;
import PSbankFagment.Fragment_Event;
import PSbankFagment.Fragment_Main;
import PSbankVO.bottle_kongVO;
import PSbankVO.lotto_winVO;

public class Lotto_Activity extends AppCompatActivity {


    private ListView lotto_main_list_view;
    private PSbankAdapter.lotto_win_Adapter lotto_win_Adapter;
    private ArrayList<lotto_winVO> lotto_data;

    RequestQueue queue;

    private StringRequest request;

    private String[] lotto_round = {"1회차", "2회차", "3회차" ,"4회차","5회차"};
    private String[] lotto_win_1 = { "1등 : 홍진석 1억원","1등 : 채평성 1억원","1등 : 최정현 1억원","1등 : 기나해 1억원","1등 : 임성미 1억원"};
    private String[] lotto_win_2 = { "2등 : 황혜서 3천만원","2등 : 짱구 3천만원","2등 : 도라에몽 3천만원","2등 : 오이 3천만원","2등 : 민트초코 3천만원"};
    private String[] lotto_win_3 = { "3등 : 아맛나 400만원", "3등 : 보석바 400만원", "3등 : 슬리퍼 400만원", "3등 : 카카오 400만원", "3등 : 롤리폴리 400만원"};

    Button lotto_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto);

        queue = Volley.newRequestQueue(getApplicationContext());

        String Lotto_url = "http://222.102.104.159:8081/AndroidServer/Lotto_Activity";

        request = new StringRequest(Request.Method.POST, Lotto_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray lottoarray = new JSONArray(response);

                            lotto_data = new ArrayList<>();
                            for (int i = 0; i < lottoarray.length(); i++) {
                                /*JSONObject db_object = (JSONObject) db_array.get(row);*/
                                JSONObject db_object = lottoarray.getJSONObject(i);
                                lotto_data.add(new lotto_winVO(

                                        db_object.getString("lotto_round"),
                                        db_object.getString("lotto_1st"),
                                        db_object.getString("lotto_2nd"),
                                        db_object.getString("lotto_3rd")

                                ) );

                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                        ListView lotto_main_list_view = findViewById(R.id.lotto_main_list_view);
                        lotto_win_Adapter = new lotto_win_Adapter(getApplicationContext(), R.layout.lotto_winner, lotto_data);
                        lotto_main_list_view.setAdapter(lotto_win_Adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Lotto_Activity.this, "서버 오류", Toast.LENGTH_SHORT).show();
                    }
                }

        );

                queue.add(request);





        // ============로또 리스트 뷰 =================
//        ListView lotto_main_list_view = findViewById(R.id.lotto_main_list_view);
//        lotto_data = new ArrayList<>();
//        for(int i = 0; i<lotto_round.length; i++) {
//            lotto_data.add(new lotto_winVO(lotto_round[i], lotto_win_1[i], lotto_win_2[i], lotto_win_3[i]));
//        }
//        lotto_win_Adapter = new lotto_win_Adapter(getApplicationContext(), R.layout.lotto_winner, lotto_data);
//        lotto_main_list_view.setAdapter(lotto_win_Adapter);
    }
}