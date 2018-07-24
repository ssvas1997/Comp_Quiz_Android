package com.example.hp.demo.LocalScoreBoard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.R;


public class ScoreLevelFinal extends AppCompatActivity {
    DbHelper dbHelper = new DbHelper(this);
    TextView s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorelevelfinal);
        setTitle("Finale Score");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        s1=(TextView)findViewById(R.id.st);
        int finalScore=0;
        finalScore=dbHelper.getScoreRandom();
        if(finalScore<10)
        {
            s1.setText("0"+ finalScore);
        }
        else
        {
            s1.setText(""+ finalScore);
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
