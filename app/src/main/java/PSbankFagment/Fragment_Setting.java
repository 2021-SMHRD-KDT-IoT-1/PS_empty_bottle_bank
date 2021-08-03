package PSbankFagment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import kr.or.iot3_ps_empty_bottle_bank.Account_info;
import kr.or.iot3_ps_empty_bottle_bank.Help_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Login_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Lotto_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Notice_Activity;
import kr.or.iot3_ps_empty_bottle_bank.R;
import kr.or.iot3_ps_empty_bottle_bank.User_Activity;
import kr.or.iot3_ps_empty_bottle_bank.Version_Info_Activity;


public class Fragment_Setting extends Fragment {

    Button set_btn_log, set_btn_notice, set_btn_help, set_btn_version,
            set_customer_btn_email, set_ad_btn_email, set_customer_btn_call,set_ad_btn_call;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        set_btn_log = view.findViewById(R.id.set_btn_log);
        set_btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), User_Activity.class);
                startActivity(intent);
            }
        });




        // ===여기 공지사항
        set_btn_notice = view.findViewById(R.id.set_btn_notice);
        set_btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Notice_Activity.class);
                startActivity(intent);
            }
        });

        // 여기는 도움말

        set_btn_help = view.findViewById(R.id.set_btn_help);
        set_btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Help_Activity.class);
                startActivity(intent);
            }
        });

        //여기는 버전 정보
        set_btn_version = view.findViewById(R.id.set_btn_version);
        set_btn_version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Version_Info_Activity.class);
                startActivity(intent);
            }
        });

        //여기는 고객문의----이메일발송
        set_customer_btn_email = view.findViewById(R.id.set_customer_btn_email);
        set_customer_btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                // email setting 배열로 해놔서 복수 발송 가능
                String[] address = {"kakaocjh@naver.com"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT,"제목을 입력하세요.");
                email.putExtra(Intent.EXTRA_TEXT,"내용을 입력하세요.\n");
                startActivity(email);

            }
        });

        //여기는 광고문의 ----이메일발송

        set_ad_btn_email = view.findViewById(R.id.set_ad_btn_email);
        set_ad_btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/text");
                // email setting 배열로 해놔서 복수 발송 가능
                String[] address = {"kakaocjh@naver.com"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT,"제목을 입력하세요.");
                email.putExtra(Intent.EXTRA_TEXT,"내용을 입력하세요.\n");
                startActivity(email);
            }
        });

        //고객문의 전화걸기
        set_customer_btn_call = view.findViewById(R.id.set_customer_btn_call);
        set_customer_btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                startActivity(intent);
            }
        });

        //광고문의 전화걸기
        set_ad_btn_call = view.findViewById(R.id.set_ad_btn_call);
        set_ad_btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345679"));
                startActivity(intent);
            }
        });



        return view;
    }

}