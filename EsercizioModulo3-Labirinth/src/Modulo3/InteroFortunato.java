package Modulo3;

public class InteroFortunato {
    public static void main(String[] args) {
        int[] array ={7,7,7,7,7,7,7,2,2,1};
        cercaFortunato(array);
    }
    public static int cercaFortunato(int [] arr){
        int[] frequenza = new int [501];
        int max =0;
        for (int i = 0; i < arr.length; i++){
            frequenza[arr[i]]++;
        }
        for (int i = 0; i < arr.length+1; i++){
            if(frequenza[i] == i){
                System.out.println(i + " numero fortunato!");
                if(i > max){
                    max = i;
                }
            }
        }
        if(max == 0){
            return -1;
        }
        System.out.println(max);
        return -1;
    }
}
