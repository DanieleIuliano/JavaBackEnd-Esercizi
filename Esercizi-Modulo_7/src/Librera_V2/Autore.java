package Librera_V2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

//Ogni Autore possiede un codice (univoco), un nome, un cognome e una lista di Libri scritti
public class Autore {
    private String idUnivoco;
    private String nome;
    private String cognome;
    private HashSet<Libro> listaLibri;

    public Autore(String nome, String cognome, HashSet<Libro> listaLibri) {
        this.idUnivoco = UUID.randomUUID().toString();
        this.nome = nome;
        this.cognome = cognome;
        this.listaLibri = listaLibri;
    }

    public String getIdUnivoco() {
        return idUnivoco;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "idUnivoco='" + idUnivoco + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", listaLibri=" + listaLibri +
                '}';
    }

    public HashSet<Libro> getListaLibri(){
        return listaLibri;
    }
    public void addLibro(Libro libro){
        listaLibri.add(libro);
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
