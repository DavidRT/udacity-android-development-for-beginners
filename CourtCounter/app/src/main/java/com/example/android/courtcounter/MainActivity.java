package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void threePointsToTeamA(View view) {
        scoreTeamA+=3;
        displayForTeamA();
    }

    public void twoPointsToTeamA(View view) {
        scoreTeamA+=2;
        displayForTeamA();
    }

    public void freeThrowToTeamA(View view) {
        scoreTeamA++;
        displayForTeamA();
    }

    public void threePointsToTeamB(View view) {
        scoreTeamB+=3;
        displayForTeamB();
    }

    public void twoPointsToTeamB(View view) {
        scoreTeamB+=2;
        displayForTeamB();
    }

    public void freeThrowToTeamB(View view) {
        scoreTeamB++;
        displayForTeamB();
    }

    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA();
        displayForTeamB();
    }


}
