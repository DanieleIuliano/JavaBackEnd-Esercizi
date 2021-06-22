package Librera_V2;

import java.util.Objects;
import java.util.UUID;

//  Ogni Libro ha un codice (univoco), un titolo, una sinossi e un Autore.
public class Libro {
    private String idUnivoco;
    private String titolo;
    private String sinossi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(idUnivoco, libro.idUnivoco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUnivoco);
    }

    public Libro(String titolo, String sinossi) {
        this.idUnivoco = UUID.randomUUID().toString();
        this.titolo = titolo;
        this.sinossi = sinossi;
    }

    public String getIdUnivoco() {
        return idUnivoco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }
}
