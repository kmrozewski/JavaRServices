#!/bin/bash

# build .jar with java application
mvn clean package -f ../rservices/pom.xml

# move .jar to appropriate docker folder
cp ../rservices/target/rservices-*.jar ./rservices/rservices.jar

# build and run docker-compose.yml
docker-compose up --build -d