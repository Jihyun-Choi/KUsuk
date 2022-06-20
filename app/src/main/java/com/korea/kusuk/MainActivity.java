package com.korea.kusuk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ListView listview ;
    private NoticeListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

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

}