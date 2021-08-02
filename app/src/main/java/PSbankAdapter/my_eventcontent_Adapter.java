package PSbankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.my_eventcontentVO;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class my_eventcontent_Adapter extends BaseAdapter {

    private Context my_event_context;
    private int my_event_layout;
    private ArrayList<my_eventcontentVO> my_event_data;
    private LayoutInflater inflater_my_event;


    public my_eventcontent_Adapter(Context my_event_context, int my_event_layout, ArrayList<my_eventcontentVO> my_event_data) {
        this.my_event_context = my_event_context;
        this.my_event_layout = my_event_layout;
        this.my_event_data = my_event_data;
        this.inflater_my_event = (LayoutInflater) my_event_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return my_event_data.size();
    }

    @Override
    public Object getItem(int position) {
        return my_event_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if(convertView == null) {
            convertView = inflater_my_event.inflate(my_event_layout, parent, false);
        }

        TextView event_my_day = convertView.findViewById(R.id.event_my_day);
        TextView event_my_Content = convertView.findViewById(R.id.event_my_Content);
        TextView event_my_point = convertView.findViewById(R.id.event_my_point);
        View content_event_list_view = convertView.findViewById(R.id.content_event_list_view);


        my_eventcontentVO my_event_contentVO2 = my_event_data.get(position);

        event_my_day.setText(my_event_contentVO2.getEvent_my_day());
        event_my_Content.setText(my_event_contentVO2.getEvent_my_content());
        event_my_point.setText(my_event_contentVO2.getEvent_my_point());


        return convertView;
    }
}
