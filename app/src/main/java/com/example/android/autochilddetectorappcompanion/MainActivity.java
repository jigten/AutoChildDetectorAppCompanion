package com.example.android.autochilddetectorappcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView setup = (TextView) findViewById(R.id.setupView);
        TextView guide = (TextView) findViewById(R.id.guideView);
        TextView kidscars = (TextView) findViewById(R.id.kidscarView);

        setup.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent setupIntent = new Intent(MainActivity.this, SetupActivity.class);
                startActivity(setupIntent);
            }
        });

        guide.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent guideIntent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(guideIntent);
            }
        });

        kidscars.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent kidcarsIntent = new Intent(MainActivity.this, KidsCarsActivity.class);
                startActivity(kidcarsIntent);
            }
        });
    }
}
