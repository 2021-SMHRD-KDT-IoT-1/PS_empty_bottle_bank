package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import PSbankAdapter.notice_Adapter;
import PSbankVO.noticeVO;

public class Notice_Activity extends AppCompatActivity {

    Button btn_edt_notice;

    private ListView notice_listview;
    private PSbankAdapter.notice_Adapter notice_Adapter;
    private ArrayList<noticeVO> notice_data;

    private String[] notice_title = {"긴급공지","슬리퍼","케이스","인형","피규어","안마봉",
            "마우스패드","노트","필통","파우치","티셔츠"};

    private String[] notice_content = {"긴급공지 서버 과부하로 인한 서버점검","슬리퍼가 다 떨어졌습니다.","케이스가 다 떨어졌습니다","인형이 다 떨어졌습니다","피규어가 다 떨어졌습니다","안마봉이 다 떨어졌습니다",
            "마우스패드가 다 떨어졌습니다","노트가 다 떨어졌습니다","필통이 다 떨어졌습니다","파우치가 다 떨어졌습니다","티셔츠가 다 떨어졌습니다"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        btn_edt_notice = findViewById(R.id.btn_edt_notice);

        btn_edt_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Edt_Notice_Activity.class);
                startActivity(intent);
            }
        });


        notice_listview = findViewById(R.id.notice_listview);
        notice_data = new ArrayList<>();

        for(int i =0; i<notice_title.length; i++){
            notice_data.add(new noticeVO(notice_title[i],notice_content[i]));
        }
        notice_Adapter = new notice_Adapter(getApplicationContext(), R.layout.notice_list_view, notice_data);

        notice_listview.setAdapter(notice_Adapter);



    }
}