# trip-management-query

Trip Management Query serves all the views of trip. It is the query service in CQRS for trip.

## Features
* Query Trips
    * Query by Trip ID
    * Query all trips
    * Query by User ID
    * Query by User ID and status

# Demo
To run this project from docker:
* Make sure that the Docker daemon is installed and running.
* Assemble this project.
* Run ```docker-compose up --build``` from the root project.
* On another terminal run ```docker ps``` to see which ports were assigned.

# Development

## Requirements
* Docker 17.xx.x
* JDK 1.8
* IntelliJ 2018
* Mongo 3.4

 To run this project from docker:
 * Make sure that the Docker daemon is installed and running.
 * Assemble this project.
 * Run ```docker-compose up --build -f docker-compose-dev.yml``` from the root project.
 * Run the Gradle task 'application/bootrun' from IntelliJ.