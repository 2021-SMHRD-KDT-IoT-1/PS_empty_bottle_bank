package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import PSbankAdapter.s_my_stroe_Adapter;
import PSbankVO.s_my_storeVO;

public class S_my_store_Activity extends AppCompatActivity {


    private ListView S_my_stor;
    private PSbankAdapter.s_my_stroe_Adapter s_my_store_adapter;
    private ArrayList<s_my_storeVO> s_store_data;

    private String[] s_my_store_day ={"2021.02.20","2021.02.20","2021.02.20","2021.02.20","2021.02.20"};
    private String[] s_my_store_content = {"쓰레기봉투 구입","음식물스티커 구입","쓰레기봉투 구입","쓰레기봉투 구입","쓰레기봉투 구입"};
    private String[] s_my_point = {"-1700","-1200","-1700","-1700","-1700"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smy_store);


        //=====여기는 스토어 사용내역 입니다.
        S_my_stor = findViewById(R.id.S_my_stor);

        s_store_data = new ArrayList<>();
        for (int i = 0; i<s_my_store_day.length; i++) {
            s_store_data.add(new s_my_storeVO(s_my_store_day[i],s_my_store_content[i],s_my_point[i] ));
        }

        s_my_store_adapter = new s_my_stroe_Adapter(getApplicationContext(), R.layout.s_my_store_view, s_store_data);
        S_my_stor.setAdapter(s_my_store_adapter);

    }
}