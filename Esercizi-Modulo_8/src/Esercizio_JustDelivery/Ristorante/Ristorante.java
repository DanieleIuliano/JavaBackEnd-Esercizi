package Esercizio_JustDelivery.Ristorante;

import java.util.*;

public class Ristorante {
    private String iD;
    private String nomeRistorante;
    private String password;
    private Set<String> menu;
    private Set<TipoCucina> tipiCucina;

    /******** Costruttore ******/
    public Ristorante(String nomeRistorante,String password, Set<String> menu, Set<TipoCucina> tipiCucina) {
        iD = UUID.randomUUID().toString();
        this.password = password;
        this.nomeRistorante = nomeRistorante;
        this.menu = menu;
        this.tipiCucina = tipiCucina;

    }

    @Override
    public String toString() {
        return "Ristorante{" +
                "iD='" + iD + '\'' +
                ", nomeRistorante='" + nomeRistorante + '\'' +
                ", password='" + password + '\'' +
                ", menu=" + menu +
                ", tipiCucina=" + tipiCucina +
                '}';
    }

    /********** GETTER AND SETTER *******/
    public String getiD() {
        return iD;
    }

    public String getNomeRistorante() {
        return nomeRistorante;
    }

    public void setNomeRistorante(String nomeRistorante) {
        this.nomeRistorante = nomeRistorante;
    }

    public Set<String> getMenu() {
        return menu;
    }

    public void setMenu(Set<String> menu) {
        this.menu = menu;
    }

    public Set<TipoCucina> getTipiCucina() {
        return tipiCucina;
    }

    public void setTipiCucina(Set<TipoCucina> tipiCucina) {
        this.tipiCucina = tipiCucina;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
