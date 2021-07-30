package kr.or.iot3_ps_empty_bottle_bank;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Returner_Myinfo_Modify extends AppCompatActivity {

    Spinner returner_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returner_myinfo_modify);


        returner_spinner = findViewById(R.id.returner_spinner);

        ArrayAdapter loc_Adapter = ArrayAdapter.createFromResource(this, R.array.locArray, R.layout.support_simple_spinner_dropdown_item);

        loc_Adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        returner_spinner.setAdapter(loc_Adapter);

        returner_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}