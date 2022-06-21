package com.korea.kusuk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class ReservationMain extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference database3 = mRootRef.child("reservation").child("3floor");
    DatabaseReference database4 = mRootRef.child("reservation").child("4floor");

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservationmain);

        int i;
        for(i=1; i<=7; i++) {
            String table = "table30"+i;
            Task<DataSnapshot> id = database3.child(table).child("ID").get();
            database3.child(table).child("ID").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    String value = datasnapshot.getValue(String.class);
                    if(uid.equals(value))
                    {
                        Log.v("equals","true");
                        Intent intent = new Intent(getApplicationContext(), reservation_return.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


        Button developer_info_btn = (Button) findViewById(R.id.floor3);
        developer_info_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), floor3.class);
                startActivity(intent);
            }
        });

        Button name_rule_btn = (Button) findViewById(R.id.floor4);
        name_rule_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), floor4.class);
                startActivity(intent);
            }
        });
        Button returnbtn = (Button) findViewById(R.id.test);
        returnbtn. setOnClickListener(new View.OnClickListener(){ // 코드 확인
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), reservation_return.class);
                startActivity(intent);
            }
        });






    }
}