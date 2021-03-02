# AWS-S3 Upload Images


All the project was made using:

* Hexagonal Architecture or Ports and Adapters
* Java 11
* Maven version 3.6.3
* H2 Database Engine
* IntelliJ IDEA IDE


## Prerequisites

* Install Java 8 or higher, download from this link [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Install Maven, download from this link [here](https://maven.apache.org/download.cgi). This article shows [how configure maven on Windows](https://www.mkyong.com/maven/how-to-install-maven-in-windows/).
* Install Docker, download from this link [here](https://www.docker.com/community-edition)
* Install Kitematic, download from this link [here](https://kitematic.com)

## Setup

1) Clone the project from the repository.

```
git clone https://github.com/jsneider05/aws-s3-spring-boot.git
```

2) In the development IDE, create the configuration to run the SpringBoot project and create the environment variables:

```properties
AWS_S3_ACCESS_KEY=aws_s3_access_key
AWS_S3_SECRET_KEY=aws_s3_secret_key
AWS_S3_BUCKET_NAME=bucket_name
```

## Run the project

1) Clean and install dependencies

```bash
cd aws-s3-spring-boot
mvn clean install -U
```

2) Run the project as a jar:

```bash
cd aws-s3-spring-boot/target
java -jar aws-s3-${project.version}.jar
```
Or, as a Spring Boot Application with
```bash
mvn spring-boot:run
```
```bash
./mvnw spring-boot:run
```

## Swagger UI

|Proyecto|URL|
|--------|---|
|Aws-S3|[http://localhost:8085/api/swagger-ui.html](http://localhost:8080/api/swagger-ui.html)|
