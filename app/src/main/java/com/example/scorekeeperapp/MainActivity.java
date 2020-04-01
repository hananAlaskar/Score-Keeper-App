package com.example.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private int mTeamOnePoints;
    private int mTeamOneFouls;

    private int mTeamTwoPoints;
    private int mTeamTwoFouls;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInitialValues();
        addClickListener();
    }

    private void getInitialValues() {

        mTeamOnePoints = Integer.parseInt(((TextView)(findViewById(R.id.team_one_points_value))).getText().toString());
        mTeamOneFouls = Integer.parseInt(((TextView)(findViewById(R.id.team_one_fouls_value))).getText().toString());
        mTeamTwoPoints = Integer.parseInt(((TextView)(findViewById(R.id.team_two_points_value))).getText().toString());
        mTeamTwoFouls = Integer.parseInt(((TextView)(findViewById(R.id.team_two_fouls_value))).getText().toString());

    }

    private void addClickListener() {

        findViewById(R.id.team_one_increase_points_btn).setOnClickListener(this);
        findViewById(R.id.team_one_increase_fouls_btn).setOnClickListener(this);
        findViewById(R.id.team_two_increase_points_btn).setOnClickListener(this);
        findViewById(R.id.team_two_increase_fouls_btn).setOnClickListener(this);
        findViewById(R.id.reset_btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.team_one_increase_points_btn:
                increaseTeamOnePoints();
                updateTeamOnePointsView();
                break;
            case R.id.team_one_increase_fouls_btn:
                increaseTeamOneFouls();
                updateTeamOneFoulsView();
                break;
            case R.id.team_two_increase_points_btn:
                increaseTeamTwoPoints();
                updateTeamTwoPointsView();
                break;
            case R.id.team_two_increase_fouls_btn:
                increaseTeamTwoFouls();
                updateTeamTwoFoulsView();
                break;
            case R.id.reset_btn:
                reset();
                break;
        }

    }

    private void updateTeamOnePointsView() {

        ((TextView)(findViewById(R.id.team_one_points_value))).setText(String.valueOf(mTeamOnePoints));
    }

    private void updateTeamOneFoulsView() {
        ((TextView)(findViewById(R.id.team_one_fouls_value))).setText(String.valueOf(mTeamOneFouls));
    }

    private void updateTeamTwoPointsView() {
        ((TextView)(findViewById(R.id.team_two_points_value))).setText(String.valueOf(mTeamTwoPoints));
    }

    private void updateTeamTwoFoulsView() {
        ((TextView)(findViewById(R.id.team_two_fouls_value))).setText(String.valueOf(mTeamTwoFouls));
    }


    private void increaseTeamOnePoints() {
        mTeamOnePoints += 1;
    }

    private void increaseTeamOneFouls() {
        mTeamOneFouls += 1;
    }

    private void increaseTeamTwoPoints() {
        mTeamTwoPoints += 1;
    }

    private void increaseTeamTwoFouls() {
        mTeamTwoFouls += 1;
    }


    private void reset() {

        mTeamOnePoints = 0;
        mTeamOneFouls = 0;

        mTeamTwoPoints = 0;
        mTeamTwoFouls = 0;

        updateTeamOnePointsView();
        updateTeamOneFoulsView();

        updateTeamTwoPointsView();
        updateTeamTwoFoulsView();

    }


}
