package com.example.korisnik.rehab;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.korisnik.rehab.klase.BazaPodataka;
import com.example.korisnik.rehab.klase.Manager;

/**
 * Created by Manche on 25-May-17.
 */

public class Motivations extends AppCompatActivity {
    private ImageButton homebtn;
    private ImageButton achievementsbtn;
    private ImageButton progressbtn;
    private ImageButton krizabtn;
    private TextView lblmot;
    private ImageButton gamebtn;
    private BazaPodataka baza = BazaPodataka.getInstance(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivations);
        lblmot = (TextView) findViewById(R.id.motivacija_lbl);
        homebtn = (ImageButton) findViewById(R.id.btnHome);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchHomeActivity();
            }
        });

        achievementsbtn = (ImageButton) findViewById(R.id.btnAchievements);

        achievementsbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                launchAchievementsActivity();
            }
        });

        progressbtn = (ImageButton) findViewById(R.id.btnProgress);

        progressbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                launchProgressActivity();
            }
        });

        krizabtn = (ImageButton) findViewById(R.id.Xbtn);

        krizabtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchKrizaActivity();
            }
        });

        gamebtn = (ImageButton) findViewById(R.id.btnGame);
        gamebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchGameActivity();
            }
        });
        mojaMotivacija();
    }
    private void launchGameActivity() {
        Intent intent = new Intent(this, Manager.class);
        startActivity(intent);
    }
    private void launchHomeActivity() {

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private void launchAchievementsActivity() {

        Intent intent = new Intent(this, Achievments.class);
        startActivity(intent);
    }


    private void launchProgressActivity(){

        Intent intent = new Intent(this, Progress.class);
        startActivity(intent);
    }

    private void launchKrizaActivity (){

        Intent intent = new Intent(this, Kriza.class);
        startActivity(intent);
    }
    private void mojaMotivacija()
    {
        lblmot.setText("Vas razlog za prestanak pusenja je: " + baza.getRazlog() + " \n NE ODUSTAJTE!!!!");
    }
}
