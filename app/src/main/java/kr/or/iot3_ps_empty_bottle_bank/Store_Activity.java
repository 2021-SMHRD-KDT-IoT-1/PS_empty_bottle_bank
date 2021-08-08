package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import PSbankAdapter.Point_Ck_Adapter;
import PSbankAdapter.Store_product_Adapter;
import PSbankVO.Point_ckVO;
import PSbankVO.Store_productVO;

public class Store_Activity extends AppCompatActivity {


    private ListView product_listview;
    private PSbankAdapter.Store_product_Adapter Store_product_Adapter;
    private ArrayList<Store_productVO> product_data;

    RequestQueue queue;

    private StringRequest request;

    private int[] product_img_Array = {R.drawable.item1, R.drawable.sojo, R.drawable.apeach, R.drawable.item2, R.drawable.item3};
    private String[] product_name = {"라이언 텀블러", "개구리 인형", "어피치 피규어", "라이언 슬리퍼", "핸드폰 케이스"};
    private String[] product_price = {"8000 point", "7000 point", "6000 point", "5000 point", "4000 point"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);



        queue = Volley.newRequestQueue(getApplicationContext());



        product_listview = findViewById(R.id.store_product_listview);
        product_data = new ArrayList<>();
        for (int i = 0; i<product_img_Array.length; i++) {
            product_data.add(new Store_productVO(product_img_Array[i],product_name[i],product_price[i]));
        }

        Store_product_Adapter = new Store_product_Adapter(getApplicationContext(), R.layout.store_buy_listview, product_data);
        product_listview.setAdapter(Store_product_Adapter);




    }
}