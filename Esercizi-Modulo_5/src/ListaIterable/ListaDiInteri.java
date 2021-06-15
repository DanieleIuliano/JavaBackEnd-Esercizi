package ListaIterable;


import java.util.ArrayList;

public class ListaDiInteri implements Iterabile {
    ArrayList<Integer> lista = new ArrayList<>();
    static int contatore = 0;


    public ListaDiInteri() {
    }

    public void add(int a){
        lista.add(a);
    }
    @Override
    public Integer get(int i) {
        return lista.get(i);
    }

    @Override
    public boolean contains(Object o) {
        return lista.contains(o);
    }

    @Override
    public int size() {
        if(lista.size() ==  0)
        return 0;
        else return lista.size();
    }

    @Override
    public boolean remove(int i) {
       lista.remove(i);
       return true;
    }

    @Override
    public void clear() {
        lista.clear();
    }
}
