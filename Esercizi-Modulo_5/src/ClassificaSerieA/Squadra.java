package ClassificaSerieA;

public class Squadra {
    int idSquadra;
    private String nome;
    static int prossimoIdSquadra = 1;
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
        setIdSquadra();
        this.nome = nome;
        this.giocatori = giocatori;

    }

    public int getIdSquadra() {
        return idSquadra;
    }

    private  void setIdSquadra() {
        //accedo con il nome della classe perchè staticoo;
        idSquadra = prossimoIdSquadra++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
