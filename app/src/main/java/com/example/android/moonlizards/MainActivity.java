package com.example.android.moonlizards;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LizardViewModel mLizardViewModel;

    public static final int NEW_LIZARD_REQUEST_CODE = 1;

    // some integers for adjusting stats
    public final int STAT_MAX = 100;
    public final int STAT_MIN = 0;
    public final int STAT_20 = 20;
    public final int STAT_10 = 10;
    public final int STAT_5 = 5;
    public final int STAT_3 = 3;
    public final int STAT_2 = 2;
    public final int STAT_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLizardViewModel = ViewModelProviders.of(this).get(LizardViewModel.class);

        mLizardViewModel.getAllLizards().observe(this, new Observer<List<Lizard>>() {
            @Override
            public void onChanged(@Nullable final List<Lizard> lizards) {
                updateCage();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLizard();
            }
        });
    }

    public void addLizard() {

        String name = "lizard" + ((int) Math.ceil(Math.random() * 100));
        int ageStatus = STAT_MIN;
        int fedStatus = 25;
        int restedStatus = 25;
        int cleanedStatus = 60;
        int happyStatus = 60;
        float ageMulti = (float) (Math.random() + .75) * 4;
        int fedMulti = STAT_3;
        int restedMulti = STAT_3;
        int cleanedMulti = STAT_3;
        int happyMulti = STAT_1;
        int ageCount = STAT_MIN;
        int poopCount = STAT_MIN;
        int dirtyCount = STAT_MIN;
        int mendingCount = STAT_MIN;
        int dyingCount = STAT_MIN;
        int posBenchCount = STAT_MIN;
        int negBenchCount = STAT_MIN;
        boolean isSleeping = false;
        boolean isSick = false;
        boolean isLit = true;
        boolean hadMedicine = false;


        Lizard lizard = new Lizard(name, fedStatus, restedStatus, cleanedStatus,
                happyStatus, ageMulti, ageCount);
        mLizardViewModel.insert(lizard);

    }

    public void updateCage() {
        // TODO update... the cage?
    }
}