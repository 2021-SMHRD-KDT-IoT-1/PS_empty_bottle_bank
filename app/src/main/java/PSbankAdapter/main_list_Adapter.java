package PSbankAdapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.main_ProductVO;
import kr.or.iot3_ps_empty_bottle_bank.R;
import kr.or.iot3_ps_empty_bottle_bank.Detail_Activity;

public class main_list_Adapter extends BaseAdapter {


    private Context main_context;
    private int mains_layout;
    private ArrayList<main_ProductVO> main_data;
    private LayoutInflater inflater;


    public main_list_Adapter(Context main_context, int mains_layout, ArrayList<main_ProductVO> main_data) {
        this.main_context = main_context;
        this.mains_layout = mains_layout;
        this.main_data = main_data;
        this.inflater = (LayoutInflater) main_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return main_data.size();
    }

    @Override
    public Object getItem(int position) {
        return main_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(mains_layout, parent, false);

        }

        ImageView main_list_img = convertView.findViewById(R.id.main_list_img);
        TextView main_list_tlt = convertView.findViewById(R.id.machine_name);
        TextView main_list_text1 = convertView.findViewById(R.id.main_list_text1);
        TextView main_list_text2 = convertView.findViewById(R.id.broken);
        View main_list_view = convertView.findViewById(R.id.main_list_view);


        //main_ProductVO main_vo = (main_ProductVO)getItem(position);
        main_ProductVO main_vo2 = main_data.get(position);



        main_list_tlt.setText(main_vo2.getMachine_name());
        main_list_img.setImageResource(main_vo2.getMain_list_img());
        Log.d("img_check", String.valueOf(main_vo2.getMain_list_img()));
        main_list_text1.setText(main_vo2.getStorable_bottle());
        main_list_text2.setText(main_vo2.getBroken());


        main_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(main_context, Detail_Activity.class);
                    intent.putExtra("machine_num", String.valueOf(main_vo2.getMachine_num()));
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    main_context.startActivity(intent);

            }});

        return convertView;
    }





}


