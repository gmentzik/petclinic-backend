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
- Filtering Customer List: Trying to solve problem how to have filtering and pagination at customer list with Spring Boot JPA. So far found possible solutions:

 1. JPA specs: https://www.blog.nilestanner.com/2019/02/05/spring-filter-sort-page/
 2. New JPA interface method: http://kevinmichaelcoy.com/blog/2021/02/25/spring-data-pageable-jpa-filter-query-with-3-of-4-parts-of-composite-key-via-a-query-method/
 3. Add new JPA interface method with custom query: https://www.codejava.net/frameworks/spring-boot/spring-data-jpa-filter-search-examples

Going for solution with JPA specs (criteria and metamodel).
JPA specs multiple filter example: https://attacomsian.com/blog/spring-data-jpa-specifications
In order to use metamodel for JPA entities:
- Added dependency to POM:
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-jpamodelgen</artifactId>
			<version>${hibernate.version}</version>
		</dependency>
		
This generates metamodels at: C:\Users\gment\Documents\workspace-spring-tool-suite-4-4.10.0.RELEASE\myPetClinicGitRepo\petclinic-backend\target\generated-sources\annotations\com\mentzikof\myPetClinic\model
Make sure this classpath is added to your project. See project Java compiler buildpath.		
https://www.baeldung.com/hibernate-criteria-queries-metamodel
https://vladmihalcea.com/jpa-criteria-metamodel/

Multiple criteria example. https://attacomsian.com/blog/spring-data-jpa-specifications




# Project dashboard:
- https://trello.com/b/HHetOkCY/pet-clinic-project
