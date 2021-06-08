package Modulo4_Biblioteca;

public class Libro {
    private int indice;

    /**
     * Costruttore della classe libro
     * @param indice
     */
    public Libro(int indice) {
        setIndice(indice);
    }

    /**
     * ritorna l'indice del libro
     * @return
     */
    public int getIndice() {
        return indice;
    }

    /**
     * imposta l'indice del libro
     * @param indice
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }
}
