#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mysql.yml up -d

mvn spring-boot:run

docker-compose -f docker-compose-mysql.yml down

```
## Getting inside container

docker exec -it <container-id> /bin/bash \

mysql -u user -p \

show databases; \

use db; \

show tables; \

select * from user; \