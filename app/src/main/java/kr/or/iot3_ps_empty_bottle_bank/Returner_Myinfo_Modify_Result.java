package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Returner_Myinfo_Modify_Result extends AppCompatActivity {

    Button returner_myinfo_result_btn_modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returner_myinfo_modify_result);

        returner_myinfo_result_btn_modify = findViewById(R.id.returner_myinfo_result_btn_modify);

        returner_myinfo_result_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Returner_Myinfo_Modify.class);
                startActivity(intent);
            }
        });


    }
}