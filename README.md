# it-center

## PREREQUISITES
+ nodejs@8.9.0
+ Wildfly@10.2.0

## HOW TO RUN
#### 1. FRONT END
+ `cd` (change directory) to `frontend` directory then execute the command:
```
npm install
```
+ Then execute the command:
```
npm start
```
+ Frontend Application will be available at: `localhost:4200`.
#### 2. BACK END
+ Download and Deploy PostgresSQL JDBC driver (Since we use PostgreSQL as our DBMS). The driver can be download [here](https://jdbc.postgresql.org/download.html).
+ Add new Datasource: 
    + In Wildfly Management UI, navigate accordingly: `Configuration > Subsystem > Datasources > Non-XA > Add`.
    + Choose PostgreSQL Datasource.
    + Step 1/3: Change `Name` field to: `itcenterds`, `JNDI Name` field to: `java:/itcenterds`.
    + Step 2/3: Navigate to `Detected Driver` tab, choose postgresql driver which we deployed in first step.
    + Step 3/3: Change `Connection URL` to: `jdbc:postgresql://localhost:5432/[Your Database For Application]`, then fill `username` and `password` field.

+ Deploy Backend service:
+ `cd` (change directory) to `backend` directory then execute the command:
```
mvn clean install
```
+ Compiled code will be available at `backend/target`.
+ After building backend service with Maven, access Wildfly Management UI, deploy `.war` file located in the path `backend/target/itcenter.war`.
+ Backend service will be available at: `localhost:8080/itcenter/api/<resource>`.