package com.example.hp.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.LeaderBoard.LeaderScoreActivity;
import com.example.hp.demo.LocalScoreBoard.ScoreActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_LevelScore extends AppCompatActivity {

    LinearLayout yourScore;
    LinearLayout leaderBoard;
    FirebaseAuth mAuth;
    DatabaseReference mUserRefDatabase;
    ChildEventListener mChildEventListener;
    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_score);
        setTitle("Scores");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setAuthInstance();
        setDatabaseInstance();

        int compMarksB=dbHelper.getScoreCompFundaB();
        int compMarksI=dbHelper.getScoreCompFundaI();
        int compMarksE=dbHelper.getScoreCompFundaE();
        int hardwareMarksB=dbHelper.getScoreHardwareB();
        int hardwareMarksI=dbHelper.getScoreHardwareI();
        int hardwareMarksE=dbHelper.getScoreHardwareE();
        int osMarksB=dbHelper.getScoreOSB();
        int osMarksI=dbHelper.getScoreOSI();
        int osMarksE=dbHelper.getScoreOSE();
        int finalMarks=dbHelper.getScoreRandom();

        String userId = mAuth.getCurrentUser().getUid();
        mUserRefDatabase.child("users").child(userId).child("compMarksB").setValue(compMarksB);
        mUserRefDatabase.child("users").child(userId).child("compMarksI").setValue(compMarksI);
        mUserRefDatabase.child("users").child(userId).child("compMarksE").setValue(compMarksE);
        mUserRefDatabase.child("users").child(userId).child("hardwareMarksB").setValue(hardwareMarksB);
        mUserRefDatabase.child("users").child(userId).child("hardwareMarksI").setValue(hardwareMarksI);
        mUserRefDatabase.child("users").child(userId).child("hardwareMarksE").setValue(hardwareMarksE);
        mUserRefDatabase.child("users").child(userId).child("osMarksB").setValue(osMarksB);
        mUserRefDatabase.child("users").child(userId).child("osMarksI").setValue(osMarksI);
        mUserRefDatabase.child("users").child(userId).child("osMarksE").setValue(osMarksE);
        mUserRefDatabase.child("users").child(userId).child("finalMarks").setValue(finalMarks);

        yourScore=(LinearLayout)findViewById(R.id.inter);
        leaderBoard=(LinearLayout)findViewById(R.id.expert);
        yourScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),ScoreActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });

        leaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),LeaderScoreActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });


    }

    private void setAuthInstance() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void setDatabaseInstance() {
        mUserRefDatabase = FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
