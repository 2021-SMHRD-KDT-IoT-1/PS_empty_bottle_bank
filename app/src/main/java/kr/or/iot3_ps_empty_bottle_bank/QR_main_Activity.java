package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

import java.util.HashMap;
import java.util.Map;


public class QR_main_Activity extends AppCompatActivity {

    IntentIntegrator integrator;
    RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_main);

        queue = Volley.newRequestQueue(getApplicationContext());
        integrator = new IntentIntegrator(this);
        integrator.setOrientationLocked(false);

        // 바코드 안의 텍스트

        // 바코드 인식 시 소리 여부
        integrator.setBeepEnabled(false);


        integrator.setBarcodeImageEnabled(true);
        integrator.setCaptureActivity(CaptureActivity.class);


        //바코드 스캐너 시작
        integrator.initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {

            } else {
                // qr코드 가져옴


                //  회수기 정보가 같이 보내져야함
                String login_url = result.getContents();
                Log.d("mmmmm", login_url);


                StringRequest request = new StringRequest(Request.Method.POST, login_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                    Toast.makeText(getApplicationContext(), "접속 성공", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "접속 실패", Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();

//                        params.put("id", id);
//                        params.put("pw", pw);

                        return params;
                    }
                };
                queue.add(request);



                // 화면 전환
//                Intent intent = new Intent(getApplicationContext(), Detail_Activity.class);
//                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }


}