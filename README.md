# Simple Notes API by Eztephen Bacuño

Created a RESTful API that allows users to create, retrieve, update, and delete notes. Each note can consist of a title and a body. 

Validations are added for blank title, blank body and size of body.

**To Run the API, **

Kindly make sure Java 17 and Maven are installed on your respective machine.

- Pull this repository on your local
- Open terminal and navigate to where this are pulled i.e. cd /path/to/notes
- Run command **mvn spring-boot:run** or
- If you have an IDE opened, you may navigate on the project and run **NotesApplication.java**


**Helpful link : **
https://www.geeksforgeeks.org/how-to-run-spring-boot-application/

**API Endpoints:**

· POST /v1/notes: Create a new note.

· GET /v1/notes: Retrieve all notes.

· GET /v1/notes/{id}: Retrieve a specific note by ID.

· PUT /v1/notes/{id}: Update a specific note.

· DELETE /v1/notes/{id}: Delete a specific note.


_For further reference, you may check on the swagger : http://localhost:8080/swagger-ui/index.html#_
