package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import PSbankAdapter.Point_Ck_Adapter;
import PSbankVO.Point_ckVO;

public class Point_Check_Activity extends AppCompatActivity {

    TextView Point_Ck_day, Point_Ck_content,Point_Ck_point;

    private ListView Point_main_ck_list;
    private PSbankAdapter.Point_Ck_Adapter Point_Ck_Adapter;
    private ArrayList<Point_ckVO> Point_ck_data;

    RequestQueue Queue;



//    private String[] Point_Ck_day = {"1999.02.20", "1999.02.20", "1999.02.20","1999.02.20","1999.02.20"};
//    private String[] Point_Ck_content = {"맥주병 적립!","소주병 적립!","소주병 적립","맥주병 적립","소주병 적립!" };
//    private String[] Point_Ck_point = {"+130","+100","+100","+130","+100"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_check);

        Point_Ck_day = findViewById(R.id.Point_Ck_day);
        Point_Ck_content = findViewById(R.id.Point_Ck_content);
        Point_Ck_point = findViewById(R.id.Point_Ck_point);
        Queue = Volley.newRequestQueue(getApplicationContext());









//        Point_main_ck_list = findViewById(R.id.Point_main_ck_list);
//        Point_ck_data = new ArrayList<>();
//        for (int i = 0; i<Point_Ck_day.length; i++) {
//            Point_ck_data.add(new Point_ckVO(Point_Ck_day[i],Point_Ck_content[i],Point_Ck_point[i]));
//        }
//
//        Point_Ck_Adapter = new Point_Ck_Adapter(getApplicationContext(), R.layout.point_custom_list, Point_ck_data);
//        Point_main_ck_list.setAdapter(Point_Ck_Adapter);

    }
}