package Librera_V2;

import java.util.*;

public class Biblioteca {
    private int contatore;

    Map<Autore, List<Libro>> biblioteca = new TreeMap<>();

    public void addLibro(Autore autore, Libro libro) {

        autore.addLibro(libro);
        if (biblioteca.containsKey(autore)) {
            biblioteca.get(autore).add(libro);

        } else biblioteca.put(autore, Collections.singletonList(libro));

    }

    public void removeLibro(Libro libro) {
        for (Autore aut : biblioteca.keySet()) {
            if (biblioteca.get(aut).contains(libro))
                biblioteca.get(aut).remove(libro);
        }

    }

    public boolean cercaLibro(String codice) {
        for (Autore aut : biblioteca.keySet()) {
            Iterator<Libro> iteratore = aut.getListaLibri().iterator();
            while (iteratore.hasNext()){
                if(iteratore.next().getIdUnivoco().equals(codice) || iteratore.next().getTitolo().equals(codice)){
                    return true;
                }
            }
        }
        return false;
    }

    public void cercaLibro(Autore autore) {
        if(biblioteca.containsKey(autore)){
            autore.toString();
        }else System.out.println("Autore non trovato");
    }

}


