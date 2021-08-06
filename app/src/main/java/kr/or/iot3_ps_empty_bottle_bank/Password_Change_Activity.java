package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Password_Change_Activity extends AppCompatActivity {

    TextView edt_change_pass,edt_change_pass_check;
    Button btn_change_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        edt_change_pass = findViewById(R.id.edt_change_pass);
        edt_change_pass_check = findViewById(R.id.edt_change_pass_check);
        btn_change_password = findViewById(R.id.btn_change_password);



        btn_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String change_pass = edt_change_pass.getText().toString();
                String change_pass_check = edt_change_pass_check.getText().toString();

                if (change_pass.equals(change_pass_check)){
                    Log.d("비밀번호 --->","일치");
                    Intent intent = new Intent(getApplicationContext(), User_Activity.class);
                    startActivity(intent);
                }else{
                    Log.d("비밀번호 --->","불일치");
                }
            }
        });





    }
}