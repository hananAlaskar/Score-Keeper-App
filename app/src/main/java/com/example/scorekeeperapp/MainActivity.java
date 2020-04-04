package com.example.scorekeeperapp;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @BindView(R.id.team_one_increase_points_btn)
    protected Button mTeamOneIncreasePoints_btn;

    @BindView(R.id.team_one_increase_fouls_btn)
    protected Button mTeamOneIncreaseFouls_btn;

    @BindView(R.id.team_two_increase_points_btn)
    protected Button mTeamTwoIncreasePoints_btn;

    @BindView(R.id.team_two_increase_fouls_btn)
    protected Button mTeamTwoIncreaseFouls_btn;

    @BindView(R.id.reset_btn)
    protected Button mReset_btn;

    @BindView(R.id.team_one_points_value)
    protected TextView mTeamOnePoints_tv;

    @BindView(R.id.team_one_fouls_value)
    protected TextView mTeamOneFouls_tv;

    @BindView(R.id.team_two_points_value)
    protected TextView mTeamTwoPoints_tv;

    @BindView(R.id.team_two_fouls_value)
    protected TextView mTeamTwoFouls_tv;


    private int mTeamOnePoints;
    private int mTeamOneFouls;
    private int mTeamTwoPoints;
    private int mTeamTwoFouls;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        addClickListener();
    }

    private void addClickListener() {

        mTeamOneIncreasePoints_btn.setOnClickListener(this);
        mTeamOneIncreaseFouls_btn.setOnClickListener(this);
        mTeamTwoIncreasePoints_btn.setOnClickListener(this);
        mTeamTwoIncreaseFouls_btn.setOnClickListener(this);
        mReset_btn.setOnClickListener(this);

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

        mTeamOnePoints_tv.setText(String.valueOf(mTeamOnePoints));
    }

    private void updateTeamOneFoulsView() {
       mTeamOneFouls_tv.setText(String.valueOf(mTeamOneFouls));
    }

    private void updateTeamTwoPointsView() {
        mTeamTwoPoints_tv.setText(String.valueOf(mTeamTwoPoints));
    }

    private void updateTeamTwoFoulsView() {
        mTeamTwoFouls_tv.setText(String.valueOf(mTeamTwoFouls));
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
