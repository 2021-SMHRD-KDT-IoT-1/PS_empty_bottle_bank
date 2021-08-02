package PSbankFagment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import kr.or.iot3_ps_empty_bottle_bank.My_event_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Myinfo_Modify_Result;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class Fragment_Myinfo extends Fragment {

    // ====이벤트 참여내역 버튼
    Button s_myinfo_btn_event;
    // ====스토어 구매내역 버튼
    Button s_myinfo_btn_store;
    // ====적립내역 및 사용 내역 버튼
    Button s_myinfo_btn_total;


    // ====여기는 수정하기 버튼
    Button s_myinfo_btn_edt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_myinfo,container,false);


        //=====여기는 내정보 수정하기로 넘어가는 이벤트
        s_myinfo_btn_edt = (Button)rootview.findViewById(R.id.s_myinfo_btn_edt);
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


        return rootview;
    }
}