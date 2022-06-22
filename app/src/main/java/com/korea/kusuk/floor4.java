package com.korea.kusuk;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class floor4 extends AppCompatActivity {
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference database = mRootRef.child("reservation").child("4floor");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid = user.getUid();

    private Button table401, table402, table403, table404, table405, table406, table407;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_floor4);

        table401 = (Button) findViewById(R.id.table401);
        table402 = (Button) findViewById(R.id.table402);
        table403 = (Button) findViewById(R.id.table403);
        table404 = (Button) findViewById(R.id.table404);
        table405 = (Button) findViewById(R.id.table405);
        table406 = (Button) findViewById(R.id.table406);
        table407 = (Button) findViewById(R.id.table407);

        table401.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table401").child("finishtime").setValue(getTime);
                        database.child("table401").child("ID").setValue(uid);
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

        table402.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table402").child("finishtime").setValue(getTime);
                        database.child("table401").child("ID").setValue(uid);
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

        table403.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table403").child("finishtime").setValue(getTime);
                        database.child("table403").child("ID").setValue(uid);
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

        table404.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table404").child("finishtime").setValue(getTime);
                        database.child("table404").child("ID").setValue(uid);
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

        table405.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table405").child("finishtime").setValue(getTime);
                        database.child("table405").child("ID").setValue(uid);
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

        table406.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table406").child("finishtime").setValue(getTime);
                        database.child("table406").child("ID").setValue(uid);
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

        table407.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder ad = new AlertDialog.Builder(floor4.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("KuSuk 자리예약 시스템");
                ad.setMessage("예약하시겠습니까?");

                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        long now = System.currentTimeMillis();
                        Date date = new Date(now+7000000);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
                        String getTime = dateFormat.format(date);

                        database.child("table407").child("finishtime").setValue(getTime);
                        database.child("table407").child("ID").setValue(uid);
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
