package Tinder;

import java.util.HashSet;
import java.util.UUID;

public class Utente {
    private String iD;
    private String nome;
    private String cognome;
    private int eta;
    private Sesso sesso;
    private HashSet<Interesse> interessiUtente;



    public Utente(String nome, String cognome, int eta, Sesso sesso, HashSet<Interesse> interessiUtente) {
        iD = UUID.randomUUID().toString();
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.sesso = sesso;
        this.interessiUtente = interessiUtente;
    }

    public HashSet<Interesse> getInteressiUtente() {
        return interessiUtente;
    }

    public void setInteressiUtente(HashSet<Interesse> interessiUtente) {
        this.interessiUtente = interessiUtente;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "iD='" + iD + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", sesso=" + sesso +
                ", interessiUtente=" + interessiUtente +
                '}';
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public String getiD() {
        return iD;
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
}
