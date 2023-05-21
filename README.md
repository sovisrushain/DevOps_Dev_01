# Spring Boot REST

## Filling you in:

This is a Spring Boot REST API that allows you to do the CRUD operations based on student data against the database. 

The API receives student data in the form of a Student DTO. Based on the student's ID, the application calculates the gender and date of birth (DOB). It then utilizes the StudentDAO to persist the student entity in the database. 

This API supports other CRUD operations like getting all the students, getting a single student based on the student nic, delete a student from the database and also user can search a student by the student name.

Additionally, this API gets the student data file as a valid exel format and process the data and import all the data to the database. 


## Tech Stack
- Java 17
- Springboot 2
- Spring Data JPA
- MySQL
- Docker