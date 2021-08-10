package PSbankAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import PSbankFagment.Fragment_Myinfo;
import PSbankVO.Store_productVO;
import kr.or.iot3_ps_empty_bottle_bank.Login_Activity;
import kr.or.iot3_ps_empty_bottle_bank.MainActivity;
import kr.or.iot3_ps_empty_bottle_bank.R;
import kr.or.iot3_ps_empty_bottle_bank.Store_Activity;

public class Store_product_Adapter extends BaseAdapter {

    private Context product_context;
    private int product_layout;
    private ArrayList<Store_productVO> product_data;
    private LayoutInflater inflater_product;
    Activity activity;
    RequestQueue queue;

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


        queue = Volley.newRequestQueue(product_context.getApplicationContext());
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




        // 물건 구매하기 버튼
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 접속한 사용자 ID가져오기===================================================
                SharedPreferences sf = product_context.getSharedPreferences("login", Context.MODE_PRIVATE);
                String login_id = sf.getString("login_id", "");

                String login_url = "http://rspring41.iptime.org:3000/store";

                login_url += "?id=" + login_id + "&code=" + String.valueOf(productVO.getItem_code());

                StringRequest request = new StringRequest(Request.Method.GET, login_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.v("계정내역", response);
                                if(response.equals("0")){
                                    Toast.makeText(product_context.getApplicationContext(), "코인이 부족합니다.", Toast.LENGTH_SHORT).show();

                                }else{
                                    Toast.makeText(product_context.getApplicationContext(), "구매가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                    
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.v("오류", "요청실패");
                            }
                        });
                queue.add(request);


           }


        });


        return convertView;
    }





}
