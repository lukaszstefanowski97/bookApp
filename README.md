# bookApp

This app is able to store book entries and expose them using REST API.

**PREREQUISITES:**
- Java 8 or higher
- Spring
- Maven
- (optional) Docker

**Creation of project environment**

Build your Maven project by typing:
    
    
        mvn clean install


You have to use this command in project's root directory.

If everything went properly you should be able to run Spring application.

You can use the app in your browser by going to:

    
http://localhost:8080/


You can also use backend api. Endpoints are located in:

    
http://localhost:8080/api/books for get method


http://localhost:8080/api/addBook for post method


Name and surname should both start with a letter 'A'. ISBN number should be 13 digits long integer.

Example of a proper json file for post request to api: 

    {
        "author": "Adam Adam",
        "title": "Steppenwolf",
        "isbn": "1234567898765"
    }

This app is also running on Docker. Please type the command below (only if you build a project first) to build your docker image:

    
        docker build -t bookapp .
        
        
Then please run the image. Running command:

    
        docker run -p 8080:8080 bookapp
        
        
Or just use Docker Hub instead:


https://cloud.docker.com/repository/docker/lukaszstefanowski97/bookapp


