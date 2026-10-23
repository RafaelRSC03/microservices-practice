# Learnt stuff


### Properties variables

Although different java libraries need different properties variables, some are mandatory to know.

#### Database configs
For all jpa instances it is necessary to include this line.

``` 
# Values can be update, create, create-drop
spring.jpa.hibernate.ddl-auto=update

```

Jpa connectors and stuff need their own configs here are a few:

**H2**
It is an embedded database, that doesn't change the fact that it is rather useful for small scale projects or no required fully persistent stored data testing.

``` 
    spring.h2.console.path=/h2-console
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driver-class-name=org.h2.Driver


    spring.datasource.username=username
    spring.datasource.password=password


    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```


### Modelling

- Ids are usually UUIDs in order to not compromise security or making user ids easily readable.
