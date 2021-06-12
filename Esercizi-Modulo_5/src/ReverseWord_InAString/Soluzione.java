package ReverseWord_InAString;

import java.util.Arrays;

public class Soluzione {

    public String reverseWords(String s) {
        //metodo che rimpiazza gli spazi extra nella stringa con un singolo spazio (//s+)
        s = s.replaceAll("\\s+", " ");
        //metodo che divide le stringhe tra gli spazi
        String[] arrayDiStringhe = s.split(" ");
        String arrayUnito = "";
        char spazio = ' ';
        for (int i = 0; i < arrayDiStringhe.length; i++) {
            if (i == arrayDiStringhe.length - 1) {
                arrayUnito = arrayUnito.concat(arrayDiStringhe[arrayDiStringhe.length - i - 1]);
                continue;
            }
            arrayUnito = arrayUnito.concat(arrayDiStringhe[arrayDiStringhe.length - i - 1] + spazio);
        }

        // (trim) metodo che elimina gli spazi prima e dopo una stringa
        s = arrayUnito.trim();
        return s;
    }

}
