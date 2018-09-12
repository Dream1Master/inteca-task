# inteca-task

### Prerequisites

 - [node](https://nodejs.org/en/download/) version 8.9.4 or higher.
 - [Angular CLI](https://github.com/angular/angular-cli) version 6.2.1 or higher.
 - [Spring](http://spring.io/projects/spring-boot) version 2.0
 - [Docker](https://www.docker.com/get-started) version 18.03.0-ce
 - [Angular](https://github.com/angular/angular) version 6.1.0 or higher.
 
 ### Building the app from scratch

Building process consist of 2 steps:

-prepare docker image for back-end application (IntecaTaskApp)
-prepare docker image for front-end application (IntecaAppUI)

 ### Prepare docker image for back-end application (IntecaTaskApp)
 
 To prepare docker image for back-end enter IntecaTaskApp root folder and then run:
 
 ```bash
mvn clear package docker:build
```

Maven do all job for you.

At the end you will recive springio/inteca-task-app:latest docker image.

 ### Prepare docker image for front-end application (IntecaAppUI)
 
 To prepare docker image for front-end enter IntecaAppUI root folder and then run:
 
 ```bash
npm install
```

Command above install all requires packages from package.json.

Next run command:

 ```bash
ng build
```

This command build our project and create dist folder.

And the last step is to create docker image with command:

 ```bash
docker build -t angular/inteca-task-ui .
```

This command prepare docker image angular/inteca-task-ui.

 ### Run Application
 
 To run application run commands below:
  ```bash
#run container for database
  docker run \
  --name inteca-task-mysql \
  -e MYSQL_ROOT_PASSWORD=zr~R9XBn\<n}k \
  -e MYSQL_DATABASE=intecatask \
  -e MYSQL_USER=serhiy \
  -e MYSQL_PASSWORD=dbp4ss \
  mysql:latest
  
#run container for back-end
 docker run \
 --name inteca-task-app \
 --link inteca-task-mysql:mysql \
 -p 8080:8080 \
 -e DATABASE_HOST=inteca-task-mysql \
 -e DATABASE_PORT=3306 \
 -e DATABASE_NAME=intecatask \
 -e DATABASE_USER=root \
 -e DATABASE_PASSWORD=zr~R9XBn\<n}k \
 springio/inteca-task-app 

#run container for front-end
  docker run \
  --name inteca-app-ui \
  -p 4200:4200 \
  --link inteca-task-app:intecaapp \
  angular/inteca-task-ui
```

Thats it.
 