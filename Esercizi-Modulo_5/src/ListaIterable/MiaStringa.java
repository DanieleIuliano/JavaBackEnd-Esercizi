package ListaIterable;

import java.util.ArrayList;

public class MiaStringa implements Iterabile{
    ArrayList<Character> lista = new ArrayList<>();
    static int contatore = 0;

    public MiaStringa() {
    }

    public void add(char a ){
        lista.add(a);
    }
    @Override
    public Character get(int i) {
       return lista.get(i);
    }

    @Override
    public boolean contains(Object o) {
        return lista.contains(0);
    }


    @Override
    public int size() {
        if(lista.size() == 0)
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
