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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        floor3_textView = findViewById(R.id.floor3_count);
        floor4_textView = findViewById(R.id.floor4_count);

        floor3_count = reservation_floor3_count();
        floor4_count = reservation_floor4_count();

        floor3_textView.setText(floor3_count + " / 7");
        floor4_textView.setText(floor4_count + " / 7");

        // Adapter 생성
        adapter = new NoticeListAdapter();

        // 리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.noticeListView);
        listview.setAdapter(adapter);
        //listview.setOnItemClickListener(listener);

        adapter.addItem("제목1", "날짜", "내용1");  //(제목 부분, 내용)
        adapter.addItem("제목1", "날짜", "내용1");
        adapter.addItem("제목1", "날짜", "내용1");
        adapter.addItem("제목1", "날짜", "내용1");
        adapter.addItem("제목1", "날짜", "내용1");

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

    public int reservation_floor3_count(){
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference database3 = mRootRef.child("reservation").child("3floor");
        int count = 0;
        int i;
        for(i=1; i<=7; i++) {
            String table = "table30" + i;
            Task<DataSnapshot> id = database3.child(table).child("ID").get();

            if (id != null) {
                count += 1;
            }
        }
        return count;
    }

    public int reservation_floor4_count(){
        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference database4 = mRootRef.child("reservation").child("4floor");
        int count = 0;
        int i;
        for(i=1; i<=7; i++) {
            String table = "table40" + i;
            Task<DataSnapshot> id = database4.child(table).child("ID").get();

            if (id != null) {
                count += 1;
            }
        }
        return count;
    }

}