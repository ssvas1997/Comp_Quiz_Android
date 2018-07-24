package com.example.hp.demo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hp.demo.DbHelper.DbHelper;
import com.example.hp.demo.Model.QuestionCompFunda;
import com.example.hp.demo.Model.QuestionRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2ActivityFinal extends AppCompatActivity {

    List<QuestionRandom> quesList1;
    public int score=0;
    int ctr1=1;
    QuestionRandom currentQ1;
    TextView txtQuestion1;
    RadioGroup grp;
    RadioButton rda1, rdb1, rdc1, rdd1;
    Button butNext1;
    Random random1 = new Random();
    ArrayList<Integer> list = new ArrayList<Integer>();
    TextView textViewTime1;
    public ArrayList<String> wrongQuestListRandom= new ArrayList<String>();
    public ArrayList<String> selectedAnsRandom = new ArrayList<String>();
    public ArrayList<String> actualAnswerRandom = new ArrayList<String>();
    int number;
    ProgressBar progressBar;
    int progress = 1;
    String tableName="";
    TextView qstnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_final);
        qstnNo = (TextView)findViewById(R.id.qstnNo);
        Intent iin=getIntent();
        Bundle b=iin.getExtras();

        if(b!=null){
            tableName=(String)b.get("table_name");
            Log.d("Table Name",tableName);
        }
        number=0;
        DbHelper db= new DbHelper(this);
        textViewTime1 = (TextView)findViewById(R.id.textViewTime);
        final CounterClass timer = new CounterClass(1800000, 1000);
        timer.start();
        quesList1=db.getAllQuestions3(tableName);
        for(int i=0;i<300;i++){
            while(true){
                int next = random1.nextInt(300);
                if(!list.contains(next))
                {
                    list.add(next);
                    break;
                }
            }
        }
        currentQ1=quesList1.get(list.get(0));
        txtQuestion1=(TextView)findViewById(R.id.textView1);
        rda1=(RadioButton)findViewById(R.id.radio0);
        rdb1=(RadioButton)findViewById(R.id.radio1);
        rdc1=(RadioButton)findViewById(R.id.radio2);
        rdd1=(RadioButton)findViewById(R.id.radio3);
        butNext1=(Button)findViewById(R.id.button1);
        setQuestionView();
        grp = (RadioGroup) findViewById(R.id.radioGroup1);
        butNext1.setEnabled(false);
        grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i== R.id.radio0 || i == R.id.radio1 || i==R.id.radio2 || i == R.id.radio3)
                    butNext1.setEnabled(true);
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(30);
        progressBar.setProgress(1);
        butNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = progress+1;
                progressBar.setProgress(progress);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                //Log.d("yourans", currentQ1.getANSWER1() + " " + answer.getText());
                if (currentQ1.getANSWER3().equals(answer.getText())) {
                    score++;
                    //Log.d("score", "Your score" + score1);
                }
                else
                {
                    wrongQuestListRandom.add(number, currentQ1.getQUESTION3());
                    selectedAnsRandom.add(number, answer.getText().toString());
                    actualAnswerRandom.add(number, currentQ1.getANSWER3());
                    number++;
                }
                grp.clearCheck();
                butNext1.setEnabled(false);
                if (ctr1 < 31) {
                    if (ctr1 == 30) {
                        butNext1.setText("End Test");
                    }
                    currentQ1 = quesList1.get(list.get(ctr1));
                    setQuestionView();
                } else {
                    timer.onFinish();
                    timer.cancel();
                }
            }
        });
    }
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            textViewTime1.setText(hms);
        }

        @Override
        public void onFinish() {
            showResult();
        }
    }
    public void showResult(){
        Intent intent = new Intent(Main2ActivityFinal.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("scoreRandom", score);//Your score
        b.putString("section",tableName);//Your table name
        b.putString("category",null);//Your category name
        intent.putStringArrayListExtra("wrongQuestions", wrongQuestListRandom);
        intent.putStringArrayListExtra("selectedAnswer", selectedAnsRandom);
        intent.putStringArrayListExtra("actualAnswer", actualAnswerRandom);
        intent.putExtras(b); //Put your score to your next Intent
        startActivity(intent);
        finish();
    }
    private void setQuestionView(){
        txtQuestion1.setText(currentQ1.getQUESTION3());
        rda1.setText(currentQ1.getOPTA3());
        rdb1.setText(currentQ1.getOPTB3());
        rdc1.setText(currentQ1.getOPTC3());
        rdd1.setText(currentQ1.getOPTD3());
        if(ctr1<10)
            qstnNo.setText("0" + ctr1 + "/30");
        else
            qstnNo.setText("" + ctr1+ "/30");
        ctr1++;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Uncomment the below code to Set the message and title from the strings.xml file
        //builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

        //Setting message manually and performing action on button click
        builder.setMessage("If you close all your progress would not be saved... Do you wish to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });

        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        // alert.setTitle("CompQuiz");
        alert.show();
    }
}
