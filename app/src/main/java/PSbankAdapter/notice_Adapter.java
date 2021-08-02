package PSbankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import PSbankVO.noticeVO;
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

        TextView notice_title = convertView.findViewById(R.id.notice_title);
        TextView notice_content = convertView.findViewById(R.id.notice_content);

        noticeVO noticevo = notice_data.get(position);

        notice_title.setText(noticevo.getNotice_title());
        notice_content.setText(noticevo.getNotice_content());

        return convertView;
    }
}
