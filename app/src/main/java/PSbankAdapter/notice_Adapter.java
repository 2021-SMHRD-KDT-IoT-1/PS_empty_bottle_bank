package PSbankAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import PSbankVO.noticeVO;
import kr.or.iot3_ps_empty_bottle_bank.Bottle_king_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Lotto_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Notice_1_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;


public class notice_Adapter extends BaseAdapter {

    private Context notice_context;
    private int notice_layout;
    private ArrayList<noticeVO> notice_data;
    private LayoutInflater notice_inflater;

    public notice_Adapter(Context notice_context, int notice_layout, ArrayList<noticeVO> notice_data) {
        this.notice_context = notice_context;
        this.notice_layout = notice_layout;
        this.notice_data = notice_data;
        this.notice_inflater =(LayoutInflater)notice_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notice_data.size();
    }

    @Override
    public Object getItem(int position) {
        return notice_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = notice_inflater.inflate(notice_layout, parent,false);
        }

        TextView notice_num = convertView.findViewById(R.id.notice_num);
        TextView notice_title = convertView.findViewById(R.id.notice_title);
        TextView notice_content = convertView.findViewById(R.id.notice_content);
        View notice_list_view = convertView.findViewById(R.id.notice_list_view);

        noticeVO noticevo = notice_data.get(position);

        notice_num.setText(noticevo.getNotice_num());
        notice_title.setText(noticevo.getNotice_title());
        notice_content.setText(noticevo.getNotice_content());

       notice_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {

                    Intent intent = new Intent(notice_context, Notice_1_Activity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    notice_context.startActivity(intent);


                }else if (position == 1 ){
                    Intent intent = new Intent(notice_context, Lotto_Activity.class);
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    notice_context.startActivity(intent);
                }
            }
        });





        return convertView;
    }
}
