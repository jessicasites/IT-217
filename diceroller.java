package com.example.click_die;

import com.example.click_die.DiceConstants;
import com.example.click_die.Die;

import java.util.Random;

public class DiceRoller {

    private Die[] dice;
    private Random rand;

    public DiceRoller(){
        dice = new Die[DiceConstants.NUM_DICE];
        dice[0] = new Die();
        dice[1] = new Die();
        dice[2] = new Die();
        dice[3] = new Die();
        dice[4] = new Die();
        rand = new Random();

        rollDice();
    }

    public int generateRandomNumber(){
        return rand.nextInt(6) + 1;
    }

    public void rollDice() {
        for(int i = 0; i < DiceConstants.NUM_DICE; i++) {
            dice[i].setDieResult(generateRandomNumber());
        }
    }

    public Die[] getDice() {
        return dice;
    }
}
