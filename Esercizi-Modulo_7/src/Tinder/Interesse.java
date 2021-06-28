package Tinder;

import java.util.UUID;

public class Interesse {
    String nome;
    String codiceUnivoco;

    public Interesse(String nome) {
        codiceUnivoco = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    @Override
    public String toString() {
        return "Interesse{" +
                "nome='" + nome + '\'' +
                ", codiceUnivoco='" + codiceUnivoco + '\'' +
                '}';
    }
}
