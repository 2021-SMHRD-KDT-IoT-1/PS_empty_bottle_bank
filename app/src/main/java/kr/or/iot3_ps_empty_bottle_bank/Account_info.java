package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account_info extends AppCompatActivity {

    Button account_info_btn_logout, account_info_btn_pass_change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        account_info_btn_logout = findViewById(R.id.account_info_btn_logout);

        account_info_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_Activity.class);
                startActivity(intent);
            }
        });

        account_info_btn_pass_change = findViewById(R.id.account_info_btn_pass_change);

        account_info_btn_pass_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Password_Change_Activity.class);
                startActivity(intent);
            }
        });

    }
}