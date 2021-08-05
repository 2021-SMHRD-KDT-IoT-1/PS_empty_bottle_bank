package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

import PSbankAdapter.bottle_king_Adapter;
import PSbankAdapter.event_list_Adapter;
import PSbankVO.bottle_kongVO;
import PSbankVO.event_ProductVO;

public class Bottle_king_Activity extends AppCompatActivity {


    private ListView bottle_king_view;
    private PSbankAdapter.bottle_king_Adapter bottle_king_Adapter;
    private ArrayList<bottle_kongVO> bottle_king_data;



    private int[] bottle_img_Array = {R.drawable.sojo, R.drawable.apeach, R.drawable.item1, R.drawable.item2,R.drawable.item3};

    private String[] bottle_round = {"1", "2", "3" ,"4","5"};
    private String[] bottle_id = {"홍진석", "콩진석" , "콩콩진석", "콩콩콩진석", "콩콩콩콩진석"};
    private String[] bottle_now = {"현재갯수","현재갯수","현재갯수","현재갯수","현재갯수"};
    private String[] bottle_score = {"150ECO", "130ECO","120ECO", "110ECO", "100ECO" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_king);


        String event_num = getIntent().getStringExtra("event_num");
        Log.d("이거 오류얌", event_num);





        // 여기쯤에서 정보 가져와야함


        JSONArray lll = new JSONArray();




        ListView bottle_list_king = findViewById(R.id.bottle_list_king);
        bottle_king_data = new ArrayList<>();



        for(int i = 0; i<bottle_img_Array.length; i++) {


            bottle_king_data.add(new bottle_kongVO(

                   /* machine_name = machine.getString("machine_name");    <----- 이게 JSON형식 */

            /*JSON가져오기 */bottle_img_Array[i],
                    bottle_round[i],
                    bottle_id[i],bottle_now[i],bottle_score[i]));
        }


        bottle_king_Adapter = new bottle_king_Adapter(getApplicationContext(), R.layout.bottle_king_win, bottle_king_data);
        bottle_list_king.setAdapter(bottle_king_Adapter);






         ;
    }
}