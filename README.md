# petclinic-backend
A SPRING BOOT, MySQL project for keeping customers and animal data for pet clinic

Implemented so far: 
- MySQL connectivity with JPA. 
- Models and CRUD controllers and services for customers, users, animals and medical history.
- Flyway to create database schema and add Admin and simple user.
- Spring security with JWT token. Authentication and authorization with user levels implemented.
- Tested with Postman and backuped Postman requests.
- Created MySQL user for petclinic2 database used for testing.
	CREATE USER 'petclinicuser'@'localhost' IDENTIFIED BY 'petclinicuser';
	GRANT ALL ON petclinic2.* TO 'petclinicuser'@'localhost';

# Project dashboard:
- https://trello.com/b/HHetOkCY/pet-clinic-project
