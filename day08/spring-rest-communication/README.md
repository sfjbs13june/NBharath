## Build Appication
    mvn clean install
## Run application

### Run spring-caller
    mvn spring-boot:run
### Run spring-receiver
    mvn spring-boot:run

## Test application

### Receiver test
    curl --location --request GET 'http://localhost:8082/receive'

### Caller test
    curl --location --request GET 'http://localhost:8081/caller'