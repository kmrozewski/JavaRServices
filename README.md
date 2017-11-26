# JavaRServices
This application allows to create web microservices that would help to execute scripts in R (https://cran.r-project.org/) via RServe (https://www.rforge.net/Rserve/).
</br></br>
_"R is ‘GNU S’, a freely available language and environment for statistical computing and graphics which provides a wide variety of statistical and graphical techniques: linear and nonlinear modelling, statistical tests, time series analysis, classification, clustering, etc."_

## Prerequisities
*You will need following tools* _(tips for macOS)_:
* Docker (version >= 1.12.1, how to install: https://docs.docker.com/engine/installation/mac/)
* Docker compose (version >= 1.8.0, how to install: https://docs.docker.com/engine/installation/mac/)
* Maven (version >= 3.3.9, e.g.: ```brew install mvn```)
* Java 8 (version >= 1.8.0_92, installation: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Local development environment
In ```ops-local``` run the ```./start-local-environment.sh``` script to build and run docker containers.
Then use [postman](https://www.getpostman.com/) to create sample ```HTTP GET``` request for:
```http://localhost:8080/sample/sum?x=2&y=2```
This should return: ```4```

### Windows users
Windows users probably will need [git bash](https://git-for-windows.github.io/) to run the ```start-local-environment.sh``` script.

## Technologies used
* Dropwizard (http://www.dropwizard.io/1.2.1/docs/)
* Google Guice (https://github.com/google/guice)
* R (https://cran.r-project.org/)
* RServe (https://www.rforge.net/Rserve/)
* Docker (https://www.docker.com/)
* Apache Maven (https://maven.apache.org/)

## Maintainer & Author
* Konrad Mrozewski
