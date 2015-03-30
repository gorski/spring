content negotiation

Application responds with JSON or XML depending on the Accept header.

Mapped with Jackson.
Config in MainController (@RestController annotation)

QUICK-START
- execute: mvn clean tomcat:run
- go to http://localhost:8080/spring-context/
    send Accept header application/json OR application/xml (use rest client for that, like Postman or so)