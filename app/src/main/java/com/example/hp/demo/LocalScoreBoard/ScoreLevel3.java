package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;

public class ScoreLevel3 extends AppCompatActivity {

    DbHelper dbHelper = new DbHelper(this);
    TextView s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevel3);
        setTitle("Hardware Score");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int hwB, hwI, hwE;
        hwB=hwI=hwE=0;
        hwB=dbHelper.getScoreHardwareB();
        hwI=dbHelper.getScoreHardwareI();
        hwE=dbHelper.getScoreHardwareE();
        s1=(TextView)findViewById(R.id.st1);
        s2=(TextView)findViewById(R.id.st2);
        s3=(TextView)findViewById(R.id.st3);
        if(hwB<10)
        {
            s1.setText("0"+ hwB);
        }
        else
        {
            s1.setText(""+ hwB);
        }
        if(hwI<10)
        {
            s2.setText("0"+ hwI);
        }
        else
        {
            s2.setText(""+ hwI);
        }
        if(hwE<10)
        {
            s3.setText("0"+ hwE);
        }
        else
        {
            s3.setText(""+ hwE);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
