# bookApp

This app is able to store book entries and expose them using REST API.

**PREREQUISITES:**
- Java 8 or higher
- Spring
- Maven

**Creation of project environment**

Build your Maven project by typing:
    
    
        mvn clean install


You have to use this command in project's root directory. Both backend and frontend will be build by this one command so it could take a while. 


If everything went properly you should be able to run Spring application.


After running Spring application please open terminal in project's root directory, change directory to /frontend and run 
React frontend by typing:
    
    
        npm start


Endpoints are located in:


        http://localhost:3000/hello

    
        http://localhost:3000/books


        http://localhost:3000/api/addBook
