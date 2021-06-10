package Modulo4_EsercizioLeetCodeShuffleArray;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {

        int [] num = {1,2,5,4};
        Solution soluzione = new Solution(num);
        soluzione.reset();
        int [] vettoreRandom = soluzione.shuffle();
        System.out.println(Arrays.toString(vettoreRandom));
    }
}
