# Useful commands

### Run posgres sql docker engine
`docker pull postgres:15.1` <br>

`docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres:15.1`

`su - postgres` <br>
`psql` -> Pres enter

### Create database command

`CREATE DATABASE "school-library"`

### Create user and grand all permission
`CREATE USER "school-library-admin" WITH PASSWORD 'mysecretpassword';`  <br>
`GRANT CREATE ON DATABASE "school-library" TO "school-library-admin";` <br>

Granding all permissions inside the database
`GRANT ALL PRIVILEGES ON DATABASE "school-library" TO "school-library-admin";`


Grand Permission to schema

`GRANT USAGE ON SCHEMA "school-library" TO "school-library-admin";`

### Revoke all previllages

`REVOKE ALL PRIVILEGES ON DATABASE "school-library" FROM "school-library-admin";`
