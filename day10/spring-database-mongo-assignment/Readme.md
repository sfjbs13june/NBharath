
# Build Mongo Docker file to test
```
docker-compose -f docker-compose-mongo.yml up -d
```

# Build and run 
````
mvn clean install
````
````
mvn spring-boot:run
````


## Test the application with the above run using postman
stop the container and delete it 
````
docker rm <mongo-container-id>
````

# Starting both mongo and applicaiton inside a docker container

first build docker container with the below commands
```
mvn clean install
````
````
mvn install dockerfile:build
````

# Then run the below command to run both mongo and application containers
````
docker-compose -f docker/docker-compose.yml up -d
````

## Getting inside container
````
docker exec -it <container-id> /bin/bash
````
````
mongo
````
````
show dbs;
````
````
db.hospital.find()
````
````
db.patient.find()
````

# Requests from Postman
## Hospital
### POST
````
curl --location 'http://localhost:8083/hospital/savehospital' --header 'Content-Type: application/json' --data '{"hospitalName": "Deccan","address": "Chintamani"}'
````
### GET
````
curl --location 'http://localhost:8083/hospital/hospitalrecords'
````
### PUT
````
curl --location --request PUT 'http://localhost:8083/hospital/edithospital?name=Deccan&address=Chintamani' --header 'Content-Type: application/json' --data '{"hospitalId":1,"hospitalName": "Deccan","addresss": "Chintamani"}'
````
### DELETE
````
curl --location --request DELETE 'http://localhost:8083/hospital/deletehospital?name=Deccan'
````

## Patient
### POST
````
curl --location 'http://localhost:8083/patient/savepatient' --header 'Content-Type: application/json' --data '{"patientName":"Bharath","hospitalName": "RK","disease": "Fever"}'
````
### GET
````
curl --location 'http://localhost:8083/patient/patientrecords'
````
### PUT
````
curl --location --request PUT 'http://localhost:8083/patient/editpatient?name=Bharath&hospital=Deccan'
````
### DELETE
````
curl --location --request DELETE 'http://localhost:8083/patient/deletepatient?name=Bharath'
````