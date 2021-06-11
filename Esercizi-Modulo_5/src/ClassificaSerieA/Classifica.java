package ClassificaSerieA;

import java.util.Arrays;
import java.util.Comparator;

public class Classifica {
    Squadra[] squadre;

    public Classifica(Squadra[] squadre) {
        this.squadre = squadre;
    }

    public void esitoPartita(Squadra squadraCasa, int goalCasa, Squadra squadraOspite, int goalOspite) {
        if (goalCasa > goalOspite) {
            squadraCasa.setPunteggio(squadraCasa.getPunteggio() + 3);
            System.out.println("Ha vinto la squadra " + squadraCasa.getNome());
        }  else if(goalCasa == goalOspite) {
            squadraCasa.setPunteggio(squadraCasa.getPunteggio()+1);
            squadraOspite.setPunteggio(squadraOspite.getPunteggio()+1);
            System.out.println(squadraCasa.getNome() + " e " + squadraOspite.getNome() + " hanno Pareggiato");
        }else if(goalCasa < goalOspite) {
            squadraOspite.setPunteggio(squadraOspite.getPunteggio()+3);
            System.out.println("Ha vinto la squadra " + squadraOspite.getNome());
        }
        //aggiungo i goal subiti e fatti dalla squadra in casa
        squadraCasa.setGoalFatti(squadraCasa.getGoalFatti()+goalCasa);
        squadraCasa.setGoalSubiti(squadraCasa.getGoalSubiti()+goalOspite);
        //aggiungo i goal subiti e fatti dalla squadra ospite
        squadraOspite.setGoalFatti(squadraOspite.getGoalFatti()+goalOspite);
        squadraOspite.setGoalSubiti(squadraOspite.getGoalSubiti()+goalCasa);
    }

    public void stampaClassifica(){
        Arrays.sort(squadre, Comparator.comparingInt((x)-> x.getPunteggio()));
        System.out.println("Classifica:");
        for(int i = 0; i <  squadre.length; i++){
            System.out.println(squadre[squadre.length-i-1].getNome() + " " +squadre[squadre.length-i-1].getPunteggio());
        }
    }

    public void stampaMigliorAttacco(){
        Arrays.sort(squadre, Comparator.comparingInt((x)-> x.getGoalFatti()));
        System.out.println("Classifica Miglior Attacco:");
        for(int i = 0; i <  squadre.length; i++){
            System.out.println(squadre[squadre.length-i-1].getNome() + " " +squadre[squadre.length-i-1].getGoalFatti());
        }
    }
    public void stampaPeggiorDifesa(){
        Arrays.sort(squadre, Comparator.comparingInt((x)-> x.getGoalSubiti()));
        System.out.println("Classifica Peggior difesa:");
        for(int i = 0; i <  squadre.length; i++){
            System.out.println(squadre[squadre.length-i-1].getNome() + " " +squadre[squadre.length-i-1].getGoalSubiti());
        }
    }
}
