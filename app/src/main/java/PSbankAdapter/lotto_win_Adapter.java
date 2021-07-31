package PSbankAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.bottle_kongVO;
import PSbankVO.lotto_winVO;
import kr.or.iot3_ps_empty_bottle_bank.Bottle_king_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Lotto_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class lotto_win_Adapter extends BaseAdapter {


    private Context lotto_context;
    private int lotto_layout;
    private ArrayList<lotto_winVO> lotto_data;
    private LayoutInflater inflater_lotto;


    public lotto_win_Adapter(Context lotto_context, int lotto_layout, ArrayList<lotto_winVO> lotto_data) {
        this.lotto_context = lotto_context;
        this.lotto_layout = lotto_layout;
        this.lotto_data = lotto_data;
        this.inflater_lotto = (LayoutInflater) lotto_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lotto_data.size();
    }

    @Override
    public Object getItem(int position) {
        return lotto_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null) {
            convertView = inflater_lotto.inflate(lotto_layout, parent, false);
        }

        TextView lotto_round = convertView.findViewById(R.id.lotto_round);
        TextView lotto_win_1 = convertView.findViewById(R.id.lotto_win_1);
        TextView lotto_win_2 = convertView.findViewById(R.id.lotto_win_2);
        TextView lotto_win_3 = convertView.findViewById(R.id.lotto_win_3);
        View lotto_list_view = convertView.findViewById(R.id.lotto_list_view);

        lotto_winVO lotto_vo2 = lotto_data.get(position);

        lotto_round.setText(lotto_vo2.getLotto_round());
        lotto_win_1.setText(lotto_vo2.getLotto_win1());
        lotto_win_2.setText(lotto_vo2.getLotto_win2());
        lotto_win_3.setText(lotto_vo2.getLotto_win3());


        Intent intent = new Intent(lotto_context, Lotto_Activity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        lotto_context.startActivity(intent);

        return convertView;
    }
}
