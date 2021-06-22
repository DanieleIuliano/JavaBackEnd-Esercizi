package SuperMercato_Esercizio;
//Ogni cliente ha nome, cognome, età e un id univoco.

import java.util.UUID;

public class Cliente implements Comparable<Cliente> {
    private String uniqueID;
    private String nome;
    private String cognome;
    private int età;

    public Cliente(String nome, String cognome, int età) {
        this.uniqueID = UUID.randomUUID().toString();
        this.nome = nome;
        this.cognome = cognome;
        this.età = età;
    }

    public String getUniqueID() {
        return uniqueID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "uniqueID='" + uniqueID + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", età=" + età +
                '}';
    }

    @Override
    public int compareTo(Cliente o) {

        if (getEtà() > o.getEtà())

            return -1;


        if (getEtà() < o.getEtà())

            return 1;

        else

            return 0;

    }
}
