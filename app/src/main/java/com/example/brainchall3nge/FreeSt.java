package com.example.brainchall3nge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class FreeSt extends AppCompatActivity {
    TableLayout board;
    TableLayout top;
    TextView timer;
    TextView score;
    TextView scoreboard;
    public boolean lose = false;
    public boolean win = false;
    public int rounds = 0;
    public int time = 0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    TextView heart;
    public int option1;
    public int option2;
    public int option3;
    public int option4;
    public int a;
    public int min=0;
    public String seconds;
    public String minutes;
    public int b;
    public int solution;
    public int whichCorrect;
    public int points = 0;
    public int chance = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_st);

    }
    public void check4123321(View view){
        if (whichCorrect == 4){
            points+=1;
        }
        else{
            chance = chance -1;
            if (chance == 0){
                lose = true;
            }
        }
        //newRound();
    }
}
