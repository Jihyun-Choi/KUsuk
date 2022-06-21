package com.korea.kusuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ListView listview ;
    private NoticeListAdapter adapter;

    int floor3_count = 0;
    int floor4_count = 0;

    TextView floor3_textView;
    TextView floor4_textView;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference database3 = mRootRef.child("reservation").child("3floor");
    DatabaseReference database4 = mRootRef.child("reservation").child("4floor");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floor3_textView = findViewById(R.id.floor3_count);
        floor4_textView = findViewById(R.id.floor4_count);
        reservation_floor3_count();
        reservation_floor4_count();
        floor3_textView.setText('2' + " / 7");
        floor4_textView.setText('3' + " / 7");

        // Adapter 생성
        adapter = new NoticeListAdapter();

        // 리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.noticeListView);
        listview.setAdapter(adapter);
        //listview.setOnItemClickListener(listener);

        adapter.addItem("KUsuk 서비스 개발자 모집", "2022-06-21", "더나은 서비스를 제공하기 위해 개발자를 모집합니다. 관심있는 분은 아래의 이메일로 지원서를 제출해주세요!");
        adapter.addItem("KUsuk 업데이트", "2022-06-20", "실시간 잔여좌석을 확인할 수 있도록 업데이트하였습니다.");
        adapter.addItem("팀플룸 이용시간 변경안내", "2022-05-25", "시험기관으로 인해 석원경상관 팀플룸 이용시간을 9:00~21:00에서 0:00~24:00으로 변경되었음을 안내드립니다.");
        adapter.addItem("KUsuk", "2022-05-05", "안녕하세요. KUsuk을 개발한 김기환, 이슬, 최지현입니다. KUsuk은 석원경상관 실시간 팀플룸예약 어플리케이션입니다.");

        adapter.notifyDataSetChanged(); //어댑터의 변경을 알림.

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ReservationMain.class);
                startActivity(intent);
            }
        });
    }


    public void reservation_floor3_count(){
        int i;
        for(i=1; i<=7; i++) {
            String table = "table30" + i;
            database3.child(table).child("ID").addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    String value = datasnapshot.getValue(String.class);
                    if (value != null){
                        floor3_count++;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }

    public void reservation_floor4_count(){
        int i;
        for(i=1; i<=7; i++) {
            String table = "table40" + i;
            database4.child(table).child("ID").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    String value = datasnapshot.getValue(String.class);
                    if (value != null){
                        floor4_count++;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }
}