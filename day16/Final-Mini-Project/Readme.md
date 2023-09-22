
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

### first build docker container of the application with the below commands
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
## Doctor
### POST
````
curl --location 'http://localhost:8083/doctor/save' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic ZG9jdG9yMTI6ZG9jdG9yJ3NwYXNzd29yZA==' \
--data '{
    "appointmentId" : "5",
    "patientName": "Sindhu",
    "doctorName" : "Latha",
    "date" : "12102001",
    "prescription" : {
        "prescriptionId" : "12f3",
        "appointmentId" : "5",
        "description" : "Patient was diagnosed with cold and cough",
        "patientName" : "Sindhu",
        "doctorName" : "Latha"
    }
}'
````
### GET
````
curl --location 'http://localhost:8083/doctor/doctorappointment?doctorName=Latha' \
--header 'Authorization: Basic ZG9jdG9yMTI6ZG9jdG9yJ3NwYXNzd29yZA=='
````

## Patient
### POST
````
curl --location 'http://localhost:8083/patient/save' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic cGF0aWVudDEyOnBhdGllbnQnc3Bhc3N3b3Jk' \
--data '{
    "appointmentId" : "1",
    "patientName": "Bharath",
    "doctorName" : "Sridhar",
    "date" : "20052000",
    "prescription" : {
        "prescriptionId" : "12e3",
        "appointmentId" : "1",
        "description" : "Patient was diagnosed with Fever",
        "patientName" : "Bharath",
        "doctorName" : "Sridhar"
    }
}'
````
### GET
````
curl --location 'http://localhost:8083/patient/myappointment?patientName=Bharath' \
--header 'Authorization: Basic cGF0aWVudDEyOnBhdGllbnQnc3Bhc3N3b3Jk'
````

## Prescription
### GET
````
curl --location 'http://localhost:8083/prescription/viewprescription?patientName=Bharath' \
--header 'Authorization: Basic cGF0aWVudDEyOnBhdGllbnQnc3Bhc3N3b3Jk' \
````
### POST
````
curl --location 'http://localhost:8083/prescription/saveprescription' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic cGF0aWVudDEyOnBhdGllbnQnc3Bhc3N3b3Jk' \
--data '{
    "prescriptionId": "123",
    "appointmentId": "2",
    "description": "Patient had fever",
    "patientName": "Bhaskar",
    "doctorName": "Sridhar"
}'
````


## Swagger DOC

### Use the below url to get the swagger docs

````
http://localhost:8083/swagger-ui.html
````