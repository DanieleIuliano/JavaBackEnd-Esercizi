package Esercizio_JustDelivery;

import java.util.UUID;

public class Utente {

    private String iD;
    private String username;
    private String password;
    private double credito;

    /***** COSTRUTTORE ****/
    public Utente(String username, String password, double credito) {
        iD = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.credito = credito;
    }

    /********* GETTER AND SETTER *********/
    public String getiD() {
        return iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
}
