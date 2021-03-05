package com.example.korisnik.rehab;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.korisnik.rehab.klase.BazaPodataka;
import com.example.korisnik.rehab.klase.Logika;
import com.example.korisnik.rehab.klase.Manager;

import static com.example.korisnik.rehab.R.drawable.*;

/**
 * Created by Manche on 25-May-17.
 */

public class Achievments extends AppCompatActivity {
    private ImageButton homebtn;
    private ImageButton motivationsbtn;
    private ImageButton progressbtn;
    private ImageButton krizabtn;
    private ImageButton gamebtn;
    private ImageView cetristotina;
    private BazaPodataka baza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achivments);
        cetristotina = (ImageView) findViewById(R.id.imageView1);
        homebtn = (ImageButton) findViewById(R.id.btnHome);
        baza = BazaPodataka.getInstance(this);

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
        //dodeliAchievment();
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

    private void launchKrizaActivity (){

        Intent intent = new Intent(this, Kriza.class);
        startActivity(intent);
    }
    private void dodeliAchievment()
    {
        Logika logika = new Logika();
        String u = logika.kolikoJeUstedeo(baza);
        int kolikoU = Integer.parseInt(u);
        if(kolikoU > 400) {
        ///baca exception nece nece nece!!!!

        }

    }
}
