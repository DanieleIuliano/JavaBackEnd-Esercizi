package ClassificaSerieA;

public class Giocatore {
    private static int prossimoID = 1;
    private int idGiocatore;
    private String nome;
    private String Cognome;

    public Giocatore(String nome, String cognome) {
        setIdGiocatore();
        this.nome = nome;
        this.Cognome = cognome;
    }


    public int getIdGiocatore() {
        return idGiocatore;
    }

    private void setIdGiocatore() {
        //accedo con il nome della classe perchè statico
        idGiocatore = prossimoID++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }
}
