package PSbankAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.bottle_kongVO;
import PSbankVO.event_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.Bottle_king_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Detail_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class bottle_king_Adapter extends BaseAdapter {

    private Context king_context;
    private int king_layout;
    private ArrayList<bottle_kongVO> king_data;
    private LayoutInflater inflater_king;

    public bottle_king_Adapter(Context king_context, int king_layout, ArrayList<bottle_kongVO> king_data) {
        this.king_context = king_context;
        this.king_layout = king_layout;
        this.king_data = king_data;
        this.inflater_king = (LayoutInflater) king_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return king_data.size();
    }

    @Override
    public Object getItem(int position) {
        return king_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater_king.inflate(king_layout, parent, false);
        }

        ImageView bottle_king_img = convertView.findViewById(R.id.bottle_king_img);
        TextView bottle_king_round = convertView.findViewById(R.id.bottle_king_round);
        TextView bottle_king_id = convertView.findViewById(R.id.bottle_king_id);
        TextView bottle_king_now = convertView.findViewById(R.id.bottle_king_now);
        TextView bottle_king_score = convertView.findViewById(R.id.bottle_king_score);
        View bottle_king_view = convertView.findViewById(R.id.bottle_king_view);

        bottle_kongVO king_vo2 = king_data.get(position);

        bottle_king_img.setImageResource(king_vo2.getBottle_king_img());
        bottle_king_round.setText(king_vo2.getBottle_king_round());
        bottle_king_id.setText(king_vo2.getBottle_king_id());
        bottle_king_now.setText(king_vo2.getBottle_king_now());
        bottle_king_score.setText(king_vo2.getBottle_king_score());


        Intent intent = new Intent(king_context, Bottle_king_Activity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        king_context.startActivity(intent);

        return convertView;
    }
}
