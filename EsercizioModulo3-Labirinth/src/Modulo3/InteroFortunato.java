package Modulo3;

public class InteroFortunato {
    public static void main(String[] args) {
        int[] array ={7,7,7,7,7,7,7,2,2,1};
        int max = cercaFortunato(array);
        System.out.println("Il massimo numero fortunato: " + max);
    }
    public static int cercaFortunato(int [] arr){
        int[] frequenza = new int [501];
        int max =0;
        for (int i = 0; i < arr.length; i++){
            frequenza[arr[i]]++;
        }
        for (int i = 0; i < arr.length+1; i++){
            if(frequenza[i] == i){
                if(i == 0){
                    continue;
                }
                System.out.println(i + " numero fortunato!");
                if(i > max){
                    max = i;
                }
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }
}
