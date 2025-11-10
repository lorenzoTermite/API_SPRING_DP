# 🏗️ Progetto TNzDpRe – Spring Boot REST API

Questo progetto espone delle API REST sviluppate in **Spring Boot** per l’esecuzione e il monitoraggio di query SQL su database **Oracle**.  
L’obiettivo principale è popolare e analizzare la tabella `TNzDpRe` partendo da una data di riferimento.

---

## 🚀 Funzionalità principali

- **Esecuzione di query SQL** tramite DAO e script `.sql` presenti in resources/sql
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

## 🌐 Endpoint REST – TNzDpReController

La classe `TNzDpReController` espone le API REST per interagire con la tabella `TNzDpRe`.  
Ogni endpoint utilizza il servizio `TNzDpReService`, che a sua volta comunica con il livello `DAO` per eseguire le query sul database Oracle.

### 📘 Lista degli endpoint principali

---

### 1️⃣ **GET /all/{referenceDate}**
**Descrizione:**  
Recupera tutti i record della tabella `TNzDpRe` filtrati in base alla data di riferimento (`referenceDate`).

**Parametri:**
- `referenceDate` *(string, formato yyyy-MM-dd)* → Data di riferimento.

**Esempio di chiamata Swagger:**  
GET /all/2024-12-31
**Operazione SQL eseguita:**
```sql
SELECT * FROM TNZDPRE WHERE REFERENCE_DATE = TO_DATE(?, 'YYYY-MM-DD');




