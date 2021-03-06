package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
import PSbankFagment.Fragment_Myinfo;
import PSbankVO.Point_ckVO;
import PSbankVO.Store_productVO;
import PSbankVO.Store_s_pointVO;

public class Store_Activity extends AppCompatActivity {

    private TextView user_points;
    private ListView product_listview;
    private PSbankAdapter.Store_product_Adapter Store_product_Adapter;
    private ArrayList<Store_productVO> product_data;
    private ArrayList<Store_s_pointVO> mypoint_data;
    private Button btn_reset2;

    RequestQueue queue;




    private int[] product_img_Array = {R.drawable.starbucks, R.drawable.baskinrobbins,
            R.drawable.twosome, R.drawable.touslesjours, R.drawable.starbucksrrdd,
            R.drawable.twosomerrdd, R.drawable.coffeebean, R.drawable.joss,
            R.drawable.bkblock, R.drawable.starbuckmint};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);



        queue = Volley.newRequestQueue(getApplicationContext());
        user_points = findViewById(R.id.user_points);
        btn_reset2 = findViewById(R.id.btn_reset2);



        store_result();
        btn_reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store_result();

            }
        });





    }


    public void store_result() {

        // ????????? ????????? ID????????????===================================================
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");

        String store_url = "http://rspring41.iptime.org:3000/store?id=" + login_id;


        StringRequest request = new StringRequest(Request.Method.GET, store_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {

                    JSONArray jsonArray = new JSONArray(response);
                    product_data = new ArrayList<>();

                    Log.d("?????? ???????", response);


                    JSONArray jsonArray2 = jsonArray.getJSONArray(0);

                    for (int row2 = 0; row2 < jsonArray2.length(); row2++) {
                        JSONObject jsonObject = jsonArray2.getJSONObject(row2);

                        product_data.add(new Store_productVO(
                                jsonObject.getInt("item_code"),
                                product_img_Array[row2],
                                jsonObject.getString("item_name"),
                                jsonObject.getString("item_price"),
                                jsonObject.getString("item_count")

                        ));


                    }
                    JSONArray jsonArray3 = jsonArray.getJSONArray(1);
                    JSONObject userInfo = jsonArray3.getJSONObject(0);
                    String user_point = userInfo.getString("point");

                    user_points.setText(user_point);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("???????????????~", "???????????????!");
                product_listview = findViewById(R.id.store_product_listview);
                Store_product_Adapter = new Store_product_Adapter(getApplicationContext(), R.layout.store_buy_listview, product_data);
                product_listview.setAdapter(Store_product_Adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("?????? ?????????", "?????????~");


            }
        });
        queue.add(request);
    }




//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        //TODO ???????????? ?????? ????????? ????????? ??????
//        Intent intent = getIntent();
//        finish(); //?????? ???????????? ?????? ??????
//        overridePendingTransition(0, 0); //????????? ??????????????? ?????????
//        startActivity(intent); //?????? ???????????? ????????? ??????
//        overridePendingTransition(0, 0); //????????? ??????????????? ?????????
//        intent = new Intent(getApplicationContext(), Fragment_Myinfo.class);
//        startActivity(intent);
//    }

}