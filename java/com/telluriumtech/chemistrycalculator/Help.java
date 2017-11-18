package com.telluriumtech.chemistrycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
/*
        AdView mAdView = (AdView) findViewById(R.id.banner_AdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        */


        Button helpButton =(Button) findViewById(R.id.help_returnButton);

        helpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

              finish();
              /*  Intent i=new Intent(HomeScreen.this, FirstSynthesisActivity.class);
                startActivity(i);
                */

            }
        });

    }
}
