package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Myinfo_Modify extends AppCompatActivity {

   Button myinfo_btn_modify;
    EditText edt_name, edt_pw, edt_tellnum;
    ImageView ps_picture;

    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo_modify);


        edt_name = findViewById(R.id.edt_name);
        edt_pw = findViewById(R.id.edt_pw);
        edt_tellnum = findViewById(R.id.edt_tellnum);
        myinfo_btn_modify = findViewById(R.id.myinfo_btn_modify);
        ps_picture = findViewById(R.id.ps_picture);

        queue = Volley.newRequestQueue(getApplicationContext());

        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");

        if(login_id.equals("hong")){
            ps_picture.setImageResource(R.drawable.profile2);
        }else if(login_id.equals("ps")){
            ps_picture.setImageResource(R.drawable.profile1);
        }else if(login_id.equals("choi")){
            ps_picture.setImageResource(R.drawable.profile3);
        }


        myinfo_btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replace_user_info();


            }
        });
    }


    // ????????? ?????? ??????
    public void replace_user_info() {
        String name = edt_name.getText().toString();
        String pw = edt_pw.getText().toString();
        String tel = edt_tellnum.getText().toString();
        // ????????? ????????? ID????????????
        SharedPreferences sf = getSharedPreferences("login", Context.MODE_PRIVATE);
        String login_id = sf.getString("login_id", "");


        if (name.length() == 0) {
            Toast.makeText(this, "????????? ??????????????????", Toast.LENGTH_SHORT).show();
            edt_name.requestFocus();
            return;
        } else if (pw.length() == 0) {
            Toast.makeText(getApplicationContext(), "??????????????? ???????????????.", Toast.LENGTH_SHORT).show();
            edt_pw.requestFocus();
            return;
        } else if (tel.length() == 0) {
            Toast.makeText(getApplicationContext(), "??????????????? ??????????????????", Toast.LENGTH_SHORT).show();
            edt_tellnum.requestFocus();
            return;
        } else {


            String requestURL = "http://rspring41.iptime.org:3000/myinfo_modify/";
            requestURL += login_id + "?name=" + name + "&tel=" + tel + "&pw=" + pw;


            StringRequest request = new StringRequest(Request.Method.GET, requestURL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.v("????????????", response);
                            if (response.equals("0")) {
                                Toast.makeText(getApplicationContext(), "?????? ??????", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "?????? ??????", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.v("??????", "????????????");
                        }
                    });
            queue.add(request);


        }


        Intent intent =  new Intent();
        intent.putExtra("name",name);
        intent.putExtra("id",login_id);
        intent.putExtra("tel",tel);
        setResult(RESULT_OK,intent);
        finish();
    }
}