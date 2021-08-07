package kr.or.iot3_ps_empty_bottle_bank;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import PSbankAdapter.my_eventcontent_Adapter;
import PSbankVO.my_eventcontentVO;

public class My_event_Activity extends AppCompatActivity {


    private ListView my_event_list_view_co;
    private PSbankAdapter.my_eventcontent_Adapter my_eventcontent_Adapter;
    private ArrayList<my_eventcontentVO> my_event_data;




    private String[] event_my_day = {"2021.03.14", "2021.03.19", "2021.06.16", "2021.06.17", "2021.09.16"};
    private String[] event_my_content = {"1회차 대박로또이벤트 참여","1회차 대박로또이벤트 당첨","4회차 대박로또이벤트 참여","5회차 대박로또이벤트 참여","6회차 대박로또이벤트 참여"};
    private String[] event_my_point = {"-5000P", "+1억P", "-5000P","-5000P","-5000P"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_event);




        my_event_list_view_co =  findViewById(R.id.my_event_list_view_co);
        my_event_data = new ArrayList<>();
        for (int i = 0; i < event_my_day.length; i++) {
            my_event_data.add(new my_eventcontentVO(event_my_day[i],event_my_content[i],event_my_point[i]));
        }
        my_eventcontent_Adapter = new my_eventcontent_Adapter(getApplicationContext(), R.layout.my_event_content_view, my_event_data);
        my_event_list_view_co.setAdapter(my_eventcontent_Adapter);




    }
}