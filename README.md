# Rule Application
This app is developed on Spring Boot with Java 17.
## Setting up
1. Only thing you need is to create a database in PostgreSQL with the name "rules" and set the appropriatee user and password for your postgres server.
2. Clone this repository, build with maven and start the server.
3. Unit and integration tests are available.
## Data Layer
Used Spring Data JPA and Hibernate with PostgreSQL as the main database and H2 as the testing database.
## Security Layer
Currently we only have disabled cors and csrf, we can further upgrade this by adding login and register functionality with tokens or cookies as Session Management.
## Available endpoints:
1. POST "/rules" - creates a new rule by json body
2. GET "/rules" - returns all rules in db.
3. GET "/rules/{id}" - returns a single rule by given id.
4. PUT "/rules/{id}" - updates rule by given id. ruleName and rule parametres.
5. DELETE "/rules/{id}" - deletes rule by given id.
6. POST "/execute" - executes different rules dynamically by the number of given parametres (params in the request parametres: "..?params=12&params=test&params=test"). If given one parametre - application assumes it's only the id, so it deletes the rule by id. If given two parametres - application assumes no id is passed so it creates an entity with generated id and rulename=param1, rule=param3. If given 3 parametres - application updates entity by id with the other parametres.
