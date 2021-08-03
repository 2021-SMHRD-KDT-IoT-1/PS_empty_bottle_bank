package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.noticeVO;

public class Notice_1_Activity extends AppCompatActivity {

    TextView test_notice1 ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice1);

        test_notice1 = findViewById(R.id.test_notice1);



    }
}