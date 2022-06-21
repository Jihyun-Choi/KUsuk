package com.korea.kusuk;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;


public class floor3 extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference database = mRootRef.child("reservation").child("3floor");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();
    private Button table301, table302, table303, table304, table305, table306, table307;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_floor3);
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String getNow = dateFormat.format(now);

        table301 = (Button) findViewById(R.id.table301);
        table302 = (Button) findViewById(R.id.table302);
        table303 = (Button) findViewById(R.id.table303);
        table304 = (Button) findViewById(R.id.table304);
        table305 = (Button) findViewById(R.id.table305);
        table306 = (Button) findViewById(R.id.table306);
        table307 = (Button) findViewById(R.id.table307);


        int i;
        for(i=1; i<=7; i++) {
            String table = "table30" + i;
            int finalI = i;
            database.child(table).child("ID").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                    String value = datasnapshot.getValue(String.class);
                    String test = "0";
                    int count = finalI;
                    if(uid.equals(value)){
                        if(count==1)table301.setBackgroundColor(Color.RED);
                        if(count==2)table302.setBackgroundColor(Color.RED);
                        if(count==3)table303.setBackgroundColor(Color.RED);
                        if(count==4)table304.setBackgroundColor(Color.RED);
                        if(count==5)table305.setBackgroundColor(Color.RED);
                        if(count==6)table306.setBackgroundColor(Color.RED);
                        if(count==7)table307.setBackgroundColor(Color.RED);
                    }
                    else
                    {
                        if(count==1)table301.setBackgroundColor(Color.GREEN);
                        if(count==2)table302.setBackgroundColor(Color.GREEN);
                        if(count==3)table303.setBackgroundColor(Color.GREEN);
                        if(count==4)table304.setBackgroundColor(Color.GREEN);
                        if(count==5)table305.setBackgroundColor(Color.GREEN);
                        if(count==6)table306.setBackgroundColor(Color.GREEN);
                        if(count==7)table307.setBackgroundColor(Color.GREEN);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    int count2 = finalI;;
                    if(count2==1)table301.setBackgroundColor(Color.GREEN);
                    if(count2==2)table302.setBackgroundColor(Color.GREEN);
                    if(count2==3)table303.setBackgroundColor(Color.GREEN);
                    if(count2==4)table304.setBackgroundColor(Color.GREEN);
                    if(count2==5)table305.setBackgroundColor(Color.GREEN);
                    if(count2==6)table306.setBackgroundColor(Color.GREEN);
                    if(count2==7)table307.setBackgroundColor(Color.GREEN);

                }
            });
        }



        table301.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        String getNow = dateFormat.format(now);

                        database.child("table301").child("starttime").setValue(getNow );
                        database.child("table301").child("finishtime").setValue(getTime);
                        database.child("table301").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });

        table302.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table302").child("starttime").setValue(getNow );
                        database.child("table302").child("finishtime").setValue(getTime);
                        database.child("table302").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });


        table303.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table303").child("starttime").setValue(getNow );
                        database.child("table303").child("finishtime").setValue(getTime);
                        database.child("table303").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });

        table304.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table304").child("starttime").setValue(getNow );
                        database.child("table304").child("finishtime").setValue(getTime);
                        database.child("table304").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });

        table305.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table305").child("starttime").setValue(getNow );
                        database.child("table305").child("finishtime").setValue(getTime);
                        database.child("table305").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });


        table306.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table306").child("starttime").setValue(getNow );
                        database.child("table306").child("finishtime").setValue(getTime);
                        database.child("table306").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });

        table307.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor3.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7200000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);
                        database.child("table307").child("starttime").setValue(getNow );
                        database.child("table307").child("finishtime").setValue(getTime);
                        database.child("table307").child("ID").setValue(uid);
                    }
                });
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                ad.show();

            }

        });
    }
}
