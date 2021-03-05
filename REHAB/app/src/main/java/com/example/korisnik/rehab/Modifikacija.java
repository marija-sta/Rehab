package com.example.korisnik.rehab;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.korisnik.rehab.klase.BazaPodataka;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Manche on 29-May-17.
 */

public class Modifikacija extends AppCompatActivity {
    public static final int DIALOG_ID = 0;
    private Button btnDatumDialog;
    private int dan_x;
    private int mesec_x;
    private int godina_x;
    private EditText kolicina;
    private EditText cena;
    private EditText satprestanka;
    private EditText razlog;


    private BazaPodataka baza;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        /*final Calendar kal = Calendar.getInstance();
        godina_x = kal.get(Calendar.YEAR);
        mesec_x = kal.get(Calendar.MONTH);
        dan_x = kal.get(Calendar.DAY_OF_MONTH);*/
        kolicina = (EditText) findViewById(R.id.tbxKolicinaCigaretaModifikacija);
        cena =(EditText) findViewById(R.id.tbxCenaPakleModifikacija);
        satprestanka = (EditText) findViewById(R.id.tbxSatPrestankaModifikacija);
        razlog = (EditText) findViewById(R.id.tbxRazlogModifikacija);


        baza = BazaPodataka.getInstance(this);

        prikaziDialog();
    }
    public void modifikuj(View view)
    {
        if(!Validacija())
        {
            Toast.makeText(Modifikacija.this,"Popunite polja molim!",Toast.LENGTH_LONG).show();
            return;
        }



        String kolicinacig = kolicina.getText().toString();
        String cenapakle = cena.getText().toString();
        String satp = satprestanka.getText().toString();
        String reason = razlog.getText().toString();
        String dann = Integer.toString(dan_x);
        String mesecc = Integer.toString(mesec_x);
        String godd = Integer.toString(godina_x);
        //String id = Integer.toString(1);
        String id = "1";
        boolean k = baza.modifikujPodatke(id,kolicinacig,cenapakle,satp,dann,mesecc,godd,reason); //modify data not insert
        if(k)
            Toast.makeText(this,"Modifikovao",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Nije modifikovao ",Toast.LENGTH_LONG).show();


        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }
    public void prikaziDialog(){
        btnDatumDialog = (Button) findViewById(R.id.btnKalendarModifikacija);
        btnDatumDialog.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view)
                    {
                        SimpleDateFormat vreme = new SimpleDateFormat();
                        vreme.applyPattern("dd");
                        dan_x = Integer.parseInt(vreme.format(new Date()));
                        vreme.applyPattern("MM");
                        mesec_x = Integer.parseInt(vreme.format(new Date()));
                        mesec_x = mesec_x -1;
                        vreme.applyPattern("yyyy");
                        godina_x = Integer.parseInt(vreme.format(new Date()));
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID)
            return new DatePickerDialog(this,datumPickerListener,godina_x,mesec_x,dan_x);
        else return null;
    }
    private DatePickerDialog.OnDateSetListener datumPickerListener =
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    godina_x = year;
                    mesec_x = month;
                    dan_x = dayOfMonth;
                    //Toast.makeText(First.this,godina_x + "/" + mesec_x + dan_x,Toast.LENGTH_LONG).show();

                }
            };

    private boolean Validacija()
    {
        String kolicinacig = kolicina.getText().toString();
        String cenapakle = cena.getText().toString();
        String satp = satprestanka.getText().toString();
        String reason = razlog.getText().toString();
        int hour = Integer.parseInt(satp);
        if (!TextUtils.isEmpty(kolicinacig) && !TextUtils.isEmpty(cenapakle) && hour <= 24 && hour >= 0 && !TextUtils.isEmpty(reason) && godina_x != 0 &&
                mesec_x <= 12 && mesec_x >=1 && dan_x > 0 && dan_x <= 31)
            return true;
        else
            return false;
    }
}
