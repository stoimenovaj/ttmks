## Web RESTfull service
### Spring Boot application

RESTfull web service app built with Spring Boot. It "wraps" the database and exposes its data to clients through HTTP.

---
#### Characteristics
- Layered architecture
    - Repository, Service, Web
- String Data `JPA` as ORM
    - The complex queries defined in previous phases are constructed through the `JPA` repositories
- Reverse engineered models
    - The models are reverse engineered from the database tables with the help of `Hibernate` tools, `mvn` and `ant`
    - `reverse/`
- Spring security
    - Authentication and authorization with JWT tokens
- Java 8
