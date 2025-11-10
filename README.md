# 🏗️ Progetto TNzDpRe – Spring Boot REST API

Questo progetto espone delle API REST sviluppate in **Spring Boot** per l’esecuzione e il monitoraggio di query SQL su database **Oracle**.  
L’obiettivo principale è popolare e analizzare la tabella `TNzDpRe` partendo da una data di riferimento.

---

## 🚀 Funzionalità principali

- **Esecuzione di query SQL** tramite DAO e script `.sql`
- **Inserimento automatico di dati** nel DB (es. `fillTNzDpRe`)
- **Gestione dei parametri dinamici** (es. `referenceDate`)
- **Documentazione interattiva** tramite **Swagger UI**
- **Strutturazione multilayer (Controller, Service, DAO)**


---

## 🧱 Architettura del progetto

Il progetto segue il classico pattern **3-tier** di Spring Boot:

Swagger UI / Client HTTP
↓
Controller (gestisce la richiesta)
↓
Service (logica di business e transazioni)
↓
Repository / DAO (esecuzione query SQL)
↓
Database Oracle
