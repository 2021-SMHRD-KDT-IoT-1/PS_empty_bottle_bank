package kr.or.smhrd.test_0726;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Question2 extends AppCompatActivity implements View.OnClickListener{

    ImageView img;
    Button next_btn, pre_btn;

    int[] imgs = {R.drawable.apeach, R.drawable.baskin_apeach, R.drawable.lovely_apeach};
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        img = findViewById(R.id.img);
        next_btn = findViewById(R.id.next_btn);
        pre_btn = findViewById(R.id.pre_btn);

        next_btn.setOnClickListener(this);
        pre_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.next_btn) {
            //이미지 변경하는 메소드
            // --> 이미지 파일 접근방법 : R.drawble.파일명

            if(pos==imgs.length-1){ pos=0; }
            else{ pos +=1; }


        }else if(v.getId() == R.id.pre_btn){
            if(pos==0){ pos=imgs.length-1; }
            else{ pos -=1; }
        }
        img.setImageResource(imgs[pos]);

    }
}