package kr.or.iot3_ps_empty_bottle_bank;

import android.content.Context;
import android.content.Intent;
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

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;


public class QR_main_Activity extends AppCompatActivity {

    WebView QR_wv;
    EditText QR_et;
    Button QR_bt;
    IntentIntegrator integrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_main);


        QR_wv = findViewById(R.id.QR_wv);
        QR_et = findViewById(R.id.QR_et);

        QR_bt = findViewById(R.id.QR_bt);
        WebSettings webSettings = QR_wv.getSettings();

        //자바 스크립트 사용을 할 수 있도록 합니다.
        webSettings.setJavaScriptEnabled(true);

        //페이지 로딩이 끝나면 호출됩니다.
        QR_wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(QR_main_Activity.this,"로딩 완료!!",Toast.LENGTH_SHORT).show();
            }
        });
        QR_et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    //bt의 onClick을 실행
                    QR_bt.callOnClick();
                    // 키보드 숨기기
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),0);
                    return true;
                }

                return false;
            }
        });

        integrator = new IntentIntegrator(this);


        // 바코드 안의 텍스트
        integrator.setPrompt("바코드를 사각형 안에 비춰주세요");

        // 바코드 인식 시 소리 여부
        integrator.setBeepEnabled(false);


        integrator.setBarcodeImageEnabled(true);
        integrator.setCaptureActivity(CaptureActivity.class);


        //바코드 스캐너 시작
        integrator.initiateScan();

    }

    public void OnClick(View view) {
        String address = QR_et.getText().toString();

        if (!address.startsWith("http://")) {
            address = "http://" + address;
        }
        QR_wv.loadUrl(address);

    Log.d("QR주소", address);


    }

    @Override
    public void onBackPressed() {
        if (QR_wv.isActivated()) {
            if (QR_wv.canGoBack()) {
                QR_wv.goBack();
            } else {
                //스캐너 시작
                integrator.initiateScan();
            }
        } else {
            super.onBackPressed();
        }
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//
//        if (result != null) {
//            if (result.getContents() == null) {
//
//            } else {
//                //qr코드를 읽어서 Edit Text에 입력해줍니다.
//                QR_et.setText(result.getContents());
//
//                //Button의 onclick호출
//                QR_bt.callOnClick();
//
//                Toast.makeText(this, "Scanned :" + result.getContents(), Toast.LENGTH_SHORT).show();
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//
//    }


}