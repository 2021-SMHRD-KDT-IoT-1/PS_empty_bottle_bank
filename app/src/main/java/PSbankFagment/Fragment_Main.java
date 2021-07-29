package PSbankFagment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankAdapter.main_list_Adapter;
import PSbankVO.main_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.Main_QR_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class Fragment_Main extends Fragment {

    TextView gongji;
    ImageView advertisement_img, main_list_img;
    Button btn_main_qr;



    //====== 여긴 메인리스트 뷰
    private ListView main_list;
    //====== 메인리스트 뷰에 들어갈 메인 어뎁터
    private main_list_Adapter main_adapter;
    //===== 메인 리스트뷰에 들어갈 데이터
    private ArrayList<main_ProductVO> main_list_data;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);





        //view객체를 통해서 fragment_1.xml에 배치된 View객체들의 정보를 접근할 수 있다!
        gongji =  view.findViewById(R.id.gongji);
        advertisement_img = view.findViewById(R.id.advertisement_img);
        btn_main_qr = view.findViewById(R.id.btn_main_qr);

        //fg1_tv_data.setText("첫 번째 프래그먼트 화면");
// ================ 여기는 큐알코드 화면으로 넘어가는 곳 ============
        btn_main_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main_QR_Activity.class);
                startActivity(intent);
            }
        });


        ///=======================여기는 main_list_view ==========


        main_list = view.findViewById(R.id.main_list);
        main_list_data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            main_list_data.add(new main_ProductVO(R.drawable.ic_launcher_background, "상무지구 무인회수기",
                    "상무지구", "회수상태 OK", "소주병 맥주병 전용",
                    "환급금 : 소주병100원, 맥주뱡 130"));

        }


        main_adapter = new main_list_Adapter(getActivity(), R.layout.main_list_view, main_list_data);


        main_list.setAdapter(main_adapter);
        return view;
    }
}