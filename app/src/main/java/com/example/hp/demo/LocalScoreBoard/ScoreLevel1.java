package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel1 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel1);
        setTitle("Fundamentals Score");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int compFundaB,compFundaI,compFundaE;
        compFundaB=compFundaI=compFundaE=0;
        compFundaB=dbHelper.getScoreCompFundaB();
        compFundaI=dbHelper.getScoreCompFundaI();
        compFundaE=dbHelper.getScoreCompFundaE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(compFundaB<10)
        {
            s1.setText("0"+ compFundaB);
        }
        else
        {
            s1.setText(""+ compFundaB);
        }
        if(compFundaI<10)
        {
            s2.setText("0"+ compFundaI);
        }
        else
        {
            s2.setText(""+ compFundaI);
        }
        if(compFundaE<10)
        {
            s3.setText("0"+ compFundaE);
        }
        else
        {
            s3.setText(""+ compFundaE);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
