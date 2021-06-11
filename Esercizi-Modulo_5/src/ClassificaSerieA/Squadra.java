package ClassificaSerieA;

public class Squadra {
   private static int idSquadra;
   private String nome;
   Giocatore[] giocatori;
   private int goalFatti;
   private int goalSubiti;
   private int punteggio;

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getGoalFatti() {
        return goalFatti;
    }

    public void setGoalFatti(int goalFatti) {
        this.goalFatti = goalFatti;
    }

    public int getGoalSubiti() {
        return goalSubiti;
    }

    public void setGoalSubiti(int goalSubiti) {
        this.goalSubiti = goalSubiti;
    }

    public Squadra(String nome, Giocatore[] giocatori) {
        setIdSquadra(idSquadra);
        this.nome = nome;
        this.giocatori = giocatori;

    }

    public int getIdSquadra() {
        return idSquadra;
    }

    private static void setIdSquadra(int idSquadra) {
        //accedo con il nome della classe perchè staticoo;
        Squadra.idSquadra = Squadra.idSquadra+1;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
