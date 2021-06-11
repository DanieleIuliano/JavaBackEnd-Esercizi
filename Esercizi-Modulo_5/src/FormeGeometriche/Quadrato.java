package FormeGeometriche;

public class Quadrato extends FormeGeometriche{
    int lato;

    public Quadrato(int latoQuadrato) {
        super(latoQuadrato);
        this.lato = latoQuadrato;
    }

    @Override
    public int getArea() {
        return lato*lato;
    }

    @Override
    public int getPerimetro() {
        return lato*4;
    }
}
