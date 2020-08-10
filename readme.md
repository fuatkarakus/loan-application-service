# Loan Application Service

[![Build Status](https://travis-ci.com/fuatkarakus/loan-application-service.svg?branch=master)](https://travis-ci.com/fuatkarakus/loan-application-service)

LoanApplicationService with Rest API written in Spring Boot

## Requirements

Run MongoDb with Docker

`docker run -p 27017:27017 -v $HOME/docker/volumes/mongo/data:/data --name mongodb -d mongo`

## Quick Start

Run `mvn spring-boot:run`

Navigate `http://localhost:8080/swagger-ui.html`

## Build Docker Image
First execute
 
` mvn spring-boot:build-image `

Check image

` docker images `

Run Docker image with 

` docker run --tty --publish 8080:8080 loan:0.0.1-SNAPSHOT `

## Example

`curl --location --request POST 'http://localhost:8080/api/loan' \
 --header 'Content-Type: application/json' \
 --data-raw '{
 	"id": "12312312323",
 	"name": "fuat",
 	"surname" : "karakus",
 	"monthlySalary": "1323",
 	"phoneNumber": "5600000000"
 }'`
