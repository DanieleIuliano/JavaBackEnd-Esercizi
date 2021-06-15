package BotBase;

public enum TipoMessaggio {
    SALUTA("Ciao"),MONOPATTINO("Monopattino"),
    SCOOTER("Scooter"),MOTO("Moto"),
    TASTIERA("Tastiera"),ERRORE("Errore");
    private String text;

    TipoMessaggio(String text) {
        this.text = text;
    }

    private String getText(){
        return this.text;
    }
    public static TipoMessaggio fromString(String text) {
        for (TipoMessaggio b : TipoMessaggio.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
