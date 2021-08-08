package PSbankAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import PSbankVO.Store_productVO;
import kr.or.iot3_ps_empty_bottle_bank.R;

public class Store_product_Adapter extends BaseAdapter {

    private Context product_context;
    private int product_layout;
    private ArrayList<Store_productVO> product_data;
    private LayoutInflater inflater_product;

    public Store_product_Adapter(Context product_context, int product_layout, ArrayList<Store_productVO> product_data) {
        this.product_context = product_context;
        this.product_layout = product_layout;
        this.product_data = product_data;
        this.inflater_product = (LayoutInflater) product_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return product_data.size();
    }

    @Override
    public Object getItem(int position) {
        return product_data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater_product.inflate(product_layout, parent, false);
        }

        ImageView product_img = convertView.findViewById(R.id.product_img);
        TextView item_name = convertView.findViewById(R.id.item_name);
        TextView item_price = convertView.findViewById(R.id.item_price);
        TextView item_count = convertView.findViewById(R.id.item_count);


        View product_view = convertView.findViewById(R.id.bottle_king_view);

        Store_productVO productVO = product_data.get(position);

        product_img.setImageResource(productVO.getProduct_img());
        item_name.setText(productVO.getItem_name());
        item_price.setText(productVO.getItem_price());
        item_count.setText(productVO.getItem_count());



        return convertView;
    }
}
