package Modulo3;

import java.util.Arrays;

//Esercitazione 1
public class NumeroPerduto {
    public static void main(String[] args) {
        int[] array = {1, 3, 0,4,5};
        Arrays.sort(array);
        int num=0;
        for (int j=0; j<array.length;j++) {
            if(array[j]!=j){
                num=j;
                break;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("numero " +num);
    }
}

