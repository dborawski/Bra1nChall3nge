package com.example.brainchall3nge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;

public class Freestyle extends AppCompatActivity{
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
    public boolean isPaused = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freestyle);
        heart = findViewById(R.id.chances);
        board = findViewById(R.id.BoardTable);
        top = findViewById(R.id.infoTable);
        timer = findViewById(R.id.time);
        score = findViewById(R.id.score);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        scoreboard = findViewById(R.id.question);
        startGame();
    }
    public void mainMenu(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void pauseGame(View view){
        if (!isPaused){
            isPaused = true;
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
        }else{
            isPaused = false;
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);

        }
        clock();
    }
    public void startGame (){
        if (!win && !lose){
            displayHearts();
            newRound();
            clock();
        }
        else{
            //
        }

    }
    public void winGame(){
        String text = "You win!";
        scoreboard.setText(text);
        win = true;
        String again = "Play again";
    }
    /*
    public void playAgain(View view){
        win = false;
        lose = false;
        time = 0;
        rounds = 0;
        chance = 3;
        min = 0;
        startGame(view);
    }*/
    public void displayHearts(){
        switch(chance){
            case 0:
                heart.setText("");
                break;
            case 1:
                heart.setText("♥");
                break;
            case 2:
                heart.setText("♥♥");
                break;
            case 3:
                heart.setText("♥♥♥");
                break;
        }
    }
    public void newRound(){
        if(!lose){
                if (minutes == "03" && seconds == "00"){
                   winGame();
                }
                else{
                    randomize();
                    rounds++;
                    String display = "" + rounds + "/∞";
                    score.setText(display);
                }

        }
        else{
            //
        }
        displayHearts();
    }
    public void clock(){
        final Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                if (!isPaused){
                    time = time + 1;
                    if (time == 60){
                        min++;
                        time=0;
                    }
                    if (time < 10){
                        seconds = ":0"+time;
                    }
                    if (time > 10){
                        seconds = ":"+time;
                    }
                    if (min < 10){
                        minutes = "0"+min;
                    }
                    if (min > 10){
                        minutes = ""+min;
                    }
                    String inc = minutes + seconds;
                    timer.setText(inc);
                    if (lose || win){
                        handler.removeCallbacks(this);
                        return;
                    }
                    handler.postDelayed(this, 1000);
                }

            }
        };
        handler.post(run);
    }
    public void randomize(){
        Random rand = new Random();
        option1 = rand.nextInt(100)+1;
        option2 = rand.nextInt(100)+1;
        option3 = rand.nextInt(100)+1;
        option4 = rand.nextInt(100)+1;
        a = rand.nextInt(10)+1;
        b = rand.nextInt(10)+1;
        solution = a*b;
        whichCorrect = rand.nextInt(4)+1;
        String text1, text2, text3, text4;
        text1 = ""+option1;
        text2 = ""+option2;
        text3 = ""+option3;
        text4 = ""+option4;
        if (whichCorrect == 1){text1 = ""+solution;}
        else if (whichCorrect == 2){text2 = ""+solution;}
        else if (whichCorrect == 3){text3 = ""+solution;}
        else if (whichCorrect == 4){text4 = ""+solution;}
        btn1.setText(text1);
        btn2.setText(text2);
        btn3.setText(text3);
        btn4.setText(text4);
        String text = a + "*" + b;
        scoreboard.setText(text);
    }
    public void check1(View view){
        if (whichCorrect == 1){
            points+=1;
        }
        else{
            chance = chance -1;
            if (chance == 0){
                lose = true;
            }
        }
        newRound();
    }
    public void check2(View view){
        if (whichCorrect == 2){
            points+=1;
        }
        else{
            chance = chance -1;
            if (chance == 0){
                lose = true;
            }
        }
        newRound();
    }
    public void check3(View view){
        if (whichCorrect ==3){
            points+=1;
        }
        else{
            chance = chance -1;
            if (chance == 0){
                lose = true;
            }
        }
        newRound();
    }
    public void check4(View view){
        if (whichCorrect == 4){
            points+=1;
        }
        else{
            chance = chance -1;
            if (chance == 0){
                lose = true;
            }
        }
        newRound();
    }
}
