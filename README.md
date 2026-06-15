# Football Tournament - SIW 2025/2026

Progetto realizzato per il corso **Sistemi Informativi su Web**.

Applicazione Web per la gestione di tornei di calcio amatoriale.

Il sistema permette la gestione completa di tornei, squadre, giocatori, partite, risultati, classifiche e commenti degli utenti.

---

## Tecnologie utilizzate

- Java
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- Thymeleaf
- React
- PostgreSQL
- Bootstrap
- HTML / CSS

---

## Architettura

Il progetto segue un'architettura a livelli:

- Controller Layer  
  Gestione delle richieste HTTP

- Service Layer  
  Implementazione della logica applicativa e gestione delle transazioni

- Repository Layer  
  Accesso ai dati tramite Spring Data JPA

---

## Entità principali

- Torneo
- Squadra
- Giocatore
- Partita
- Arbitro
- Commento
- Utente

---

## Funzionalità pubbliche

- Visualizzazione elenco tornei
- Visualizzazione dettaglio torneo
- Visualizzazione squadre partecipanti
- Visualizzazione calendario partite
- Visualizzazione dettaglio squadra e giocatori
- Visualizzazione dettaglio giocatore
- Visualizzazione classifica torneo

---

## Funzionalità utenti registrati

- Login utente
- Inserimento commenti sulle partite
- Modifica dei propri commenti

---

## Funzionalità amministratore

- Creazione e modifica tornei
- Creazione e modifica squadre
- Creazione e modifica giocatori
- Creazione partite
- Inserimento risultati
- Eliminazione squadre e partite
- Upload immagini di squadre e giocatori

---

## Sicurezza

Sono presenti autenticazione e autorizzazione tramite Spring Security.

Ruoli disponibili:

- ADMIN
- USER

---

## Ottimizzazione accesso ai dati

Sono state analizzate diverse strategie JPA/Hibernate:

- Fetch LAZY
- Join Fetch
- EntityGraph

con confronto delle prestazioni per evitare il problema N+1 query.

---

## Credenziali di test

### Amministratore

Username:

admin

Password:

password


### Utente

Username:

user

Password:

password


---

## Funzionalità aggiuntive implementate

- Upload immagini
- Ricerca e filtri
- Validazione dei dati
- Gestione degli errori
- Interfaccia responsive con Bootstrap

