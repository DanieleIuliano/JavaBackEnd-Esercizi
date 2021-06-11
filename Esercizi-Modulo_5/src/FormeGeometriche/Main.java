package FormeGeometriche;

public class Main {
    public static void main(String[] args) {
       FormeGeometriche quadrato = new Quadrato(5);
       FormeGeometriche rettangolo = new Rettangolo(3,5);
        System.out.println(quadrato.getArea());
        System.out.println(rettangolo.getArea());
        System.out.println(quadrato.getPerimetro());
        System.out.println(rettangolo.getPerimetro());
    }
}
