package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageView computerRespo , playerRespo ;
    Button bscissors , bpaper , brock ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computerRespo = (ImageView) findViewById(R.id.computerResponse);
        playerRespo = (ImageView)  findViewById(R.id.playerResponse);
        bscissors = (Button) findViewById(R.id.buttonScissors);
        bpaper = (Button) findViewById(R.id.buttonPaper);
        brock = (Button) findViewById(R.id.buttonRock);

        bscissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.scissors);
                computermove("scissors");
            }
        });


        bpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.paper);
                computermove("paper");
            }
        });

        brock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerRespo.setImageResource(R.drawable.rock);
                computermove("rock");
            }
        });
    }

    public void computermove(String playermove){
       String compmove = "" ;
        Random n = new Random();
        int randnum = n.nextInt(3) + 1 ;
        if (randnum == 1){
            compmove = " paper";
        } else if (randnum == 2){
            compmove = "rock";
        } else {
            compmove = " scissors";
        }
        if (compmove.equals(" scissors")){
            computerRespo.setImageResource(R.drawable.scissors);
        } else if (compmove.equals("paper")){
            computerRespo.setImageResource(R.drawable.paper);
        } else if (compmove.equals("rock")){
            computerRespo.setImageResource(R.drawable.rock);
        }
        String msg = "";
        if (compmove == "scissors" && playermove == "paper"){
            msg = "you lose";
        }
        if (compmove == "scissors" && playermove == "rock"){
            msg = "you win";
        }
        if (compmove == "scissors" && playermove == "scissors"){
            msg = " Draw";
        }
        if (compmove == "rock" && playermove == "paper"){
            msg = "you win";
        }
        if (compmove == "rock" && playermove == "rock"){
            msg = "Draw";
        }
        if (compmove == "rock" && playermove == "scissors"){
            msg = " You lose";
        }
        if (compmove == "paper" && playermove == "paper"){
            msg = "Draw";
        }
        if (compmove == "paper" && playermove == "rock"){
            msg = "You lose";
        }
        if (compmove == "paper" && playermove == "scissors"){
            msg = " You win";
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

}