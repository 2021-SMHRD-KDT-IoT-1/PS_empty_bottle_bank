package PSbankFagment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import PSbankAdapter.event_list_Adapter;
import PSbankVO.event_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class Fragment_Event extends Fragment  {




    private ListView event_main_ListView;
    private event_list_Adapter event_Adapter;
    private ArrayList<event_ProductVO> event_list_data;



    private int[] eventArray = {R.drawable.sojo, R.drawable.apeach, R.drawable.item1, R.drawable.item2,R.drawable.item3};

    private String[] eventname = {"우리동네 공병왕 이벤트", "대박로또이벤트", "내 이름은 콩진석" ,"내 이름은 콩진석","내 이름은 콩진석"};
    private String[] eventtime = {"2021.03.14 ~ 2021.08.13", "2021.03.14 ~ 2021.08.13", "2021.03.14 ~ 2021.08.13",
            "2021.03.14 ~ 2021.08.13","2021.03.14 ~ 2021.08.13"};





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);



        // ===========여기는 플레그먼트 이벤트 출력하는 곳

        event_main_ListView = view.findViewById(R.id.event_main_ListView);
        event_list_data = new ArrayList<>();

        for(int i = 0; i<eventArray.length; i++) {
            event_list_data.add(new event_ProductVO(eventArray[i], eventname[i], eventtime[i]));
        }



        event_Adapter = new event_list_Adapter(getActivity(), R.layout.event_list_view ,event_list_data);


        event_main_ListView.setAdapter(event_Adapter);
        return view;
    }
}