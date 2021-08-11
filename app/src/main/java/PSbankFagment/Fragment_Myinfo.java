package PSbankFagment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

import PSbankVO.fg_MyinfoVO;
import PSbankVO.main_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.My_event_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Myinfo_Modify_Result;
import kr.or.iot3_ps_empty_bottle_bank.Point_Check_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;
import kr.or.iot3_ps_empty_bottle_bank.S_my_store_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Store_Activity;


public class Fragment_Myinfo extends Fragment {

    TextView s_myinfo_name, s_myinfo_current_money_view, s_myinfo_ranking_view, user_state, s_myinfo_adr;
    ImageView s_myinfo_img;


    // ====이벤트 참여내역 버튼
    Button s_myinfo_btn_event;
    // ====스토어 구매내역 버튼
    Button s_myinfo_btn_store;
    // ====적립내역 및 사용 내역 버튼
    Button s_myinfo_btn_total;
    // ====스토어 버튼
    Button s_myinfo_btn_buy_store;

    // ====여기는 수정하기 버튼
    Button s_myinfo_btn_edt;

    // 새로고침 버튼
    Button btn_reset;


    //=====큐 생성
    RequestQueue queue;


    private ArrayList<fg_MyinfoVO> my_info_data;
    private FragmentManager fragmentManager;
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_myinfo, container, false);

        //초기화
        user_state = rootview.findViewById(R.id.user_state);
        s_myinfo_name = rootview.findViewById(R.id.s_myinfo_name);
        s_myinfo_current_money_view = rootview.findViewById(R.id.s_myinfo_current_money_view);
        s_myinfo_ranking_view = rootview.findViewById(R.id.s_myinfo_ranking_view);
        btn_reset = rootview.findViewById(R.id.btn_reset);
        s_myinfo_img = rootview.findViewById(R.id.s_myinfo_img);
        s_myinfo_adr = rootview.findViewById(R.id.s_myinfo_adr);

        queue = Volley.newRequestQueue(requireActivity().getApplicationContext());




        // 초반에 정보 가져오고 갱신 버튼 누르면 갱신됨
        refresh_info();
        // 갱신 버튼
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                refresh_info();
            }
        });


        //=====여기는 내정보 수정하기로 넘어가는 이벤트
        s_myinfo_btn_edt = (Button) rootview.findViewById(R.id.s_myinfo_btn_edt);
        s_myinfo_btn_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Myinfo_Modify_Result.class);
                startActivity(intent);
            }
        });

        // =====여기는 이벤트 참여내역으로 넘어가는 이벤트
        s_myinfo_btn_event = rootview.findViewById(R.id.s_myinfo_btn_event);
        s_myinfo_btn_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_event_Activity.class);
                startActivity(intent);
            }
        });


        // ===== 여기는 스토어 구매내역으로 넘어가는 이벤트
        s_myinfo_btn_store = (Button) rootview.findViewById(R.id.s_myinfo_btn_store);
        s_myinfo_btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), S_my_store_Activity.class);
                startActivity(intent);
            }
        });


        // ==== 공병 적립 내역 리스트 뷰
        s_myinfo_btn_total = rootview.findViewById(R.id.s_myinfo_btn_total);
        s_myinfo_btn_total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Point_Check_Activity.class);
                startActivity(intent);
            }
        });

        // ==== 여기는 상점으로 가는 버튼
        s_myinfo_btn_buy_store = (Button) rootview.findViewById(R.id.s_myinfo_btn_buy_store);
        s_myinfo_btn_buy_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Store_Activity.class);
                startActivity(intent);



            }
        });
        return rootview;
    }


    // DB 연동해서 사용자 정보를 가져옴
    public void refresh_info() {
        // 접속한 사용자 ID가져오기===================================================
        SharedPreferences sf = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");

        String My_info_url = "http://rspring41.iptime.org:3000/myinfo/" + login_id;

//        if(login_id.equals("hong")){
//            s_myinfo_img.setImageResource(R.drawable.profile2);
//        }else if(login_id.equals("ps")){
//            s_myinfo_img.setImageResource(R.drawable.profile1);
//        }else if(login_id.equals("choi")){
//            s_myinfo_img.setImageResource(R.drawable.profile3);
//        }

        StringRequest request = new StringRequest(Request.Method.GET, My_info_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {


                    JSONArray jsonArray = new JSONArray(response);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        Log.d("여기여기!!", response);
                        JSONObject json_object = jsonArray.getJSONObject(i);

                        String state;
                        if (json_object.getString("user_state").equals("0")) {
                            state = "회원";
                        } else {
                            state = "정지회원";
                        }

                        user_state.setText(state);
                        s_myinfo_name.setText(json_object.getString("name"));
                        s_myinfo_current_money_view.setText(json_object.getString("point"));
                        s_myinfo_ranking_view.setText(json_object.getString("rank"));
                        s_myinfo_adr.setText("광주 ㅣ " + json_object.getString("tel"));
                        if(login_id.equals("hong")){
                            s_myinfo_img.setImageResource(R.drawable.profile2);
                        }else if(login_id.equals("ps")){
                            s_myinfo_img.setImageResource(R.drawable.profile1);
                        }else if(login_id.equals("choi")){
                            s_myinfo_img.setImageResource(R.drawable.profile3);
                        }

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "으악 !! 살려도!!!!!", Toast.LENGTH_SHORT).show();
                Log.d("이거 오류얌", "고쳐줘~");
            }
        });
        queue.add(request);
    }

}
