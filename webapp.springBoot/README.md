# start webapp by spring boot

reference from https://youtu.be/vtPkZShrvXQ

## fakeDao command
```
curl http://localhost:8080/api/v1/Person
curl -H "Content-Type: application/json" -X POST -d '{"name":"Maria Jones"}' http://localhost:8080/api/v1/person
curl -H "Content-Type: application/json" -X POST -d '{"name":"Tom smith"}' http://localhost:8080/api/v1/person
```

## postgres command
```
docker run --name some-postgres --rm -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres:alpine
docker exec -ti some-postgres bin/bash
psql -U postgres
\l # list databases
\d # list detail
\c <database> #use <database>
\d <table> #list <table> detail
CREATE DATABASE demodb;
CREATE EXTENSION "uuid-ossp";
SELECT uuid_generate_v4();
INSERT INTO person (id, name) VALUES (uuid_generate_V4(), 'Maria Jones');
INSERT INTO person (id, name) VALUES (uuid_generate_V4(), 'Tom Smith');
```
