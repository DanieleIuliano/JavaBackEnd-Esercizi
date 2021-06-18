package SuperMercato_Esercizio;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Supermercato {
    PriorityQueue<Cliente> clienti = new PriorityQueue<>();

    public void addCliente(Cliente cliente) {
        clienti.offer(cliente);
        System.out.println("Hai inserito " + cliente.toString());
    }

    public void removeCliente() {
        if (clienti.isEmpty()) {
            System.out.println("Nessun cliente");
        } else
            clienti.poll();
            System.out.println("ho eliminato il primo cliente");
    }

    public Cliente stampaProssimoCliente() {
        if (clienti.isEmpty()) {
            System.out.println("Coda vuota!");
            return null;
        }
        Iterator<Cliente> iterator = clienti.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUniqueID().equals(clienti.peek().getUniqueID()))
                return iterator.next();
        }
        return null;
    }

    public void stampaCoda() {
        for (Cliente c : clienti) {
            System.out.println(c.toString());
        }
    }

    public void dimensioneCoda() {
        System.out.println(clienti.size());
    }


}
