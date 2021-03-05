package com.example.korisnik.rehab;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.korisnik.rehab.klase.BazaPodataka;
import com.example.korisnik.rehab.klase.Logika;
import com.example.korisnik.rehab.klase.Manager;

/**
 * Created by Manche on 25-May-17.
 */

public class Progress extends AppCompatActivity {

    private ImageButton homebtn;
    private ImageButton motivationsbtn;
    private ImageButton achievementsbtn;
    private ImageButton krizabtn;
    private TextView ustedjennovac;
    private ImageButton gamebtn;
    private TextView proteklovremeprogreslbl;
    private ProgressBar healthProgress;
    private int statusProgresa = 0;
    private Handler handler1 = new Handler();
    private TextView textZdravlje;
    private ProgressBar conditionProgress;
    private int statusKondicije = 0;
    private Handler handler2 = new Handler();
    private TextView textKondicija;
    private ProgressBar lungsProgress;
    private int statusPluca = 0;
    private Handler handler3 = new Handler();
    private TextView textPluca;

    private BazaPodataka baza = BazaPodataka.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress);
        ustedjennovac = (TextView) findViewById(R.id.ustedjen_novac_lbl);
        proteklovremeprogreslbl = (TextView) findViewById(R.id.proteklo_vreme_progres_lbl);
        healthProgress = (ProgressBar) findViewById(R.id.progressBarHealth);
        conditionProgress = (ProgressBar) findViewById(R.id.progressBarKondicija);
        lungsProgress = (ProgressBar) findViewById(R.id.progressBarPluca);
        textZdravlje = (TextView) findViewById(R.id.textZdravlje);
        textKondicija = (TextView) findViewById(R.id.textKondicija);
        textPluca = (TextView) findViewById(R.id.textPluca);


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

        achievementsbtn = (ImageButton) findViewById(R.id.btnAchievements);

        achievementsbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                launchAchievementsActivity();
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

        usteda();
        vreme();
        statusZdravlja();
        statusPluca();
        statusKondicije();
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


    private void launchAchievementsActivity(){

        Intent intent = new Intent(this, Achievments.class);
        startActivity(intent);
    }

    private void launchKrizaActivity (){

        Intent intent = new Intent(this, Kriza.class);
        startActivity(intent);
    }
    private void usteda()
    {
        Logika logprog = new Logika();
        ustedjennovac.setText(logprog.kolikoJeUstedeo(baza));
    }
    private void vreme()
    {
        Logika logika= new Logika();
        String dani = logika.protekloVreme(baza);
        String sati = logika.protekloVremeSati(baza);
        String lbl = dani + " dana i " + sati + " sati";
        proteklovremeprogreslbl.setText(lbl);
    }
    private void statusZdravlja()
    {
        final Logika logika = new Logika();
        new Thread(new Runnable(){
            public void run(){
                if(statusProgresa < 100)
                {
                    String dani = logika.protekloVreme(baza);
                    int dan = Integer.parseInt(dani);
                    for(int i = 0; i<dan; i++)
                        statusProgresa= statusProgresa + 1;
                    handler1.post(new Runnable(){
                        public void run(){
                            healthProgress.setProgress(statusProgresa);
                            textZdravlje.setText("Ukupno vase zdravlje " + statusProgresa + "%");
                        }
                    });
                }
            }
        }).start();
    }
    public void statusKondicije()
    {
        final Logika logika = new Logika();
        new Thread(new Runnable(){
            public void run(){
                if(statusKondicije < 100)
                {
                    String dani = logika.protekloVreme(baza);
                    int dan = Integer.parseInt(dani);
                    for(int i = 0; i<dan; i++)
                        statusKondicije= statusKondicije + 3;
                    handler2.post(new Runnable(){
                        public void run(){
                            conditionProgress.setProgress(statusKondicije);
                            textKondicija.setText("Stanje vase kondicije " + statusKondicije + "%");
                        }
                    });
                }
            }
        }).start();
    }
    public void statusPluca()
    {
        final Logika logika = new Logika();
        new Thread(new Runnable(){
            public void run(){
                if(statusPluca < 100)
                {
                    String dani = logika.protekloVreme(baza);
                    int dan = Integer.parseInt(dani);
                    for(int i = 0; i<dan; i++)
                        statusPluca= statusPluca + 4;
                    handler3.post(new Runnable(){
                        public void run(){
                            lungsProgress.setProgress(statusPluca);
                            textPluca.setText("Stanje vasih pluca " + statusPluca + "%");
                        }
                    });
                }
            }
        }).start();
    }

}
