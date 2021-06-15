Bot base 🛴
In questo esercizio dovete realizzare un bot con le seguenti caratteristiche:

Quando l'utente scrive "ciao" il bot risponde salutando con la stringa "Ciao :nickname:, come stai?" dove al posto di :nickname: ci va il nickname dell'utente. Se il nickname dell'utente non è definito il bot utilizza il nome dell'utente.
Quando l'utente scrive "tastiera" il bot risponde con un messaggio di testo con scritto "Ecco la tastiera" che attiva per l'utente una tastiera formata da una sola riga in cui il primo pulsante ha l'emoji dell'monopattino, il secondo dello scooter e il terzo della moto. Quando l'utente invia il monopattino il bot risponde con "Esercizio Facile", quando invia lo scooter con "Esercizio medio" e infine con la moto risponde "Esercizio avanzato"
Se l'utente invia uno sticker, il bot risponde prima con "Bello sto sticker! guarda questo" Guarda questo invece" e successivamente invia nuo sticker a vostra scelta.
Hint: Dove trovare le info utente

Hint mandatory: Per realizzare questo bot, piuttosto che fare un groviglio di if else dei comandi, realizzate una classe enum che dalla stringa crea l'enum del comando e successivamente con un costrutto switch il bot gestisce i comandi. Esempio:
