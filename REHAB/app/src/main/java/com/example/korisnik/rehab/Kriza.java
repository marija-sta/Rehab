package com.example.korisnik.rehab;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.korisnik.rehab.klase.Manager;

/**
 * Created by Manche on 25-May-17.
 */

public class Kriza extends AppCompatActivity {
    private ImageButton homebtn;
    private ImageButton motivationsbtn;
    private ImageButton progressbtn;
    private ImageButton achievementsbtn;
    private ImageButton gamebtn;
    private ImageButton krizakrizabtn;
    public static int brojac = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kriza);

        homebtn = (ImageButton) findViewById(R.id.btnHome);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchHomeActivity();
            }
        });

        motivationsbtn = (ImageButton) findViewById(R.id.btnMotivations);

        motivationsbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                launchMotivationsActivity();
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

        achievementsbtn = (ImageButton) findViewById(R.id.btnAchievements);

        achievementsbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                launchAchievementsActivity();
            }
        });
        gamebtn = (ImageButton) findViewById(R.id.btnGame);
        gamebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                launchGameActivity();
            }
        });
        krizakrizabtn = (ImageButton) findViewById(R.id.btnRed);
        krizakrizabtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                krizira();//sta da radiiiiiiimmmmm kad odu prijatelji moji
            }
        });
    }
    private void launchGameActivity() {
        Intent intent = new Intent(this, Manager.class);
        startActivity(intent);
    }
    private void launchHomeActivity() {

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private void launchMotivationsActivity() {

        Intent intent = new Intent(this, Motivations.class);
        startActivity(intent);
    }


    private void launchProgressActivity(){

        Intent intent = new Intent(this, Progress.class);
        startActivity(intent);
    }

    private void launchAchievementsActivity (){

        Intent intent = new Intent(this, Achievments.class);
        startActivity(intent);
    }
    private void krizira(){
        Resources res = getResources();
        String [] saveti = res.getStringArray(R.array.saveti);
        AlertDialog.Builder  b = new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle("Savet " + brojac);
        b.setMessage(saveti[brojac]);
        brojac++;
        brojac = brojac % 5;
        b.show();

    }
}
