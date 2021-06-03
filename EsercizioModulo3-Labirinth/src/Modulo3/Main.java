package Modulo3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Salve Giocatore scegli quale mappa giocare: 1(predefinita) 2(generata casualmente) ");
        int scelta = scan.nextInt();
        if(scelta == 2) {
            System.out.println("Inserisci dimensione mappa che vuoi giocare ");
            int dim = scan.nextInt();
            char[][] arrayMappa2 = creaMappaGioco(dim);
            stampaMatrice(arrayMappa2);
            iniziaIlGioco(arrayMappa2, dim, dim);
        }else {
            char[][] arrayMappa = {{'P', 'W', '-', '-', 'W'}, {'-', '-', 'W', '-', 'E'}, {'-', '-', 'W', '-', '-'}, {'-', '-', '-', '-', '-'}, {'W', '-', 'W', '-', 'W'}};
            stampaMatrice(arrayMappa);
            int dimRig = arrayMappa.length;
            int dimCol = arrayMappa[0].length;
            iniziaIlGioco(arrayMappa, dimRig, dimCol);
        }

    }

    /**
     * Metodo che crea una matrice di caratteri tra(WPE--) con controllo su P,E inseriti una sola volta
     * @param dim .
     * @return mappadigioco
     */
    public static char[][] creaMappaGioco(int dim) {
        Random rand = new Random();
        String lettereSostitute = "W----";
        int indiceRandomicoRigaP = rand.nextInt(dim);
        int indiceRandomicoRigaE = rand.nextInt(dim);
        int indiceRandomicoColonnaE = rand.nextInt(dim);
        int indiceRandomicoColonnaP = rand.nextInt(dim);
        char[][] vettoreRis = new char[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (i == indiceRandomicoRigaP && j == indiceRandomicoColonnaP) {
                    vettoreRis[i][j] = 'P';
                    continue;
                }
                if (i == indiceRandomicoRigaE && j == indiceRandomicoColonnaE) {
                    vettoreRis[i][j] = 'E';
                    continue;
                }
                vettoreRis[i][j] = lettereSostitute.charAt(rand.nextInt(lettereSostitute.length()));
            }
        }

        return vettoreRis;
    }


    /**
     * Metodo che data una matrice ti fa partire il gioco
     *
     * @param matrice .
     * @param dimRig  .
     * @param dimCol  .
     */
    public static void iniziaIlGioco(char[][] matrice, int dimRig, int dimCol) {
        boolean uscitaTrovata = false;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Scegli come spostarti: W(sopra) A(sinistra) S(sotto) D(desta): ");
            char scelta = scan.next().charAt(0);
            scelta = Character.toUpperCase(scelta);
            switch (scelta) {
                case 'W':
                    uscitaTrovata = spostastamentoSopra(matrice, dimCol, dimRig);
                    stampaMatrice(matrice);
                    break;
                case 'S':
                    uscitaTrovata = spostastamentoSotto(matrice, dimCol, dimRig);
                    stampaMatrice(matrice);
                    break;
                case 'A':
                    uscitaTrovata = spostastamentoSinistra(matrice, dimCol, dimRig);
                    stampaMatrice(matrice);
                    break;
                case 'D':
                    uscitaTrovata = spostastamentoDestra(matrice, dimCol, dimRig);
                    stampaMatrice(matrice);
                    break;
                default:
                    System.out.println("hai inserito un valore scorretto, Riprova!");
            }

        } while (!uscitaTrovata);
        System.out.println("Hai trovato l'uscita: BRAVO!");
    }

    /**
     * Metodo che stampa semplicemente la matrice come output
     *
     * @param matrice .
     */
    public static void stampaMatrice(char[][] matrice) {
        for (char[] chars : matrice) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(" " + chars[j]);
            }
            System.out.println();
        }
    }


    /**
     * Metodo che scambia il valore della P con il valore della colonna successiva
     *
     * @param matrice .
     * @param dimCol  .
     * @param dimRig  .
     * @return vero se trova 'E' falso per tutto il resto
     */

    public static boolean spostastamentoDestra(char[][] matrice, int dimCol, int dimRig) {
        char temp;
        for (int i = 0; i < dimRig; i++) {
            for (int j = 0; j < dimCol; j++) {
                //controllo se ho trovato l'uscita la fine
                if ((j + 1) < dimCol && matrice[i][j] == 'P' && matrice[i][j + 1] == 'E') {
                    System.out.println("hai trovato l'uscita, Bravo!");
                    return true;
                }
                //controlla se ci sta un muro o finisce la matrice
                if ((j + 1) < dimCol && matrice[i][j] == 'P' && matrice[i][j + 1] == '-' && matrice[i][j + 1] != 'W') {
                    temp = matrice[i][j];
                    matrice[i][j] = matrice[i][j + 1];
                    matrice[i][j + 1] = temp;
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Metodo che scambia il valore della P con il valore della colonna precedente
     *
     * @param matrice .
     * @param dimCol  .
     * @param dimRig  .
     * @return vero se trova 'E' falso per tutto il resto
     */
    public static boolean spostastamentoSinistra(char[][] matrice, int dimCol, int dimRig) {
        char temp;
        for (int i = 0; i < dimRig; i++) {
            for (int j = 0; j < dimCol; j++) {
                // controlla se ho trovato l'uscita
                if (j > 0 && matrice[i][j] == 'P' && matrice[i][j - 1] == 'E') {
                    return true;
                }
                //controlla se ci sta un muro o finisce la matrice
                if (j > 0 && matrice[i][j] == 'P' && matrice[i][j - 1] == '-' && matrice[i][j - 1] != 'W') {
                    temp = matrice[i][j];
                    matrice[i][j] = matrice[i][j - 1];
                    matrice[i][j - 1] = temp;
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Metodo che scambia il valore della P con il valore della riga successiva
     *
     * @param matrice .
     * @param dimCol  .
     * @param dimRig  .
     * @return vero se trova 'E' falso per tutto il resto
     */
    public static boolean spostastamentoSotto(char[][] matrice, int dimCol, int dimRig) {
        char temp;
        for (int i = 0; i < dimRig; i++) {
            for (int j = 0; j < dimCol; j++) {
                // controllo se l'uscita
                if ((i + 1) < dimRig && matrice[i][j] == 'P' && matrice[i + 1][j] == 'E') {
                    return true;
                }
                //controlla se ci sta un muro o finisce la matrice
                if ((i + 1) < dimRig && matrice[i][j] == 'P' && matrice[i + 1][j] == '-' && matrice[i + 1][j] != 'W') {
                    temp = matrice[i][j];
                    matrice[i][j] = matrice[i + 1][j];
                    matrice[i + 1][j] = temp;
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Metodo che scambia il valore della P con il valore della riga precedente
     *
     * @param matrice .
     * @param dimCol  .
     * @param dimRig  .
     * @return vero se trova 'E' falso per tutto il resto
     */
    public static boolean spostastamentoSopra(char[][] matrice, int dimCol, int dimRig) {
        char temp;
        for (int i = 0; i < dimRig; i++) {
            for (int j = 0; j < dimCol; j++) {
                //controllo se ho trovato l'uscita;
                if (i > 0 && matrice[i][j] == 'P' && matrice[i - 1][j] == 'E') {
                    return true;
                }
                //controlla se ci sta un muro o finisce la matrice
                if (i > 0 && matrice[i][j] == 'P' && matrice[i - 1][j] == '-' && matrice[i - 1][j] != 'W') {
                    temp = matrice[i][j];
                    matrice[i][j] = matrice[i - 1][j];
                    matrice[i - 1][j] = temp;
                    return false;
                }
            }
        }
        return false;
    }

}

