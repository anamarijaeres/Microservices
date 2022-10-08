# Microservices

The goal of the laboratory exercise is to build a simple distributed system based on microservices and containers. Implementation microservices using the Spring Boot framework and the Docker containerization tool. This exercise consists of:
- design and implementation of microservices for obtaining temperature and humidity
- design and implementation of microservices for retrieving aggregated temperature values and humidity
- design and implementation of the configuration server for retrieving configuration data when starting the microservice
- design and implementation of the registration server for registration and discovery of microservices
- containerization of created microservices and their execution using the Docker Compose tool





## Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

Requirements for the software and other tools to build, test and push 
- [Java 8 SDK or newer](https://www.oracle.com/es/java/technologies/javase/javase8-archive-downloads.html)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)
- [DockerCompose](https://docs.docker.com/compose/)

### Installing

To avoid starting containers individually, Docker Compose is used. Since microservices for aggregation, temperature and humidity depend on the configuration and registration server,
the configuration and registration server must be started first. Define the configuration file
which Docker Compose uses to run only the configuration and registration server,
for example, by creating a docker-compose-infrastructure.yml file and running the command
    
    docker-compose -f docker-compose-infrastructure.yml up
 
Also, define the configuration file that Docker Compose uses to run microservices for aggregation, temperature, and moisture, for example, by creating a docker-compose-services.yml file and running the command
    
    docker-compose -f docker-compose-services.yml up



## Authors

  - **Ana Marija Ereš** 


