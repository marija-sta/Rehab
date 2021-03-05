package com.example.korisnik.rehab.klase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;

/**
 * Created by Manche on 29-May-17.
 */

public class BazaPodataka extends SQLiteOpenHelper {
    public static BazaPodataka INSTANCA;
    public static final String IME_BAZE= "Statistika.db";
    public static final String IME_TABELE = "korisnicki_podaci_tabela";
    public static final String KOLONA_1 = "ID";
    public static final String KOLONA_2 = "KOLICINACIGARETADNEVNO";
    public static final String KOLONA_3 = "CENAPAKLE";
    public static final String KOLONA_4 = "SATPRESTANKA";
    public static final String KOLONA_5 = "DAN";
    public static final String KOLONA_6 = "MESEC";
    public static final String KOLONA_7 = "GODINA";
    public static final String KOLONA_8 = "RAZLOG";

    public static BazaPodataka getInstance(Context kontekst)
    {
        if(INSTANCA == null)
        {
            INSTANCA = new BazaPodataka(kontekst);
        }
        return INSTANCA;
    }

    public BazaPodataka (Context kontekst){
        super(kontekst, IME_BAZE, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + IME_TABELE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,KOLICINACIGARETADNEVNO INTEGER,CENAPAKLE INTEGER,SATPRESTANKA INTEGER,DAN INTEGER,MESEC INTEGER,GODINA INTEGER,RAZLOG TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + IME_TABELE);
            onCreate(db);
    }
    public boolean insertData(String kol,String cen,String sat,String day,String month, String year, String reason)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KOLONA_2,kol);
        cv.put(KOLONA_3,cen);
        cv.put(KOLONA_4,sat);
        cv.put(KOLONA_5,day);
        cv.put(KOLONA_6,month);
        cv.put(KOLONA_7,year);
        cv.put(KOLONA_8,reason);

        long res = db.insert(IME_TABELE,null,cv);
        if(res == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor k = db.rawQuery("SELECT * FROM " + IME_TABELE,null);
        return k;

    }
    public String getKolicinaCigareta()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(1);
        }
        return rezultat;
    }
    public String getCenaPakle()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(2);
        }
        return rezultat;
    }
    public String getSat()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(3);
        }
        return rezultat;
    }
    public String getDan()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(4);
        }
        return rezultat;
    }
    public String getMesec()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(5);
        }
        return rezultat;
    }
    public String getGodina()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(6);
        }
        return rezultat;
    }
    public String getRazlog()
    {
        Cursor res = this.getAllData();
        String rezultat = "0";
        if(res.getCount() == 0)
        {
            return rezultat;
        }

        while(res.moveToNext())
        {
            rezultat = res.getString(7);
        }
        return rezultat;
    }
    public boolean modifikujPodatke(String id,String kol,String cen,String sat,String day,String month, String year, String reason )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put(KOLONA_1,id);
        cv.put(KOLONA_2,kol);
        cv.put(KOLONA_3,cen);
        cv.put(KOLONA_4,sat);
        cv.put(KOLONA_5,day);
        cv.put(KOLONA_6,month);
        cv.put(KOLONA_7,year);
        cv.put(KOLONA_8,reason);
        db.update(IME_TABELE,cv, "ID = ?",new String[] {id });
       // if(res == -1)
         //   return false;
        //else
            return true;
    }
}
