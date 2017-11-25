package com.android.portland.powergrid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void createNewGame(View view) {
        Intent intent = new Intent(this, CreateNewGame.class);
        startActivity(intent);
    }
}
