package SommaThread;

public class Sommatore extends Thread {
    private int [] array;
    private int indiceInizio;
    private int indiceFine;
    int somma = 0;

    public Sommatore(int[] array,int indiceInizio,int indiceFine) {
        this.array = array;
        this.indiceInizio = indiceInizio;
        this.indiceFine = indiceFine;
    }

    @Override
    public void start() {
        somma = somma();
    }

    public int somma(){
        int somma = 0;
        for(int i = indiceInizio; i < indiceFine; i++){
            somma= array[i]+somma;
        }
        return somma;
    }
}
