package FormeGeometriche;

import FormeGeometriche.FormeGeometriche;

public class Rettangolo extends FormeGeometriche {
    int base;
    int altezza;

    public Rettangolo(int base, int altezza) {
        super(base, altezza);
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public int getArea() {
        return base*altezza;
    }

    @Override
    public int getPerimetro() {
        return (base+altezza)*2;
    }
}
