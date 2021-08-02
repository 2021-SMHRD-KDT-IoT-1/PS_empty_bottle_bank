package PSbankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.Point_ckVO;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class Point_Ck_Adapter extends BaseAdapter {

    private Context Point_Ck_Context;
    private int Point_Ck_layout;
    private ArrayList<Point_ckVO> Point_ck_data;
    private LayoutInflater inflater_Point_ck;


    public Point_Ck_Adapter(Context point_Ck_Context, int point_Ck_layout, ArrayList<Point_ckVO> point_ck_data) {
        this.Point_Ck_Context = point_Ck_Context;
        this.Point_Ck_layout = point_Ck_layout;
        this.Point_ck_data = point_ck_data;
        this.inflater_Point_ck = (LayoutInflater) Point_Ck_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Point_ck_data.size();
    }

    @Override
    public Object getItem(int position) {
        return Point_ck_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater_Point_ck.inflate(Point_Ck_layout,parent,false);
        }


        TextView Point_Ck_day = convertView.findViewById(R.id.Point_Ck_day);
        TextView Point_Ck_content = convertView.findViewById(R.id.Point_Ck_content);
        TextView Point_Ck_point = convertView.findViewById(R.id.Point_Ck_point);


        Point_ckVO Point_ckVO2 = Point_ck_data.get(position);

        Point_Ck_day.setText(Point_ckVO2.getPoint_Ck_day());
        Point_Ck_content.setText(Point_ckVO2.getPoint_Ck_content());
        Point_Ck_point.setText(Point_ckVO2.getPoint_Ck_point());



        return convertView;
    }
}
