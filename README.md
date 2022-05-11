# Exchanger
Currency exchange simulator using NBP api (http://api.nbp.pl/).

An application for currency conversion that uses the NBP api. It allows you to exchange between two currencies. It has its own api and a built-in Swagger tool for graphical api browsing.

Basic functionalities of the application:
- displaying the list of available currencies for exchange
- displaying a list of the current rates of available currencies for exchange
- exchanging a given amount from one currency to another

## Run application
Commands in terminal (in main directory):  

To build jar

```
./mvnw clean package -DskipTests
```
To build docker image:
```
docker-compose up
```
To stop docker image:
```
docker-compose down
```

The app runs on: http://localhost:8080/

Swagger Ui runs on: http://localhost:8080/swagger-ui/


## Api query list of application:

1. Returns a list of available code currencies
```
/api/currencies/codes
```

2. Returns a list of the exchange rates of the available currencies:
```
/api/currencies
```

3. Returns a list of currency exchange (without parameters returns all list items). Contains pagination with the number of the displayed page and the number of elements on the page.  
Optional parameters: 
- **page** which results page to display
- **size** how many results per page to display
```
/api/exchanges

api/exchanges?size=3&page=4
```

4. Returns a specific exchange by id (where id is number):
```
/api/exchanges/id
```

5. Returns information about the currency exchange: 

Making a currency exchange. 
Required parameters: 
- **sum** as floating point number
- **in** as currency code to be exchanged
- **out** as the code of the currency to which the exchange is made
```
/api/exchanges/exchange?sum=100&in=eur&out=usd

```

6. Returns information about all operations related to the currency exchange (without parameters returns all list items). Contains pagination with the number of the displayed page and the number of elements on the page and filtering the results by status.  
Optional parameters: 
- **status** as kind of operation, possible values: GET_CURRENCIES, GET_RATES, EXCHANGE_CURRENCY.
- **page** which results page to display
- **size** how many results per page to display
```
/api/operations

/api/operations?status=EXCHANGE_CURRENCY,GET_RATES

/api/operations?page=2&size=2&status=EXCHANGE_CURRENCY
```

7. Returns a specific operation by id (where id is number):
```
/api/operations/id
```
