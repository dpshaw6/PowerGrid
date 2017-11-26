package com.android.portland.powergrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by dpsha on 23-Nov-17.
 */

public class CreateNewGame extends AppCompatActivity {

    private static int MAX_PLAYERS = 6;
    private static int MIN_PLAYERS = 3;

    private int humanCount = 1;
    private int computerCount = 0;
    private int totalCount = humanCount + computerCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnewgame);

        final RadioGroup humanRG = (RadioGroup) findViewById(R.id.humanPlayerCountRadioGroup);
        humanRG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = humanRG.getCheckedRadioButtonId();
                RadioButton humanCountButton = (RadioButton) findViewById(selectedId);

                humanCount = Integer.parseInt(humanCountButton.getText().toString());

                int newTotalCount = humanCount + computerCount;
                if (newTotalCount > MAX_PLAYERS) {
                    computerCount = MAX_PLAYERS - humanCount;
                }
            }
        });

        RadioGroup computerRG = (RadioGroup) findViewById(R.id.computerPlayerCountRadioGroup);


    }
}
