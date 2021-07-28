package kr.or.iot3_ps_empty_bottle_bank;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class consent_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consent);

        //전체동의
        CheckBox checkBox=findViewById(R.id.checkbox1);
//필수 서비스이용약관
        CheckBox checkBox2=findViewById(R.id.checkbox2);
//필수 개인정보
        CheckBox checkBox3=findViewById(R.id.checkbox3);
//선택 위치정보
        CheckBox checkBox4=findViewById(R.id.checkbox4);

//전체동의 클릭시
//전체 true / 전체 false 로 변경
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                }else {
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);
                }
            }
        });
//2 클릭시

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약 전체 클릭이 true 라면 false로 변경
                if(checkBox.isChecked()){
                    checkBox.setChecked(false);
                    //각 체크박스 체크 여부 확인해서  전체동의 체크박스 변경
                }else if(checkBox2.isChecked()&&checkBox3.isChecked()&&checkBox4.isChecked()){
                    checkBox.setChecked(true);
                }
            }
        });
//3 클릭시

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    checkBox.setChecked(false);
                }else if(checkBox2.isChecked()&&checkBox3.isChecked()&&checkBox4.isChecked()){
                    checkBox.setChecked(true);
                }
            }
        });

//4클릭시

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    checkBox.setChecked(false);
                }else if(checkBox2.isChecked()&&checkBox3.isChecked()&&checkBox4.isChecked()){
                    checkBox.setChecked(true);
                }
            }
        });


        //이용약관 버튼 - 서비스
        Button btn_agr = findViewById(R.id.btn_agr);
        btn_agr.setText(R.string.underlined_text);
        btn_agr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                //다이얼로그 창의 제목 입력
                builder.setTitle("서비스 이용약관 ");
                //다이얼로그 창의 내용 입력
                builder.setMessage(R.string.app_arg); //이용약관 내용 추가  ,예시는 res-values-string 에 추가해서 사용
                //다이얼로그창에 취소 버튼 추가
                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println( "이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });

//이용약관 버튼2 - 위치정보
        Button btn_agr2 = findViewById(R.id.btn_agr2);
        btn_agr2.setText(R.string.underlined_text1);
        btn_agr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                //다이얼로그 창의 제목 입력
                builder.setTitle("위치 정보 이용 약관 ");
                //다이얼로그 창의 내용 입력
                builder.setMessage(R.string.app_arg2); //이용약관 내용 추가 , 예시는 res-values-string 에 추가해서 사용
                //다이얼로그창에 취소 버튼 추가
                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println( "이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });

//이용약관 버튼3 - 개인정보
        Button btn_agr3 = findViewById(R.id.btn_agr3);
        btn_agr3.setText(R.string.underlined_text1);
        btn_agr3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                //다이얼로그 창의 제목 입력
                builder.setTitle("개인정보처리방침 ");
                //다이얼로그 창의 내용 입력
                builder.setMessage(R.string.app_arg3); //이용약관 내용 추가 , 예시는 res-values-string 에 추가해서 사용
                //다이얼로그창에 취소 버튼 추가
                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });





    }
}

