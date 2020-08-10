# Loan Application Service

LoanApplicationService with Rest API written in Spring Boot

## Build Docker Image
First execute
 
` mvn spring-boot:build-image `

Check Images

` docker images `

Run Docker Image With 

` docker run --tty --publish 8080:8080 loan:0.0.1-SNAPSHOT `
