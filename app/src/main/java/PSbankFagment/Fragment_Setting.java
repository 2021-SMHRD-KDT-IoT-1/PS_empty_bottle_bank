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

    Button set_btn_log,set_btn_notice;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        set_btn_log = view.findViewById(R.id.set_btn_log);


        set_btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Account_info.class);
                startActivity(intent);
            }
        });

        set_btn_notice = view.findViewById(R.id.set_btn_notice);

        set_btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Notice_Activity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}