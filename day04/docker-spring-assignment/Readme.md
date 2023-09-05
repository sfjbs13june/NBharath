## Docker Assignment

### Build application

    mvn clean install

### Run Application
    mvn spring-boot:run

### Create docker image

    mvn install dockerfile:build

## Run docker image

    docker run -p 8080-8080 falcon007/docker-spring-app:1.0.0