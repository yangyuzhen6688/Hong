# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

- **Build**: `mvn clean install`
- **Compile**: `mvn compile`
- **Run tests**: `mvn test`
- **Run application**: `mvn spring-boot:run` or run `HongApplication.java` main class
- **Package**: `mvn package` (creates executable jar)

## Architecture

This is a Java Spring Boot 2.6.13 Maven project following a standard layered architecture:

- **controller**: HTTP request handlers
- **service**: Business logic layer (interface + impl)
- **dao**: Data access layer
- **entity**: Database entities
- **mapper**: MyBatis mappers
- **dto/vo**: Data transfer objects and view objects
- **config**: Configuration classes
- **resources/mappers**: MyBatis XML mapper files

## Included Dependencies

- Spring Web
- Spring Data MongoDB
- Spring Data Redis
- Spring AMQP (RabbitMQ)
- MyBatis with MySQL Connector
- Lombok
- Spring Boot Test

## Configuration

Main configuration file: `src/main/resources/application.yml`
- Server port: 8080
- MyBatis mapper locations: `classpath:mappers/*xml`