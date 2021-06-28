package Esercizio_JustDelivery;

import Esercizio_JustDelivery.Ristorante.Ristorante;
import Esercizio_JustDelivery.Ristorante.TipoCucina;

import java.util.*;

public class GestioneDelivery {

    private Set<Ristorante> listaRistoranti = new HashSet<>();
    private Set<Utente> listaUtenti = new HashSet<>();

    public void menu_Iniziale() {
        Scanner scan = new Scanner(System.in);
        boolean fineProgramma = false;
        System.out.println("Benvenuto nell'applicazione cosa desideri fare: ");
        System.out.println("|Utente|");
        System.out.println("|Ristorante|");
        System.out.println("|Exit|");
        do {
            String scelta = scan.nextLine().toLowerCase(Locale.ROOT);
            switch (scelta) {
                case "utente":
                    menu_InizialeUtente();
                case "ristorante":
                    menu_InizialeRistorante();
                case "exit":
                    fineProgramma = true;
                default: {
                    if (fineProgramma = false) {
                        System.out.println("Inseriti valori errati");
                        menu_InizialeUtente();
                    }
                }

            }
        } while (fineProgramma);
    }

    public void menu_InizialeUtente() {
        Scanner scan = new Scanner(System.in);
        boolean fineProgramma = false;
        System.out.println("Benvenuto nell'applicazione cosa desideri fare: ");
        System.out.println("|Accesso|");
        System.out.println("|Registrazione|");
        System.out.println("|Exit|");
        do {
            String scelta = scan.nextLine().toLowerCase(Locale.ROOT);
            switch (scelta) {
                case "accesso":
                    accessoUtente();
                case "registrazione":
                    registrazioneUtente();
                case "exit":
                    fineProgramma = true;
                default: {
                    if (fineProgramma = false) {
                        System.out.println("Inseriti valori errati");
                        menu_InizialeUtente();
                    }
                }

            }
        } while (fineProgramma);
    }

    public void menu_InizialeRistorante() {
        Scanner scan = new Scanner(System.in);
        boolean fineProgramma = false;
        System.out.println("Benvenuto nell'applicazione cosa desideri fare: ");
        System.out.println("|Accesso|");
        System.out.println("|Registrazione|");
        System.out.println("|Exit|");

        do {
            String scelta = scan.nextLine().toLowerCase(Locale.ROOT);
            switch (scelta) {
                case "accesso":
                    accessoRistorante();
                case "registrazione":
                    registrazioneRistorante();
                case "exit":
                    fineProgramma = true;

                default: {
                    if (fineProgramma = false) {
                        System.out.println("Inseriti valori errati");
                        menu_InizialeRistorante();
                    }
                }

            }
        } while (fineProgramma);
    }

    public void accessoUtente() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci l'username dell'utente ");
        String inserisciUsername = scan.nextLine();

        System.out.print("Inserisci la password dell'utente ");
        String inserisciPassword = scan.nextLine();

        for (Utente utente : listaUtenti) {
            if (utente.getUsername().equalsIgnoreCase(inserisciUsername) && utente.getPassword().equals(inserisciPassword)) {
                System.out.println("Accesso riuscito");
            }
        }

    }

    public void registrazioneUtente() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci l'username dell'utente ");
        String inserisciUsername = scan.nextLine();

        System.out.print("Inserisci la password dell'utente ");
        String inserisciPassword = scan.nextLine();

        listaUtenti.add(new Utente(inserisciUsername, inserisciPassword, 0));
        System.out.println("Registrazione Effettuata");
        menu_InizialeUtente();

    }

    public void accessoRistorante() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Inserisci Nome del ristorante ");
        String inserisciUsername = scan.nextLine();

        System.out.print("Inserisci password ");
        String inserisciPassword = scan.nextLine();

        for (Ristorante ristorante : listaRistoranti) {
            if (ristorante.getNomeRistorante().equalsIgnoreCase(inserisciUsername) && ristorante.getPassword().equals(inserisciPassword)) {
                System.out.println("Accesso riuscito");
            }
        }
    }

    public void registrazioneRistorante() {
        Scanner scan = new Scanner(System.in);
        boolean fineSceltaPietanze = false;
        boolean fineSceltaTipoCucina = false;
        String sceltaPietanza;
        String sceltaTipoCucina;
        Set<String> menuScelta = new HashSet<>();
        Set<TipoCucina> tipiCucina = new HashSet<>();

        System.out.print("Inserisci il nome del ristorante ");
        String inserisciNome = scan.nextLine();

        System.out.print("Inserisci la password che userai ");
        String inserisciPassword = scan.nextLine();

        System.out.println("Inserisci Pietanze Menu (exit per uscire): ");
        do {

            sceltaPietanza = scan.nextLine();
            if (sceltaPietanza.equalsIgnoreCase("exit")) {
                fineSceltaPietanze = true;
            } else
                menuScelta.add(sceltaPietanza);

        } while (!fineSceltaPietanze);

        System.out.println("Inserisci le tipologie di cucina tra (Pizzeria,cinese,hamburgeria,fastfood, exit per uscire):");
        do {
            sceltaTipoCucina = scan.nextLine().toLowerCase(Locale.ROOT);
            if(sceltaTipoCucina.equalsIgnoreCase("pizzeria"))
                tipiCucina.add(TipoCucina.PIZZERIA);
            if(sceltaTipoCucina.equalsIgnoreCase("cinese"))
                tipiCucina.add(TipoCucina.CINESE);
            if(sceltaTipoCucina.equalsIgnoreCase("hamburgeria"))
                tipiCucina.add(TipoCucina.HAMBURGERIA);
            if(sceltaTipoCucina.equalsIgnoreCase("fastfood"))
                tipiCucina.add(TipoCucina.FASTFOOD);
            if(sceltaTipoCucina.equalsIgnoreCase("exit"))
                fineSceltaTipoCucina = true;

        } while (!fineSceltaTipoCucina);

        listaRistoranti.add(new Ristorante(inserisciNome, inserisciPassword, menuScelta, tipiCucina));
        System.out.println("Registrazione effettutata");
        menu_InizialeRistorante();
    }

    public void ricercaRistoranti(TipoCucina tipo){
        for(Ristorante ristorante : listaRistoranti){
            if(ristorante.getTipiCucina().contains(tipo)){
                System.out.println(ristorante);
            }
        }
    }

    public void stampaMenu(Ristorante ristorante){
        if(listaRistoranti.contains(ristorante)){
            System.out.println(ristorante.getMenu().toString());
        }
    }

    /******* GETTER AND SETTER ****/
    public Set<Ristorante> getListaRistoranti() {
        return listaRistoranti;
    }

    public void setListaRistoranti(Set<Ristorante> listaRistoranti) {
        this.listaRistoranti = listaRistoranti;
    }

    public Set<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(Set<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}



