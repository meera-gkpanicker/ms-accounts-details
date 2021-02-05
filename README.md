# ANZ-INFOSYS Backed-end Restful Services!

This project provides the following APIs and is developed using spring boot, gradle and adding new API for fetching account list and transactions by each account.

1. An API that allows clients to retrieve the accounts list with basic account attributes.
2. An API that allows clients to retrieve transactions of an account

## Project Repo URL
https://github.com/meera-gkpanicker/ms-accounts-details.git

# Follow the below steps to build and run this application:

1. Clone the project and import the same in an IDE (IntelliJ/STS).
2. Build the project from terminal using the command ./gradlew bootJar 
3. After build completes, run the jar file in the target folder using the command

**java -jar build/libs/ms-accounts-details-1.0-SNAPSHOT.jar **

4. The microservices will run on the port 8090 using the context path **/ms-accounts-details **
7. Refer to the below curl commands

## Testing RESTful Services

1. Retrieve Accounts List:
		
		$ curl -X GET \
            http://localhost:8090/ms-accounts-details/accounts/list \
            -H 'cache-control: no-cache' \
            -H 'postman-token: ba884e72-ee6a-273f-b95a-57f9074eb512'

		

2. Retrieve By AccountNumber:
$ curl -X GET \
            http://localhost:8090/ms-accounts-details/accounts/123456 \
            -H 'cache-control: no-cache' \
            -H 'postman-token: bc17f4e5-8106-529f-3767-9af1bfcd0650'




