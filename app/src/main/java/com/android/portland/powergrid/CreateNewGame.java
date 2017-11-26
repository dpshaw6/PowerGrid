package com.android.portland.powergrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by dpsha on 23-Nov-17.
 *
 * This file contains the code for making game parameter selections at the start of a new game.
 */

public class CreateNewGame extends AppCompatActivity {

    private static int MAX_PLAYERS = 6;
    private static int MIN_PLAYERS = 3;

    private int humanCount = 1;
    private int computerCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnewgame);

        final RadioGroup humanRG = findViewById(R.id.humanPlayerCountRadioGroup);
        final RadioGroup computerRG = findViewById(R.id.computerPlayerCountRadioGroup);

        humanRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selectedId) {
                RadioButton humanCountButton = findViewById(selectedId);
                Log.d("HUMAN RG CLICK", String.format("selectedId: %d", selectedId));

                humanCount = Integer.parseInt(humanCountButton.getText().toString());

                int totalCount = humanCount + computerCount;
                if (totalCount > MAX_PLAYERS) {
                    computerCount = MAX_PLAYERS - humanCount;
                } else if (totalCount < MIN_PLAYERS) {
                    computerCount = MIN_PLAYERS - humanCount;
                }
                Log.d("HUMAN RG CLICK", String.format("totalCount: %d", totalCount));
                Log.d("HUMAN RG CLICK", String.format("humanCount: %d", humanCount));
                Log.d("HUMAN RG CLICK", String.format("computerCount: %d", computerCount));
                RadioButton computerCountButton = (RadioButton) computerRG.getChildAt(computerCount);
                computerCountButton.setChecked(true);
            }
        });

        computerRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selectedId) {
                RadioButton computerCountButton = findViewById(selectedId);
                Log.d("COMPUTER RG CLICK", String.format("selectedId: %d", selectedId));

                computerCount = Integer.parseInt(computerCountButton.getText().toString());

                int totalCount = humanCount + computerCount;
                if (totalCount > MAX_PLAYERS) {
                    humanCount = MAX_PLAYERS - computerCount;
                } else if (totalCount < MIN_PLAYERS) {
                    humanCount = MIN_PLAYERS - computerCount;
                }
                Log.d("COMPUTER RG CLICK", String.format("totalCount: %d", totalCount));
                Log.d("COMPUTER RG CLICK", String.format("humanCount: %d", humanCount));
                Log.d("COMPUTER RG CLICK", String.format("computerCount: %d", computerCount));
                RadioButton humanCountButton = (RadioButton) humanRG.getChildAt(humanCount-1);
                humanCountButton.setChecked(true);
            }
        });


    }
}
