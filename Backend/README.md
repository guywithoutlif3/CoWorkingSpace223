# backend Project

Dieses Projekt ist das Backend für eineen Co-Working Space

## Projekt aufsetzten

1. Erstelle eine Kopie (fork) von diesem Projekt.
2. Stelle sicher, dass Docker installiert ist und läuft.
3. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
4. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
5. Öffne das Projekt mit Visual Studio Code.
6. Öffne das Projekt im Entwicklungscontainer.
7. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project` oder `mvn quarkus:dev ` 
8. Probiere die Client-Applikation unter http://localhost:8080 aus.
9. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/backend-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Creating a native executable

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.


## Testdaten

Die Testdaten befinden sich in `src/main/resources/import.sql` und werden bei erstem Start des projekt geladen

## Pfad des githubs

https://github.com/guywithoutlif3/CoWorkingSpace223

## Kommentar zu umsetzung

mir ist jetzt 16:00 noch der Logik fehler aufgefallen das bei der "registrierung" die Rollle mitgegeben werden muss was wenig sinn ergibt, dies ist mir bewusst aber dieses Modul ist so wie so ein aboluter time crunch also habe ich jetz keine Zeit mehr dies zu lösen und sage als argumentation das dies im Frontend dann gelöst wird (;