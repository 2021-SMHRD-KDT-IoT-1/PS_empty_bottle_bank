package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {



    EditText Login_edt_ID, Login_edt_PW;
    Button Login_btn_login, Login_btn_join;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    // 초기화 작업 진행 했습니다.
    Login_edt_ID = findViewById(R.id.Login_edt_ID);
    Login_edt_PW = findViewById(R.id.Login_edt_PW);
    Login_btn_login = findViewById(R.id.Login_btn_login);
    Login_btn_join = findViewById(R.id.Login_btn_join);

    //우선 간단하게 회원가입 페이지로 넘어가기만 하게 만들어놨어요
        // 회원가입 페이지 레이아웃은 안만들어 놨구 흰 화면 만 뜨는데 정상인겁니다!
        Login_btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Join_Activity2.class);
                startActivity(intent);
                // 액티비티 화면 전환 할 일 있을때 Intent객채 활용하여 액티비티 화면 전환해 주세요~ 정현이형띠!
            }
        });


        Login_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });


    }
}