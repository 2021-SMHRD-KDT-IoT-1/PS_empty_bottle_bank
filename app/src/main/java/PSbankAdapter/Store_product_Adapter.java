package PSbankAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import PSbankVO.Store_productVO;
import kr.or.iot3_ps_empty_bottle_bank.R;
import kr.or.iot3_ps_empty_bottle_bank.Store_Activity;

public class Store_product_Adapter extends BaseAdapter {

    private Context product_context;
    private int product_layout;
    private ArrayList<Store_productVO> product_data;
    private LayoutInflater inflater_product;
    Activity activity;

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
        Button  btn_buy = convertView.findViewById(R.id.btn_buy);


        View product_view = convertView.findViewById(R.id.bottle_king_view);

        Store_productVO productVO = product_data.get(position);

        product_img.setImageResource(productVO.getProduct_img());
        item_name.setText(productVO.getItem_name());
        item_price.setText(productVO.getItem_price());
        item_count.setText(productVO.getItem_count());


//        btn_buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(product_context);
//                builder.setTitle("구매확인");
//                builder.setTitle("선택하신 상품을 구매하시겠습니까?");
//                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(product_context, "구매완료", Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(product_context, "구매가 취소되었습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                });
//             AlertDialog alert = builder.create();
//
//             alert.show();
//            }
//        });




        return convertView;
    }
}
