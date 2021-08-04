package PSbankFagment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
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
import kr.or.iot3_ps_empty_bottle_bank.QR_main_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class Fragment_Main extends Fragment {

    TextView gongji;
    ImageView advertisement_img, main_list_img;
    Button btn_main_qr;
    int page = 0;




    //====== 여긴 메인리스트 뷰
    private ListView main_list;
    //====== 메인리스트 뷰에 들어갈 메인 어뎁터
    private main_list_Adapter main_adapter;
    //===== 메인 리스트뷰에 들어갈 데이터
    private ArrayList<main_ProductVO> main_list_data;


 // ===== 여기는 메인 페이지
    private int[] main_imgview = {R.drawable.item1, R.drawable.item2, R.drawable.item3};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //view객체를 통해서 fragment_1.xml에 배치된 View객체들의 정보를 접근할 수 있다!
        gongji =  view.findViewById(R.id.gongji);
        advertisement_img = view.findViewById(R.id.advertisement_img);
        btn_main_qr = view.findViewById(R.id.btn_main_qr);


        //=============여기는 메인 페이지 광고 노출 공간
            main_Thread thread = new main_Thread();
            thread.start();




        //fg1_tv_data.setText("첫 번째 프래그먼트 화면");
// ================ 여기는 큐알코드 화면으로 넘어가는 곳 ============
        btn_main_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QR_main_Activity.class);
                startActivity(intent);
            }
        });


        ///=======================여기는 main_list_view ==========


        main_list = view.findViewById(R.id.main_list);
        main_list_data = new ArrayList<>();
        for (int i = 0; i < main_imgview.length; i++) {
            main_list_data.add(new main_ProductVO(main_imgview[i], "상무지구 무인회수기",
                    "상무지구", "회수상태 OK", "소주병 맥주병 전용",
                    "환급금 : 소주병100원, 맥주뱡 130"));

        }


        main_adapter = new main_list_Adapter(getActivity(), R.layout.main_list_view, main_list_data);


        main_list.setAdapter(main_adapter);
        return view;
    }


// 메인페이지 광고 출력할 핸들러
Handler main_handler = new Handler() {
    @Override
    public void handleMessage(@NonNull Message msg) {

        // 스레드에서 전달받은 값을 이용해서 이미지뷰를 초기화
        int ppl_img = msg.arg2;
        String ppl_status = (String)msg.obj;

        advertisement_img.setImageResource(ppl_img);
        advertisement_img.setTag(ppl_status);

        super.handleMessage(msg);
    }
};

class main_Thread extends Thread{
    int ppl_num; // 두더지 번호

    private main_Thread() {}

    @Override
    public void run() {

        while (true) {
            int ppltime1 = 3000;
            int ppltime2 = 3000;
            int ppltime3 = 3000;
            int ppltime4 = 3000;

            try {
                Thread.sleep(ppltime1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message msg = new Message();
            msg.arg2 = R.drawable.sojo;
            msg.obj = "ppl1";

            main_handler.sendMessage(msg);


            try {
                Thread.sleep(ppltime2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg = new Message();
            msg.arg2 = R.drawable.apeach;
            msg.obj = "ppl2";

            main_handler.sendMessage(msg);

            try {
                Thread.sleep(ppltime3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg = new Message();
            msg.arg2 = R.drawable.item1;
            msg.obj = "ppl3";

            main_handler.sendMessage(msg);

            try {
                Thread.sleep(ppltime4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            msg = new Message();
            msg.arg2 = R.drawable.item2;
            msg.obj = "ppl4";

            main_handler.sendMessage(msg);

        }



    }
}}