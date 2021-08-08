package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    private int[] product_img_Array = {R.drawable.item1, R.drawable.sojo, R.drawable.apeach,
            R.drawable.item2, R.drawable.item3,R.drawable.item3,
            R.drawable.item3,R.drawable.item3,R.drawable.item3};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        queue = Volley.newRequestQueue(getApplicationContext());

        String store_url = "http://rspring41.iptime.org:3000/store";



        request = new StringRequest(Request.Method.GET, store_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonArray = new JSONArray(response);
                    product_data = new ArrayList<>();
                    Log.d("나는 뭘까?", "너는 뭘까?");
                    for (int i = 0; i <jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Log.d("나는 나다!", "너는 너다!");
                        product_data.add(new Store_productVO(
                               jsonObject.getInt("item_code"),
                                product_img_Array[i],
                                jsonObject.getString("item_name"),
                                jsonObject.getString("item_price"),
                                jsonObject.getString("item_count")


                        ));


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("안녕하세요~","반갑습ㄴ다!");
                product_listview = findViewById(R.id.store_product_listview);
                Store_product_Adapter = new Store_product_Adapter(getApplicationContext(), R.layout.store_buy_listview, product_data);
                product_listview.setAdapter(Store_product_Adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("이거 오류얌", "고쳐줘~");


            }
        });


        queue.add(request);



    }
}