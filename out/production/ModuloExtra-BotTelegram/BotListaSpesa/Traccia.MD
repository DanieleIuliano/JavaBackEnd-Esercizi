Lista della spesa 🛵


@insta_della_spesa

Realizzate un bot che gestisca una lista della spesa e che abbia le seguenti funzionalità:

Quando l'utente invia il comando "/start", il bot risponde con un messaggio di benvenuto e un tastierino con le seguenti caratteristiche:

La prima riga con un solo bottone con scritto "Lista della spesa"
Seconda riga con un bottone con scritto "Aggiungi" e uno "Rimuovi"
Cliccando sul tasto aggiungi l'utente può aggiungere un prodotto alla lista della spesa assieme alla quantità del prodotto nel formato di stringa "<nomeprodotto>-<quantità>" esempio: "Monster energy-5", se l'utente inserisce solo il nome prodotto, il bot capisce da solo che la quantità è 1.

Quando l'utente clicca su "Lista della spesa" il bot invia un messaggio con la lista della spesa, ogni elemento della spesa viene stampato con assieme al suo indice di posizione e alla quantità, esempio:

0 Monster 50

1 Yogurt muller 1

Quando l'utente preme il tasto "Rimuovi", il bot chiede all'utente l'indice dell'elemento della lista da rimuovere.
Il bot deve permettere ad ogni utente di avere la propria lista, perciò la lista dei prodotti non è condivisa. Per ogni utente c'è solo una lista della spesa. 🥰

Hint: Ogni utente ha il proprio identificativo telegram univoco
