package PSbankFagment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import kr.or.iot3_ps_empty_bottle_bank.Account_info;
import kr.or.iot3_ps_empty_bottle_bank.Notice_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class Fragment_Setting extends Fragment {

    Button set_btn_log;
    Button set_btn_notice;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup Setting_view = (ViewGroup)inflater.inflate(R.layout.fragment_setting, container, false);


        set_btn_log = Setting_view.findViewById(R.id.set_btn_log);
        set_btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), Account_info.class);
                startActivity(intent1);
            }
        });




        // ===여기 공지사항
        set_btn_notice = (Button)Setting_view.findViewById(R.id.set_btn_notice);
        set_btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),Notice_Activity.class);
                startActivity(intent2);
            }
        });

        return Setting_view;
    }

}