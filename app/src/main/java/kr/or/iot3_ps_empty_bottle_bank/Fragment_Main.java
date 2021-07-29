package kr.or.iot3_ps_empty_bottle_bank;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Fragment_Main extends Fragment {

    TextView gongji;
    ImageView advertisement_img,koosi_img, sangmoo_img, dongmyeong_img;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {







        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        //view객체를 통해서 fragment_1.xml에 배치된 View객체들의 정보를 접근할 수 있다!
        gongji =  view.findViewById(R.id.gongji);
        advertisement_img = view.findViewById(R.id.advertisement_img);



        //fg1_tv_data.setText("첫 번째 프래그먼트 화면");


        return view;
    }
}