package PSbankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.s_my_storeVO;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class s_my_stroe_Adapter extends BaseAdapter {

    private Context s_store_context;
    private int s_my_store_layout;
    private ArrayList<s_my_storeVO> s_my_store_data;
    private LayoutInflater Inflater_s_store;

    public s_my_stroe_Adapter(Context s_store_context, int s_my_store_layout, ArrayList<s_my_storeVO> s_my_store_data) {
        this.s_store_context = s_store_context;
        this.s_my_store_layout = s_my_store_layout;
        this.s_my_store_data = s_my_store_data;
        this.Inflater_s_store = (LayoutInflater)s_store_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return s_my_store_data.size();
    }

    @Override
    public Object getItem(int position) {
        return s_my_store_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = Inflater_s_store.inflate(s_my_store_layout, parent, false);
        }


        TextView s_my_store_day = convertView.findViewById(R.id.S_my_store_day);
        TextView s_my_store_content = convertView.findViewById(R.id.S_my_store_content);
        TextView s_my_point = convertView.findViewById(R.id.S_my_point);
        View s_store_list_view = convertView.findViewById(R.id.S_store_list_view);

        s_my_storeVO s_my_storeVO2 = s_my_store_data.get(position);

        s_my_store_day.setText(s_my_storeVO2.getS_my_store_day());
        s_my_store_content.setText(s_my_storeVO2.getS_my_store_content());
        s_my_point.setText(s_my_storeVO2.getS_my_point());



        return convertView;
    }
}
