package FormeGeometriche;

public abstract class FormeGeometriche {
    int lato , base ,altezza;

    public abstract int getArea();
    public abstract int getPerimetro();

    public FormeGeometriche(int lato) {
        this.lato = lato;
    }

    public FormeGeometriche(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }
}
