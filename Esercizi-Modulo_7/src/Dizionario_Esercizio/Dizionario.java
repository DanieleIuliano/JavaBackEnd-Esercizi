package Dizionario_Esercizio;

import java.util.*;

public class Dizionario {
    Map<Character, Map<String, List<String>>> dizionario = new TreeMap<>();

    public void addLettere() {
        for (int i = 0; i < 26; i++) {
            char lettera = (char) (97 + i);
            dizionario.put(lettera, new HashMap<>());
        }
    }

    public void aggiungiParole(String parola, List<String> significati) {
        if (dizionario.get(parola.charAt(0)).containsKey(parola))
            dizionario.get(parola.charAt(0)).get(parola).addAll(significati);
        else
            dizionario.get(parola.charAt(0)).put(parola, significati);
    }

    public void aggiungiSignificato(String parola, String significato) {

        if (dizionario.containsKey(parola.charAt(0))) {
            if (dizionario.get(parola.toLowerCase(Locale.ROOT).charAt(0)).containsKey(parola)) {
                dizionario.get(parola.toLowerCase(Locale.ROOT).charAt(0)).get(parola).add(significato);
            }
        }
    }

    public void stampaDizionario() {
        System.out.println(dizionario.toString());
    }
    public void  rimuoviParola(String parola){
        if(dizionario.get(parola.charAt(0)).containsKey(parola))
            dizionario.get(parola.charAt(0)).remove(parola);
    }

    public void rimuoviSignificato(String parola, String significato){
        if(dizionario.get(parola.charAt(0)).containsKey(parola)){
            dizionario.get(parola.charAt(0)).get(parola).remove(significato);
        }
    }

    public void rimuoviSignificato2(String significato){
        /* altro modo con le lampda
        dizionario.forEach((k, v)-> dizionario;
        for(Map.Entry<Character, Map<String, List<String>>> entry : dizionario.entrySet()) {
            entry.g
        }

         */
        for (Character lett :dizionario.keySet()) {
            for (String parola:dizionario.get(lett).keySet() ) {

                if(dizionario.get(lett).get(parola).contains(significato))
                    dizionario.get(lett).get(parola).remove(significato);
            }
        }
    }
}
