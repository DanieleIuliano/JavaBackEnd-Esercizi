package Modulo4_Lampadina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lampadina lamp = new Lampadina();
        Interruttore inter1 = new Interruttore(lamp);
        Interruttore inter2 = new Interruttore(lamp);
        if (lamp.isCorrente()) {
            while (!lamp.checkStatusRotto()) {
                System.out.println("Quale interruttore vuoi usare 1 default , secondo premi 2");
                int scelta = scan.nextInt();
                if (scelta == 2) {
                    System.out.println("Vuoi accendere o spegnere 1 accendi (default), 2 spegni");
                    int scelta2 = scan.nextInt();
                    if (scelta2 == 1) {
                        inter2.accendiLamp();
                    } else inter2.SpegniLamp();
                } else {
                    System.out.println("Vuoi accendere o spegnere 1 accendi (default), 2 spegni");
                    int scelta2 = scan.nextInt();
                    if (scelta2 == 1) {
                        inter1.accendiLamp();
                    } else inter1.SpegniLamp();

                }
            }
        } else System.out.println("Devi accendere prima la corrente");

    }
}
