package SommaThread;

import java.util.Arrays;
import java.util.Random;

public class Generatore {
    private int [] array;

    public Generatore(int[] array) {
        this.array = array;
    }

    public int [] addElementi(int [] array){
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(10);
            if(array[i] < 5){
                array[i] = (-1)*array[i];
            }
        }
        return array;
    }
    public int somma(){
        int somma = 0;
        for(int i = 0; i < array.length; i++){
            somma= array[i]+somma;
        }
        return somma;
    }

    @Override
    public String toString() {
        return "Generatore{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
