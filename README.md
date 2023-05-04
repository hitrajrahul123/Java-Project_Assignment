# Java-Project_Assignment
# First, we need to set up our project. We can use Spring Initializr to create a new Spring Boot project with the following dependencies:-
Spring Web
Spring Data JPA
H2 Database
Lombok
# Next, we can create a Contact entity class that represents a contact with a full-name, date of birth and an address sub-entity:
# We can also create an Address embeddable class that represents the address sub-entity:
# We can create a ContactRepository interface that extends JpaRepository to allow us to interact with the Contact entity:
# We can create a contactServiceImpl class which will implement  contactService Interface.
# We can create a ContactController class that handles requests for creating and retrieving contacts:
# We can create a data.sql file in the src/main/resources directory to populate the in-memory H2 database with sample data:
# Finally, we can run the application and test it using a tool like Postman. Here are some sample requests we can make:
GETAll- http://localhost:9191/api/contacts to retrieve all contacts
FindByPostalCode- http://localhost:9191/api/contacts/postalcode to retrieve contacts filtered by zip code
POST(Create Contact)- http://localhost:9191/api/contacts with a JSON body containing a new contact to create a new contact
That's it! With these changes, we have created a Spring Boot application that manages contacts using a RESTful API.
