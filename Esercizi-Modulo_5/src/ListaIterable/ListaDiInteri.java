package ListaIterable;


public class ListaDiInteri implements Iterabile {
    int[] listaInteri;
    static int contatore = 0;


    public ListaDiInteri(int[] listaInteri) {
        this.listaInteri = listaInteri;
    }

    @Override
    public Integer next() {
        for (int i = 0; i < listaInteri.length; i++) {
            if (contatore == i) {
                contatore++;
                return listaInteri[i];
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < listaInteri.length; i++){
            if(contatore < listaInteri.length-1){
                return true;
            }
        }
            return false;
    }

    @Override
    public void reset() {
        contatore = 0;
    }
}
