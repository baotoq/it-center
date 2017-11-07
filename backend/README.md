# TODO-BACKEND APP
## 1. Prerequisites
+ Wildfly@10.2.0

## 2. Config Wildfly Server
+ Download and Deploy PostgresSQL JDBC driver (Since we use PostgreSQL as our DBMS). The driver can be download [here](https://jdbc.postgresql.org/download.html)
+ Add new Datasource: 
    + In Wildfly Management UI, navigate accordingly: `Configuration > Subsystem > Datasources > Non-XA > Add`
    + Choose PostgreSQL Datasource
    + Step 1/3: Change `Name` field to: `todods`, `JNDI Name` field to: `java:/todods`
    + Step 2/3: Navigate to `Detected Driver` tab, choose postgresql driver which we deployed in first step.
    + Step 3/3: Change `Connection URL` to: `jdbc:postgresql://localhost:5432/[Your Database For Application]`, then fill `username` and `password` field.
    
## 3. Integrate with Frontend application
Frontend application source code and build instruction can be found at: https://github.com/vunguyenhung/todo-frontend  
After building todo-frontend application, copy all files in `todo-frontend/dist` directory to backend application's source code with the path: `todo/src/main/webapp` with `Override all files` option.  

    
## 4. Deploy Backend Application
+ `cd` (change directory) to todo directory then execute the command: `mvn clean install`. Compiled code will be available at `todo/target`.
+ After building backend application with Maven, access Wildfly Management UI, deploy .war file located in the path `todo/target/todo.war`.
+ Backend Application will be available at: `localhost:8080/todo`
    


