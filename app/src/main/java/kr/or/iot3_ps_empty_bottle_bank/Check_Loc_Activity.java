package kr.or.iot3_ps_empty_bottle_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

public class Check_Loc_Activity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double[] latitude_array = {35.11090517646709, 35.149882507315205, 35.14816233553151, 35.160135786711756, 35.148571214508436, 35.14206335912754, 35.165322981154226, 35.154602383482484};
    private double[] longtitude_array = {126.8773327692565, 126.91983094921517, 126.9245570043737, 126.85147868185122, 126.91326306206815, 126.93224500643585, 126.90923772658823, 126.90193318249759};
    private String[] snippet_array = {"광주CGI센터","무인회수기 : 대의점","무인회수기 : 동명점","무인회수기 : 시청점","무인회수기 : 충장NC점","무인회수기 : 조선대점","무인회수기 : 광주역점","무인회수기 : 양동시장점"};
    double machine_lat = 0;
    double machine_lon = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_loc);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //37.56, 126.97 서울 위도 경도
        // 35.14610451046296, 126.92312786427603  동구청 위도 경도 (동명동 지점?? 임시)
        // 35.11090517646709, 126.8773327692565  광주 CGI 센터
//        String machine_num = getIntent().getStringExtra("machine_num");
//        String Detail_url = "http://rspring41.iptime.org:3000/machine/" + machine_num;
//
//
//        StringRequest request = new StringRequest(Request.Method.GET, Detail_url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            JSONObject machine_info = new JSONObject(response);
//
//                            machine_lat = Double.parseDouble(machine_info.getString("machine_lat"));
//                            machine_lon = Double.parseDouble(machine_info.getString("machine_lon"));
//                            Log.v(machine_info.getString("machine_lat") , machine_info.getString("machine_lon"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("오류", "접속실패");
//                Toast.makeText(getApplicationContext(), "접속 실패", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        LatLng location = new LatLng(35.11090517646709, 126.8773327692565);

        /*MarkerOptions markerOptions = new MarkerOptions();         // 마커 생성
        markerOptions.position(new LatLng(35.149753, 126.919913))
                .title("광주광역시")                        // 마커 제목
                .snippet("스마트인재개발원")                 // 마커 설명
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .alpha(0.7f);
        mMap.addMarker(markerOptions);*/

        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.ps_marker);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, 200, 200, false);

        for(int i = 0; i<snippet_array.length; i++){

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions
                    .position(new LatLng(latitude_array[i],longtitude_array[i]))
                    .title("광주광역시")
                    .snippet(snippet_array[i])
                    .icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
                    .alpha(0.7f);

            mMap.addMarker(markerOptions);

        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));                 // 초기 위치
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,18));                         // 줌의 정도
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);                           // 지도 유형 설정

    }
}