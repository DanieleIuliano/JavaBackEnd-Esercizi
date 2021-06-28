package Tinder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tinder {
    Map<Utente, HashSet<Interesse>> tinder = new HashMap<>();

    public void addUtente(Utente utente) {
        tinder.put(utente,utente.getInteressiUtente());
    }

    public void removeUtente(Utente utente){
        if(tinder.containsKey(utente)){
            System.out.println("stai rimuovendo:" +  utente.toString());
        tinder.remove(utente);
        }
        stampaUtenti();

    }


    public void stampaUtenti(){
        System.out.print(tinder.toString());
    }

    public void cercaUtenteAffine(Utente utente){
        for (Utente ut: tinder.keySet()) {
            if(ut.getiD().equals(utente.getiD())){
                continue;
            }
            ut.getInteressiUtente().retainAll(utente.getInteressiUtente());
            if(tinder.get(ut).size() > 2)
            System.out.println("utente affine: " + ut);
            else System.out.println("Nessun utente con più di due interessi in comune");
        }
    }



}
