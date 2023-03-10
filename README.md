# Crypto-Parser

### Project description:
This is a simple project that allows us to create a cron job timer that runs every 10 seconds and pulls cryptocurrency
last prices from CEX.IO, generate a CSV report and get the necessary information using following endpoints:

- GET /cryptocurrencies/minprice?name=[currency_name] - should return record with the lowest price of selected
  cryptocurrency.
- GET /cryptocurrencies/maxprice?name=[currency_name] - should return record with the highest price of selected
  cryptocurrency [currency_name] possible values: BTC, ETH or XRP.
- GET /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - should return a selected page with
  selected number of elements and default sorting should be by price from lowest to highest.

### Used technologies and libraries:
- String Boot, Spring Data.
- MongoDB
- Docker
- Java 11
- REST API https://cex.io/rest-api

### Steps to run the program on your computer:
- Fork the project and clone it.
- Add your information to docker-compose.yaml and resources/application.properties to be able to use Mongo Express. Also
  correct a file path in CsvService.
- Run the project.
