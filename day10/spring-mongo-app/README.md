## Build the app

``` 
mvn clean install
```

## Run the app

``` 
docker-compose -f docker-compose-mongo.yml up -d
mvn spring-boot:run

```
## Creating docker image

```
mvn install dockerfile:build

```
## running docker compose

``` 
docker-compose up -d

```


## Post

``` 
curl --request POST 'http://localhost:8083/customer/create' --header 'Content-Type: application/json' --data-raw '{"name": "Rama","custId": "1re206","address": "Bangalore"}'
```

## Get 

``` 
curl -X GET http://localhost:8083/customer/read 
```

## Put

``` 
curl -X PUT 'http://localhost:8083/customer/update?custId=1re07&name=Rama' 
```

## Delete

```
curl -X DELETE 'http://localhost:8083/customer/delete?name=Rama' 
```




## Show data

```
docker exec -it spring-mongo-app-mongo-1 bash

mongo

show dbs

show tables

db.customer.find()

```

## Stop docker container
    docker-compose -f docker-compose-mongo.yml down

## Dockerization

### Maven 
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

```
### Student

## POST

``` 
curl --location 'http://localhost:8083/student/create' \
--header 'Content-Type: application/json' \
--data '{"name": "Mathrusri","id": "123","roll":"12"}'
```

### GET

```
curl --location --request GET 'http://localhost:8083/student/read'
```

### GET

````
curl --location --request GET 'http://localhost:8083/student/read/Mathrusri' \
--header 'Content-Type: application/json' 
````
