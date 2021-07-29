package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class Join_Activity2 extends AppCompatActivity {

// 어댑터 선언(loc_name: 서울, 부산 .. 등등 loc_plus_name : 강서구,강남구 .. 등

    ArrayAdapter<CharSequence> loc_name, loc_plus_name;
    String choice_do = "";
    String choice_se = "";
    // 검색시 선택된 메세지를 뜨위기 위하여 선언 하였음

    Button join_btn, join_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        // 접근 및 초기화
        final Spinner loc_name = (Spinner)findViewById(R.id.spinner_loc_data);
        final Spinner loc_plus_name = (Spinner)findViewById(R.id.spinner_loc_plus_data);
       // Button join_btn_refresh = (Button)findViewById(R.id.join_btn_refresh);

        ArrayAdapter spinner_loc_Adapter = ArrayAdapter.createFromResource(this, R.array.loc_name,
                android.R.layout.simple_spinner_dropdown_item);
        // 첫번째 어댑터에 값을 넣으며 this는 현재 class를 으며  R.array.loc_name는
        // 이곳에 도시를 다 쓸 경우 코딩이 길어지기 때문에 value->loc_arrays.xml에 따로 String값들을 선언해두었습니다

        spinner_loc_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // loc_name 에 spinn_loc_Adapter이라는 어댑터 값을 넣어줌
        loc_name.setAdapter(spinner_loc_Adapter);

        // spinner에 값을 가져와서 클릭 이벤트를 줌 ===================서울 ========================
        loc_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // spinner_loc_adapter을 겟 아이템을 하여 포지션으로 위치를 확인 후 이퀄스를 활용하여 서울이 몇번째에 있는지 확인
                if (spinner_loc_Adapter.getItem(position).equals("서울")){
                    //  출력을 위해 값을 넣음
                    choice_do = "서울";

                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name1, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);

                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            // 아무것도 선택안될 시 부분
                        }
                    });
                    //===================부산====================
                } else if (spinner_loc_Adapter.getItem(position).equals("부산")) {
                    choice_do = "부산";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name2, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);

                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if(spinner_loc_Adapter.getItem(position).equals("대구")) {
                    choice_do = "대구";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name3, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);

                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (spinner_loc_Adapter.getItem(position).equals("인천")) {
                    choice_do = "인천";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name4, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (spinner_loc_Adapter.getItem(position).equals("광주")) {
                    choice_do = "광주";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name5, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if(spinner_loc_Adapter.getItem(position).equals("대전")) {
                    choice_do = "대전";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name6, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if(spinner_loc_Adapter.getItem(position).equals("울산")) {
                    choice_do = "울산";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name7, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if(spinner_loc_Adapter.getItem(position).equals("강원")) {
                    choice_do = "강원";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name8, android.R.layout.simple_spinner_dropdown_item);

                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if(spinner_loc_Adapter.getItem(position).equals("경기")) {
                    choice_do = "경기";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name9, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if(spinner_loc_Adapter.getItem(position).equals("경남")) {
                    choice_do = "경남";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name10, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }else if(spinner_loc_Adapter.getItem(position).equals("경북")) {
                    choice_do ="경북";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name11, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                } else if (spinner_loc_Adapter.getItem(position).equals("전남")) {
                    choice_do ="전남";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name12, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if (spinner_loc_Adapter.getItem(position).equals("전북")) {
                    choice_do ="전북";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name13, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if(spinner_loc_Adapter.getItem(position).equals("제주")) {
                    choice_do ="제주";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name14, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if(spinner_loc_Adapter.getItem(position).equals("충남")) {
                    choice_do ="충남";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name15, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else if(spinner_loc_Adapter.getItem(position).equals("충북")) {
                    choice_do ="충북";
                    ArrayAdapter spinner_loc_plus_Adapter = ArrayAdapter.createFromResource(Join_Activity2.this,
                            R.array.loc_plus_name16, android.R.layout.simple_spinner_dropdown_item);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    spinner_loc_plus_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    loc_plus_name.setAdapter(spinner_loc_plus_Adapter);
                    loc_plus_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            choice_se = spinner_loc_plus_Adapter.getItem(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 회원가입 버튼 및 취소버튼 초기화
        join_btn = findViewById(R.id.join_btn);
        join_back = findViewById(R.id.join_back);

        // 회원가입 후 로그인 페이지로 전환
        join_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login_Activity.class);
                startActivity(intent);
            }
        });

        // 취소 버튼 누르면 로그인 페이지로 저환
        join_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
            }
        });










    }
}