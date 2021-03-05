package com.example.korisnik.rehab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TextView;
import com.example.korisnik.rehab.klase.BazaPodataka;
import com.example.korisnik.rehab.klase.Logika;
import com.example.korisnik.rehab.klase.Manager;


public class Home extends AppCompatActivity {

    private ImageButton progressbtn;
    private ImageButton motivationsbtn;
    private ImageButton achievementsbtn;
    private ImageButton krizabtn;
    private BazaPodataka baza;
    private TextView lblbre;
    private Button btnmodifikuj;
    private ImageButton gamebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lblbre = (TextView) findViewById(R.id.proteklovreme_lbl);
        baza = BazaPodataka.getInstance(this);
        btnmodifikuj = (Button) findViewById(R.id.btnModifikuj);
        gamebtn = (ImageButton) findViewById(R.id.btnGame);

        gamebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                launchGameActivity();
            }
        });
       // boolean prviput = getSharedPreferences("PREFERENCES",MODE_PRIVATE).getBoolean("prviput",true);

        //if(prviput)
        //{
         //   launchFirstActivity();
           // getSharedPreferences("PREFERENCES",MODE_PRIVATE).edit().putBoolean("prviput",false).commit();
        //}

        progressbtn = (ImageButton) findViewById(R.id.btnProgress);

        progressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchProgressActivity();
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

        btnmodifikuj.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                launchModifikacijaActivity();
            }
        });

        //lblbre.setText(baza.getKolicinaCigareta());
        //provera();
        prikaziProtekloVremeDani();
    }

    private void launchGameActivity() {
        Intent intent = new Intent(this, Manager.class);
        startActivity(intent);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        prikaziProtekloVremeDani();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        prikaziProtekloVremeDani();
    }

    private void launchProgressActivity() {

            Intent intent = new Intent(this, Progress.class);
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
    /*private void launchFirstActivity()
    {
        Intent intent = new Intent(this,First.class);
        startActivity(intent);
    }*/
    private void launchModifikacijaActivity()
    {
        Intent intent = new Intent(this,Modifikacija.class);
        startActivity(intent);
    }
//    public void provera()
//    {
//        Cursor res = baza.getAllData();
//        if(res.getCount() == 0)
//        {
//            Toast.makeText(this,"kursos nema podataka",Toast.LENGTH_LONG).show();
//            return;
//        }
//        StringBuffer sb = new StringBuffer();
//        while(res.moveToNext())
//        {
//            sb.append("ID: " + res.getString(0) + "\n");
//            sb.append("KOLICINA: " + res.getString(1) + "\n");
//            sb.append("CENA: " + res.getString(2) + "\n");
//            sb.append("SAT: " + res.getString(3) + "\n");
//            sb.append("DAN: " + res.getString(4) + "\n");
//            sb.append("MESEC: " + res.getString(5) + "\n");
//            sb.append("GODINA: " + res.getString(6) + "\n");
//            sb.append("RAZLOG: " + res.getString(7) + "\n\n");
//
//        }
//        AlertDialog.Builder bilder = new AlertDialog.Builder(this);
//        bilder.setCancelable(true);
//        bilder.setTitle("BRATEU");
//        bilder.setMessage(sb.toString());
//        bilder.show();
//    }
    private void prikaziProtekloVremeDani()
    {
        Logika logika = new Logika();
        String res = logika.protekloVreme(baza);
        String provera = "736877";
        if(res.equals(provera))
        {
            lblbre.setText("Otvorite ponovo aplikaciju");
        }
        lblbre.setText("Niste pusili ukupno: " + res + "dana. \n SAMO NAPRED!" );
    }
    }

