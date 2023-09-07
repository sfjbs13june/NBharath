## Student Application

### Build Application
    mvn clean install

### Run the application
    mvn spring-boot:run

### Test the application

#### Create or store student
    curl --location --request POST 'http://localhost:8080/create' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name":"abc",
    "rollNo":"1230",
    "age":13,
    "std":"8th"
    }'

#### Read Student data
    curl --location --request GET 'http://localhost:8080/read?name=abc'

#### Update student details

    curl --location --request PUT 'http://localhost:8080/update?name=abc&age=12'

#### delete student details
    curl --location --request DELETE 'http://localhost:8080/delete?name=abc'