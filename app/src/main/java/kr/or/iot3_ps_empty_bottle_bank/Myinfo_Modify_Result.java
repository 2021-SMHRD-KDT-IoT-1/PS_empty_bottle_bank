package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Myinfo_Modify_Result extends AppCompatActivity {

    Button myinfo_result_btn_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_modify_result);

        myinfo_result_btn_modify = findViewById(R.id.myinfo_result_btn_modify);

        myinfo_result_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Myinfo_Modify.class);
                startActivity(intent);
            }
        });


    }
}