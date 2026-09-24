# DevOps_Gruppe_9

## Projektbeschreibung

Dieses Projekt wurde im Rahmen des Moduls **DevOps** umgesetzt.

Ziel ist der Aufbau einer reproduzierbaren CI/CD-Umgebung für eine kleine Spring-Boot-REST-API.

Der grundlegende Ablauf ist:

**Codeänderung → GitHub → GitHub Actions → Maven Build & Tests → Docker Image → GHCR → Docker Compose / Watchtower**

---

# Schnellstart

## Voraussetzungen

Bevor das Projekt gestartet werden kann, müssen einige Programme auf dem Rechner installiert sein.

### Git

Git wird benötigt, um das Projekt von GitHub auf den eigenen Rechner herunterzuladen.

Download:

[Git für Windows herunterladen](https://git-scm.com/install/windows)

---

### Docker Desktop

Docker Desktop wird benötigt, um die Anwendung als Docker-Container zu starten.

Docker Compose ist bereits in Docker Desktop enthalten und muss nicht zusätzlich installiert werden.

Download:

[Docker Desktop herunterladen](https://www.docker.com/products/docker-desktop/)

Wichtig: Docker Desktop muss vor dem Start der Anwendung geöffnet sein.

---

### Java JDK 17

Java 17 wird benötigt, wenn die Spring-Boot-Anwendung direkt aus dem Quellcode gebaut werden soll.

Download:

[Java JDK 17 herunterladen](https://adoptium.net/de/temurin/releases?version=17)

---

### Apache Maven

Maven wird für den Build der Anwendung verwendet.

Download:

[Apache Maven herunterladen](https://maven.apache.org/download.cgi)

Direkter Download:

[Apache Maven 3.9.16 herunterladen](https://dlcdn.apache.org/maven/maven-3/3.9.16/binaries/apache-maven-3.9.16-bin.zip)

--- 

## Installation prüfen

Nach der Installation kann überprüft werden, ob die benötigten Programme verfügbar sind:

```bash
git --version
docker --version
docker compose version
```

Wenn die Anwendung zusätzlich direkt aus dem Quellcode gebaut werden soll, muss **Java 17** vorhanden sein:

```bash
java -version
```

Der im Repository enthaltene Maven Wrapper kann unter Windows mit folgendem Befehl geprüft werden:

```bash
mvnw.cmd -version
```

---

## 1. Repository herunterladen

```bash
git clone https://github.com/Stylianos20/DevOps_Gruppe_9.git
```

Danach in den Projektordner wechseln:

```bash
cd DevOps_Gruppe_9
```

---

## 2. Docker-Image laden

Das aktuelle Docker-Image aus der GitHub Container Registry wird mit folgendem Befehl geladen:

```bash
docker compose pull
```

---

## 3. Anwendung starten

```bash
docker compose up -d
```

Der Parameter `-d` startet die Container im Hintergrund.

---

## 4. Container überprüfen

Mit folgendem Befehl kann geprüft werden, ob die Container laufen:

```bash
docker compose ps
```

Alternativ:

```bash
docker ps
```

---

## 5. Anwendung testen

Nach erfolgreichem Start können die REST-Endpunkte im Browser aufgerufen werden:

```text
http://localhost:8080/api/thema
```

```text
http://localhost:8080/api/mitglieder
```

```text
http://localhost:8080/api/abgabedatum
```

Wenn die jeweiligen Antworten angezeigt werden, wurde die Anwendung erfolgreich gestartet.

---

## Logs anzeigen

Falls Probleme auftreten, können die Container-Logs angezeigt werden:

```bash
docker compose logs -f
```

---

## Anwendung beenden

Die laufenden Container können mit folgendem Befehl beendet werden:

```bash
docker compose down
```

---

## Projektgruppe

**Gruppe 9**

- Mahmut Ural
- Stylianos Papadimitriou
- Yasmina Bouraauan
