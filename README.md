# DevOps_Gruppe_9

## Projektbeschreibung

Dieses Projekt wurde im Rahmen des Moduls DevOps umgesetzt.

Ziel des Projekts ist der Aufbau einer reproduzierbaren CI/CD-Umgebung für eine kleine Spring-Boot-REST-API. Der Schwerpunkt liegt dabei auf dem automatisierten Ablauf von einer Codeänderung bis zur containerisierten Anwendung.

Der grundlegende Ablauf ist:

**Codeänderung -> GitHub -> GitHub Actions -> Maven Build & Tests -> Docker Image -> GitHub Container Registry (GHCR) -> Docker Compose / Watchtower**

Die Spring-Boot-Anwendung wurde bewusst einfach gehalten, da der Fokus des Projekts auf der CI/CD-Pipeline, der Containerisierung und dem Deployment liegt.

---

## Verwendete Technologien

Im Projekt werden folgende Technologien eingesetzt:

- Java 17
- Spring Boot 4.1.1
- Maven / Maven Wrapper
- Git
- GitHub
- GitHub Actions
- Docker
- Docker Compose
- GitHub Container Registry (GHCR)
- Watchtower
- CodeQL

---

## Voraussetzungen

Für den Start über Docker werden benötigt:

- Git
- Docker Desktop bzw. Docker Engine
- Docker Compose v2
- Internetzugang

Für den Start direkt aus dem Quellcode werden zusätzlich benötigt:

- Java JDK 17
- IntelliJ IDEA, Visual Studio Code oder eine andere Java-IDE

Eine separate Maven-Installation ist nicht zwingend erforderlich, da sich der Maven Wrapper bereits im Repository befindet.

---

## Repository herunterladen

Das Repository kann mit folgendem Befehl geklont werden:

```bash
git clone https://github.com/Stylianos20/DevOps_Gruppe_9.git
```

Danach in den Projektordner wechseln:

```bash
cd DevOps_Gruppe_9
```

---

## Start mit Docker Compose

Die Datei `docker-compose.yml` verwendet das veröffentlichte Docker-Image aus der GitHub Container Registry und startet zusätzlich Watchtower.

Zuerst sollte das aktuelle Image geladen werden:

```bash
docker compose pull
```

Danach können die Container gestartet werden:

```bash
docker compose up -d
```

Mit folgendem Befehl kann geprüft werden, ob die Container laufen:

```bash
docker compose ps
```

Alternativ:

```bash
docker ps
```

Die Logs können mit folgendem Befehl angezeigt werden:

```bash
docker compose logs -f
```

Zum Beenden der Container:

```bash
docker compose down
```

Die Anwendung ist anschließend über Port `8080` erreichbar.

---


## REST-Endpunkte

Die Anwendung stellt folgende REST-Endpunkte bereit:

### Projektthema

```text
GET /api/thema
```

Browser:

```text
http://localhost:8080/api/thema
```

Gibt das Thema des Projekts aus.

### Gruppenmitglieder

```text
GET /api/mitglieder
```

Browser:

```text
http://localhost:8080/api/mitglieder
```

Gibt die hinterlegten Gruppenmitglieder aus.

### Abgabedatum

```text
GET /api/abgabedatum
```

Browser:

```text
http://localhost:8080/api/abgabedatum
```

Gibt das hinterlegte Abgabedatum aus.

Dieser Endpunkt wird zusätzlich für den automatisierten HTTP-Smoke-Test verwendet.

---

## CI/CD mit GitHub Actions

Die CI/CD-Pipeline befindet sich in:

```text
.github/workflows/ci.yml
```

Der Workflow wird automatisch ausgeführt bei:

- einem Push auf `main`
- einem Pull Request gegen `main`

Die Pipeline führt unter anderem folgende Schritte durch:

1. Quellcode aus dem Repository laden
2. Java 17 einrichten
3. Maven Build durchführen
4. vorhandene automatisierte Tests ausführen
5. Docker-Image erstellen
6. Test-Container starten
7. HTTP-Smoke-Test durchführen
8. Anmeldung an der GitHub Container Registry
9. Docker-Image in GHCR veröffentlichen

Das verwendete Container-Image lautet:

```text
ghcr.io/stylianos20/devops_gruppe_9/devops-api-image:latest
```

---

## Automatisierte Tests

Beim Maven-Build wird der vorhandene Spring-Boot-Test

```text
DemoApplicationTests.contextLoads()
```

automatisch ausgeführt.

Der Test verwendet `@SpringBootTest` und prüft, ob der Spring-Anwendungskontext erfolgreich geladen werden kann.

Zusätzlich wird in der GitHub-Actions-Pipeline ein HTTP-Smoke-Test durchgeführt.

Dafür wird nach dem Docker-Build ein Test-Container gestartet und folgender Endpunkt aufgerufen:

```text
/api/abgabedatum
```

Die Pipeline führt mehrere Versuche durch, damit die Spring-Boot-Anwendung genügend Zeit zum Starten hat.

Der Smoke-Test gilt als erfolgreich, wenn der Endpunkt den HTTP-Status `200` zurückgibt.

---

## CodeQL – Code- und Sicherheitsanalyse

Zusätzlich zur CI/CD-Pipeline wurde GitHub CodeQL eingerichtet.

Die Konfiguration befindet sich in:

```text
.github/workflows/codeql.yml
```

CodeQL führt eine statische Analyse des Projekts durch und kann mögliche Sicherheitsprobleme oder auffällige Code-Stellen erkennen.

Im aktuellen Projekt werden unter anderem folgende Bereiche analysiert:

- Java
- GitHub Actions

Die Ergebnisse der Analyse können in GitHub im Bereich **Security and quality / Code scanning** eingesehen werden.

CodeQL ergänzt damit die automatisierten Tests um eine zusätzliche Code- und Sicherheitsanalyse.

---

## Docker Compose und Watchtower

Die Datei

```text
docker-compose.yml
```

startet die Spring-Boot-Anwendung sowie Watchtower.

Die Spring-Boot-Anwendung ist über Port `8080` erreichbar.

Watchtower überprüft regelmäßig, ob in der GitHub Container Registry eine neuere Version des Docker-Images vorhanden ist.

Wird eine neue Version gefunden, kann der laufende Anwendungscontainer automatisch aktualisiert werden.

Dadurch muss nach einer erfolgreichen Veröffentlichung eines neuen Images nicht jedes Mal manuell ein neuer Container gestartet werden.

---

## Projektstruktur

Die wichtigsten Dateien und Ordner des Projekts sind:

```text
DevOps_Gruppe_9
|
|-- .github
|   |
|   `-- workflows
|       |-- ci.yml
|       `-- codeql.yml
|
|-- .mvn
|
|-- src
|   |-- main
|   `-- test
|
|-- Dockerfile
|-- docker-compose.yml
|-- mvnw
|-- mvnw.cmd
|-- pom.xml
`-- README.md
```

---

## Projektgruppe

**Gruppe 9**

- Mahmut Ural
- Stylianos Papadimitriou
- Yasmina Bouraauan


