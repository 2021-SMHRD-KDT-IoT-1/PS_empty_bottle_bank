package kr.or.smhrd.test_0726;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    EditText edt_id, edt_pw;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();

                if (id.equals("pbk")&& pw.equals("1234")) {

                    //getApplicationContext(): 어플리케이션의 정보를 Context로 반환
                    Intent intent = new Intent(getApplicationContext(), Question3_result.class);
                    //intent에 정보를 저장
                    intent.putExtra("id_data",edt_id.getText().toString());
                    startActivity(intent);
                }else {
                    Context context = getApplicationContext();
                    CharSequence text = "ID와 PW가 일치하지 않습니다";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }
}