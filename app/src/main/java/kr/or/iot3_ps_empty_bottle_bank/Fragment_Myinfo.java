package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class Fragment_Myinfo extends Fragment {

    Button s_myinfo_btn_edt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_myinfo,container,false);

        s_myinfo_btn_edt = (Button)rootview.findViewById(R.id.s_myinfo_btn_edt);
        s_myinfo_btn_edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Myinfo_Modify_Result.class);
                startActivity(intent);
            }
        });

        return rootview;
    }
}