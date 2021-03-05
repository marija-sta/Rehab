package com.example.korisnik.rehab.klase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Manche on 29-May-17.
 */

public class Logika {
   /* public static Logika _instancaLogike = null;*/

    public Logika ()
    {

    }
    //metod za racunanje proteklog vremena...
    public String protekloVreme(BazaPodataka baza)
    {
        String rezultat = "-900000";
        String danP = baza.getDan();
        String mesecP = baza.getMesec();
        String godinaP = baza.getGodina();
        String datumP = danP + " " + mesecP + " "+ godinaP;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        String datumTrenutni = sdf.format(new Date());
        try {
            Date dateP = sdf.parse(datumP);
            Date dateT = sdf.parse(datumTrenutni);

            long razlika = dateT.getTime() - dateP.getTime();
            long razlikaDani = TimeUnit.MILLISECONDS.toDays(razlika);
            long r = razlikaDani - 30;
            rezultat = Long.toString(r);
        }
        catch(ParseException e)
        {
            e.printStackTrace();

        }


        return rezultat;
    }
    public String protekloVremeSati(BazaPodataka baza)
    {
        String sat = baza.getSat();
        SimpleDateFormat sdf = new SimpleDateFormat("hh");
        String sati = sdf.format(new Date());
        String rezultat = "";
        try {
            Date satiSad = sdf.parse(sati);
            Date satiBaza = sdf.parse(sat);
            long razlika =  satiBaza.getTime() - satiSad.getTime(); //tweaking maybe
            long razlikaSati = TimeUnit.MILLISECONDS.toHours(razlika);
            if(razlikaSati < 0 )
                razlikaSati = razlikaSati * (-1);
            rezultat = Long.toString(razlikaSati);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return rezultat;
    }

    //metod za racunanje stanja zdravlja...
    public String brojNepopusenihCigareta(BazaPodataka baza)
    {
        String dnevnoCig = baza.getKolicinaCigareta();
        String daniProtekli =  this.protekloVreme(baza);
        int dCig = Integer.parseInt(dnevnoCig);
        int dayspast = Integer.parseInt(daniProtekli);
        int brnepopusenih = dCig * dayspast;
        String rezultat = Integer.toString(brnepopusenih);
        return rezultat;
    }


    //metod za ?belezenje kriza??

    //metod za racunanje ustedjenog novca
    public String kolikoJeUstedeo(BazaPodataka baza)
    {
        String brojcigaretadnevno = baza.getKolicinaCigareta();
        String cena = baza.getCenaPakle();
        String proteklidani = this.protekloVreme(baza);
        int cigperday = Integer.parseInt(brojcigaretadnevno);
        int price = Integer.parseInt(cena);
        int pastdayz = Integer.parseInt(proteklidani);

        float res = ((cigperday / 20 ) * price) * pastdayz;
        String rez = Float.toString(res);
        return rez;
    }
    //metod za achievementse ?

   /* public static Logika get_instancaLogike()
    {
        if(_instancaLogike == null)
        {
            return new Logika();
        }
        return _instancaLogike;
    }*/
}
