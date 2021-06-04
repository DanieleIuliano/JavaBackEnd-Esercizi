package Modulo3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labirinth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Salve Giocatore scegli quale mappa giocare: 1(predefinita) 2(generata casualmente) ");
        int scelta = scan.nextInt();
        if (scelta == 2) {
            System.out.println("Inserisci dimensione mappa che vuoi giocare ");
            int dim = scan.nextInt();
            char[][] arrayMappa2 = creaMappaGioco(dim);
            int[] posizioneP = salvaStatusP(arrayMappa2, dim);
            System.out.println(Arrays.toString(posizioneP));
            System.out.println("vuoi che lo risolva il pc? (1)si , il resto no");
            int sceltaRisoluzione = scan.nextInt();
            stampaMatrice(arrayMappa2);
            if (sceltaRisoluzione == 1) {
                iniziaIlGiocoAutomatico(arrayMappa2, posizioneP);
            } else {
                iniziaIlGioco(arrayMappa2, dim, dim);
            }
        } else {

            char[][] arrayMappa = {{'P', 'W', '-', '-', 'W'}, {'-', '-', 'W', '-', 'E'}, {'-', '-', 'W', '-', '-'}, {'-', '-', '-', '-', '-'}, {'W', '-', 'W', '-', 'W'}};
            stampaMatrice(arrayMappa);
            int dimRig = arrayMappa.length;
            int dimCol = arrayMappa[0].length;
            iniziaIlGioco(arrayMappa, dimRig, dimCol);
        }

    }

    /**
     * Metodo che crea una matrice di caratteri tra(WPE--) con controllo su P,E inseriti una sola volta
     *
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
                if(indiceRandomicoColonnaP == indiceRandomicoColonnaE && indiceRandomicoRigaP == indiceRandomicoColonnaP)
                    return creaMappaGioco(dim);
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
     * metodo ricorsivo che permette la risoluzione automatica
     *
     * @param matrice        .
     * @param nuovaPosizione .
     * @return vero se ha trovato la 'E'
     */
    public static boolean spostaAutomatico(char[][] matrice, int[] nuovaPosizione) {
        if (nuovaPosizione[0] < matrice.length && nuovaPosizione[1] < matrice[0].length && nuovaPosizione[0] >= 0 && nuovaPosizione[1] >= 0) {
            if (matrice[nuovaPosizione[0]][nuovaPosizione[1]] == 'W')
                return false;
            if (matrice[nuovaPosizione[0]][nuovaPosizione[1]] == '/') {
                return false;
            }
            if (matrice[nuovaPosizione[0]][nuovaPosizione[1]] == 'E') return true;
            matrice[nuovaPosizione[0]][nuovaPosizione[1]] = '/';
            if (spostaAutomatico(matrice, new int[]{nuovaPosizione[0] + 1, nuovaPosizione[1]}))
                return true;
            if (spostaAutomatico(matrice, new int[]{nuovaPosizione[0] - 1, nuovaPosizione[1]}))
                return true;
            if (spostaAutomatico(matrice, new int[]{nuovaPosizione[0], nuovaPosizione[1] + 1}))
                return true;
            if (spostaAutomatico(matrice, new int[]{nuovaPosizione[0], nuovaPosizione[1] - 1}))
                return true;
            matrice[nuovaPosizione[0]][nuovaPosizione[1]] = '-';
        } else return false;
        return false;
    }

    /**
     * Il giovo viene iniziato in automatico e risolto
     *
     * @param matrice    .
     * @param posizioneP .
     */
    public static void iniziaIlGiocoAutomatico(char[][] matrice, int[] posizioneP) {
        boolean uscitaTrovata;
        System.out.println();
        do {
            uscitaTrovata = spostaAutomatico(matrice, posizioneP);


        } while (!uscitaTrovata);
        System.out.println("Il pc ha trovato l'uscita!");
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
                if ((i - 1) >= 0 && matrice[i][j] == 'P' && matrice[i - 1][j] == 'E') {
                    return true;
                }
                //controlla se ci sta un muro o finisce la matrice
                if ((i - 1) >= 0 && matrice[i][j] == 'P' && matrice[i - 1][j] == '-' && matrice[i - 1][j] != 'W') {
                    temp = matrice[i][j];
                    matrice[i][j] = matrice[i - 1][j];
                    matrice[i - 1][j] = temp;
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Salva la posizione di P in un vetore
     * @param matrice .
     * @param dim .
     * @return posizioneP.
     */
    public static int[] salvaStatusP(char[][] matrice, int dim) {
        int[] posizioneP = new int[2];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (matrice[i][j] == 'P') {
                    posizioneP[0] = i;
                    posizioneP[1] = j;
                    return posizioneP;
                }
            }
        }
        return null;
    }

}

