package com.example.click_die;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.click_die.DiceConstants;
import com.example.click_die.DiceRoller;

public class MainActivity extends AppCompatActivity {

    private DiceRoller diceRoller;
    ImageView[] diceViews;

    ImageView dieOneView;
    ImageView dieTwoView;
    ImageView dieThreeView;
    ImageView dieFourView;
    ImageView dieFiveView;

    Button rollButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceRoller = new DiceRoller();
        diceViews = new ImageView[DiceConstants.NUM_DICE];

        setupButtons();
        setupImageViews();

    }

    private void setupButtons(){
        rollButton = findViewById(R.id.rollBtn);

        rollButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                diceRoller.rollDice();
                changeDiceImages();

            }
        });
    }

    private void setupImageViews() {
        dieOneView = findViewById(R.id.dieOneView);
        dieTwoView = findViewById(R.id.dieTwoView);
        dieThreeView = findViewById(R.id.dieThreeView);
        dieFourView = findViewById(R.id.dieFourView);
        dieFiveView = findViewById(R.id.dieFiveView);

        diceViews[0] = dieOneView;
        diceViews[1] = dieTwoView;
        diceViews[2] = dieThreeView;
        diceViews[3] = dieFourView;
        diceViews[4] = dieFiveView;
    }

    private int getDrawableDiceId(int number) {
        String name = "die" + number;
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }

    private void changeDiceImages() {
        for(int i = 0; i < DiceConstants.NUM_DICE; i++) {
            diceViews[i].setImageResource(getDrawableDiceId(
                    diceRoller.getDice()[i].getDieResult()
            ));
        }
    }
}
