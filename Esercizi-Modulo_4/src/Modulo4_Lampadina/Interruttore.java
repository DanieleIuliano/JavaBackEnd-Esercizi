package Modulo4_Lampadina;

public class Interruttore {
    Lampadina lamp;

    /**
     * Costruttore della classe interuttore
     *
     * @param lamp
     */
    public Interruttore(Lampadina lamp) {
        this.lamp = lamp;
    }

    public Lampadina getLamp() {
        return lamp;
    }

    public void setLamp(Lampadina lamp) {
        this.lamp = lamp;
    }

    public void accendiLamp() {
        if (lamp.getStato().equals(statoLampadina.spento)) {
            lamp.setStato(statoLampadina.acceso);
            lamp.setContatore(lamp.getContatore() + 1);
            System.out.println("Ho acceso la lampadina ");
        } else if (lamp.getStato().equals(statoLampadina.rotto))
            System.out.println("Lampadina rotta");
        else System.out.println("Lampadina già accesa ");
    }

    public void SpegniLamp() {
        if (lamp.getStato().equals(statoLampadina.acceso)) {
            lamp.setStato(statoLampadina.spento);
            lamp.setContatore(lamp.getContatore() + 1);
            System.out.println("Ho spento la lampadina ");
        } else if (lamp.getStato().equals(statoLampadina.rotto))
            System.out.println("Lampadina rotta");
        else System.out.println("Lampadina già spenta ");
    }


}
