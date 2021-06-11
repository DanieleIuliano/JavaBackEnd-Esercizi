package ClassificaSerieA;

public class Giocatore {
    private static int idGiocatore;
    private String nome;
    private String Cognome;

    public Giocatore(String nome, String cognome) {
        setIdGiocatore(idGiocatore);
        this.nome = nome;
        this.Cognome = cognome;
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }

    private static void setIdGiocatore(int idGiocatore) {
        //accedo con il nome della classe perchè statico
        Giocatore.idGiocatore++;
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
