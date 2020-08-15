# Loan Application Service

[![Build Status](https://travis-ci.com/fuatkarakus/loan-application-service.svg?branch=master)](https://travis-ci.com/fuatkarakus/loan-application-service)
[![Coverage Status](https://coveralls.io/repos/github/fuatkarakus/loan-application-service/badge.svg?branch=master)](https://coveralls.io/github/fuatkarakus/loan-application-service?branch=master)
[![BCH compliance](https://bettercodehub.com/edge/badge/fuatkarakus/loan-application-service?branch=master)](https://bettercodehub.com/)

LoanApplicationService with Rest API written in Spring Boot

## Requirements

Mongodb

Java 11

## Quick Start

Run `mvn spring-boot:run`

Navigate `http://localhost:8080/swagger-ui.html`

## Build Docker Image
First execute
 
` mvn spring-boot:build-image `

Check image

` docker images `

Run

` docker-compose up `

## Example

``` 
curl --location --request POST 'http://localhost:8080/api/loan' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 	"id": "12312312323",
 	"name": "fuat",
 	"surname" : "karakus",
 	"monthlySalary": "1323",
 	"phoneNumber": "5600000000"
 }'
```
