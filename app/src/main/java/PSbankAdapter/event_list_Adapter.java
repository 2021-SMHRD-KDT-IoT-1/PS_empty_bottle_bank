package PSbankAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

import PSbankVO.event_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.Bottle_king_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Lotto_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class event_list_Adapter extends BaseAdapter {

    private Context event_context;
    private int event_layout;
    private ArrayList<event_ProductVO> event_data;
    private LayoutInflater inflater1;

    RequestQueue queue;


    public event_list_Adapter(Context event_context, int event_layout, ArrayList<event_ProductVO> event_data) {
        this.event_context = event_context;
        this.event_layout = event_layout;
        this.event_data = event_data;
        this.inflater1 = (LayoutInflater) event_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return event_data.size();
    }

    @Override
    public Object getItem(int position) {
        return event_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater1.inflate(event_layout, parent, false);
        }

        ImageView event_img = convertView.findViewById(R.id.event_img);
        TextView event_tlt = convertView.findViewById(R.id.event_tlt);
        TextView event_text = convertView.findViewById(R.id.event_time);
        View event_list_view = convertView.findViewById(R.id.event_list_view);


        event_ProductVO event_vo2 = event_data.get(position);

        event_img.setImageResource(event_vo2.getEvent_img());
        event_tlt.setText(event_vo2.getEvent_tlt());
        event_text.setText(event_vo2.getEvent_time());


        event_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (position == 0) {
                    Intent intent = new Intent(event_context, Bottle_king_Activity.class);
                    intent.putExtra("event_num", 0);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    event_context.startActivity(intent);


                } else if (position == 1) {
                    Intent intent = new Intent(event_context, Lotto_Activity.class);
                    intent.putExtra("event_num", 1);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    event_context.startActivity(intent);
                }
            }
        });


        return convertView;
    }
}
