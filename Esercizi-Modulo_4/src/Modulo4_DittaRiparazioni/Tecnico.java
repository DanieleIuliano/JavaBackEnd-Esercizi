package Modulo4_DittaRiparazioni;

public class Tecnico {
    private String nome;
    private StatoTecnico stato;

    /**
     * Costruttore che prende il nome del tecnico
     * @param nome
     */
    public Tecnico(String nome, StatoTecnico stato) {
        this.nome = nome;
        this.stato = stato;
    }

    public StatoTecnico getStato() {
        return stato;
    }

    public void setStato(StatoTecnico stato) {
        this.stato = stato;
    }

    /**
     * metodo per ottenere Il nome
     * @return nome.
     */
    public String getNome() {
        return nome;
    }

    /**
     * metodo per mettere il nome
     * @param nome
     */

    public void setNome(String nome) {
        this.nome = nome;
    }
}
