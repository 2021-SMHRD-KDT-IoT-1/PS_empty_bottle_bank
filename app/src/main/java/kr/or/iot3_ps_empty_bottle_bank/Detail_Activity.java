package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Detail_Activity extends AppCompatActivity {

    Button Detail_btn_back;
    Button Check_loc_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 뒤로가기
        Detail_btn_back = findViewById(R.id.Detail_btn_back);
        // 위치보기 == 여기에 API 기능 넣어줘야 함
        Check_loc_btn = findViewById(R.id.Check_loc_btn);


        Detail_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_main_back = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent_main_back);
            }
        });


        Check_loc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_loc = new Intent(getApplicationContext(), Check_Loc_Activity.class);
                startActivity(intent_loc);
            }
        });


    }
}