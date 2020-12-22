# Spring WebFlux Example
This project is an example of how to use Spring WebFlux to create a reactive RESTful API.

## Build
Build the jar and docker image.
```
Spring-WebFlux-Example $ mvn clean install -Dmaven.test.skip=true
Spring-WebFlux-Example $ docker build -t mattbriden/spring-webflux-api .
```

## Run
There is a Docker environment included with this project to run the API with a Postgres DB initialized. Use the below commands to bring up the Docker environment.
```
Spring-WebFlux-Example/util/docker $ docker-compose run start_db
Spring-WebFlux-Example/util/docker $ docker-compose up -d
```
A Python script has also been included to seed the db with some data. It is encouraged to install the necessary pip packages in a virtual environment. The following commands can be used to do that.
```
Spring-WebFlux-Example/util/python $ python3 -m venv venv
Spring-WebFlux-Example/util/python $ source venv/bin/activate
(venv) Spring-WebFlux-Example/util/python $ pip install -r requirements.txt
```
At this point the script can be run to seed the database. By default it will add ten entries but this can be configured by changing the `num_entries` variable in seed-db.py. Run the script with the following command.
```
(venv) Spring-WebFlux-Example/util/python $ python3 seed-db.py
```

## Use
Use the following cURL command to call the reactive API.
```
Spring-WebFlux-Example $ curl localhost:8090/api/animal -i
HTTP/1.1 200 OK
transfer-encoding: chunked
Content-Type: application/stream+json

{"id":"61de7d7e-d5d5-4772-9c56-0115381e8205","name":"Cat","kingdom":"Vertebrate"}
{"id":"61a55942-aa86-402c-a3be-d4ccd18ae2ff","name":"Jellyfish","kingdom":"Invertebrate"}
{"id":"c6aa1de4-81fd-4336-a69a-0bf9400e633f","name":"Cat","kingdom":"Vertebrate"}
{"id":"2c643272-83c8-4a7b-a65f-413f7bb27b1b","name":"Jellyfish","kingdom":"Invertebrate"}
{"id":"4beb08f6-2583-41d5-a394-3d87276df7eb","name":"Jellyfish","kingdom":"Invertebrate"}
{"id":"3ea559d8-3c1b-4c8c-81a4-52cd04152116","name":"Cat","kingdom":"Vertebrate"}
{"id":"34d913cf-124e-4ceb-ab39-0fa2a303c782","name":"Worm","kingdom":"Invertebrate"}
{"id":"aefb3f7e-f2da-493b-a303-e1e42840623a","name":"Jellyfish","kingdom":"Invertebrate"}
{"id":"b66d2000-60fc-4a80-93c5-5b669596f36f","name":"Cat","kingdom":"Vertebrate"}
{"id":"02c327a4-6f14-49bb-b850-9a2cd3a8586d","name":"Cat","kingdom":"Vertebrate"}
```
The results will be returned in 1 second intervals as dictated by the code (see line 25 of AnimalController.java).
