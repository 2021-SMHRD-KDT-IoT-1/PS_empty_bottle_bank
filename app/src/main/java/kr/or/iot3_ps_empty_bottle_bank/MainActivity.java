package kr.or.iot3_ps_empty_bottle_bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import PSbankFagment.Fragment_Event;
import PSbankFagment.Fragment_Guide;
import PSbankFagment.Fragment_Main;
import PSbankFagment.Fragment_Myinfo;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;
    Fragment_Main fragment_main;
    Fragment_Event fragment_event;
    Fragment_Guide fragment_guide;
    Fragment_Myinfo fragment_myinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        fragment_main = new Fragment_Main();
        fragment_event = new Fragment_Event();
        fragment_guide = new Fragment_Guide();
        fragment_myinfo = new Fragment_Myinfo();


        //프래그먼트매니저를 이용하여 FrameLayout에 Fragment화면을 설정
        //replace(부모레이아웃, 화면에 출력할 프래그먼트객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment_main).commit();

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.item_main){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment_main).commit();
                }else if (itemId == R.id.item_event){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment_event).commit();
                }else if (itemId == R.id.item_guide){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment_guide).commit();
                }else if (itemId == R.id.item_myinfo){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment_myinfo).commit();
                }

                //true : 클릭한 메뉴아이템에 포커싱
                return true;
            }
        });

    }
}