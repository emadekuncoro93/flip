## Requirement
- java 11
- maven

## Setup Database
- create database
- update src/main/resources/application.properties
- update connection as you need
- run query in src/main/resources/db/query.sql

## Install
- mvn clean install
- mvn spring-boot:run
- open browser http://localhost:8181/swagger-ui.html

## Run test
- mvn test