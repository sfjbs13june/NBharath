## Student protected url with spring security

### build application

    mvn clean install

## send request

    user username and password(user123`,password)

    admin username and password(admin, password)

## Send request

    curl --location --request GET 'http://localhost:8080/getstudent' --header 'Authorization: Basic dXNlcjEyMzpwYXNzd29yZA==' 
