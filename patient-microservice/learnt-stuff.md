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

**Logging**

Implementing logs is surprisingly easy as it is matter of configuring a few things.

- Add logger level to application.properties

```
    #info/warn/error
    logger.level.root=info
```
- Invoke Logger in all the classes that call the logger

```
    Logger log = LoggerFactory.getLogger(ContainedClass.class);
```

### Code structure

**Lambda functions**

The result of lambda functions is the return value from the method

```
    objectName -> method(objectName)
```

Lambdas can also have the following structure: 

```
    objectName -> {
        let var1 = method1(objectName);
        return method2(var1);
    }
```

When calling an method within .map or .foreach <u>Method References</u> can and should be used this example compares them to the equivalent lambda function:

```
    # lambda
    patients.stream().map(patient -> PatientMapper.toDto(patient)).toList();
    # Method reference
    patients.stream().map(PatientMapper::toDto).toList();
```

This lambda logic is used in many calls and can be called with _->_ or _=>_ depending on th language being used

A common use of lambdas is in subscribe functions for Angular this is an example of having a function bloc and next to the desired behaviour (next, error, complete) there is the lambda function:


```
    .subscribe({
        next: value => {console.log('Observable emitted the next value: ' + value)},
        error: err => console.error('Observable emitted an error: ' + err),
        complete: () => console.log('Observable emitted the complete notification')
    });
```

**Annotations**

Spring boot annotations serve multiple purposes here are some I didn't know exactly what they did:

- **_@Valid_**
    
    It is used to enforce validations present on models such validations as @Email or @NotNull.

    - To clean the response message it is compulsory to implement an exception handler such as this

        ``` 
            @RestControllerAdvice 
                public class GlobalExceptionHandler {
                    
                    @ExceptionHandler(MethodArgumentNotValidException.class)
                    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException mex){
                        
                        Map<String, String> errors = new HashMap<>();
                        mex.getBindingResult().getFieldErrors().forEach(error -> {errors.put(error.getField(), error.getDefaultMessage());});
                        return ResponseEntity.badRequest().body(errors);
                    }
                }
        ```

        **This does not work if the exception is being caught earlier (if there is a try_catch block it <u>_won't work_</u>)**

- **_@Validated(Default.class) / @Validated({Default.class, ValidationInterface.class})_**
    A few things to cover here, first of all, *@Validated(Default.class)* Does exactly the same as @Valid 
    This doesn't @Validated({Default.class, ValidationInterface.class})

    This basically means that you can assign certain validations to certain groups, all you need to do is create the inteface ValidationInterface and once it is created modify the @NotBlank annotation given to the attribute you want to assign that validation interface, for example:

    ```
        @NotBlank(groups = ValidationInterface.class, message = "Registered Date is required")
    ```




### Documentation

- ##### Swagger