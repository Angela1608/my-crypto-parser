# Crypto-Parser

### Project description:

This is a simple project that allows us to create a cron job timer that runs every 10 seconds and pulls cryptocurrency
last prices from CEX.IO, generate a CSV report and get the necessary information using following endpoints:

- GET /cryptocurrencies/minprice?name=[currency_name] - should return record with the lowest price of selected
  cryptocurrency.
- GET /cryptocurrencies/maxprice?name=[currency_name] - should return record with the highest price of selected
  cryptocurrency [currency_name] possible values: BTC, ETH or XRP. If some other value is provided then appropriate
  error message should be thrown.
- GET /cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size] - should return a selected page with
  selected number of elements and default sorting should be by price from lowest to highest. For example, if
  page=0&size=10, then you should return first 10 elements from database, sorted by price from lowest to
  highest. [page_number] and [page_size] request parameters should be optional, so if they are missing then you should
  set them default values page=0, size=10.

### Used technologies and libraries:
- String Boot, Spring Data.
- MongoDB
- Docker
- Java 11
- Git
- Apache Maven

### Steps to run the program on your computer:

- Fork this project and clone it.
- Add your information to resources/application.properties and docker-compose.yaml to be able to use Mongo Express. Also
  correct a file path in CsvService.
- Run the project.
