# JavaRServices
This application allows to create web microservices that would help to execute scripts in 
`R` (https://cran.r-project.org/) via RServe (https://www.rforge.net/Rserve/).
<br><br>
_"R is ‘GNU S’, a freely available language and environment for 
statistical computing and graphics which provides a wide variety of statistical and graphical techniques: 
linear and nonlinear modelling, statistical tests, time series analysis, classification, clustering, etc."_

## Prerequisities
*You will need following tools* _(tips for macOS)_:
* Docker (version >= 1.12.1, how to install: https://docs.docker.com/engine/installation/mac/)
* Docker compose (version >= 1.8.0, how to install: https://docs.docker.com/engine/installation/mac/)
* Maven (version >= 3.3.9, e.g.: `brew install mvn`)
* Java 8 (version >= 1.8.0_92, installation: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

#### Windows users
Windows users probably will need [git bash](https://git-for-windows.github.io/) to run the `start-local-environment.sh` script.

## Local development environment
In `ops-local` run the `./start-local-environment.sh` script to build and run docker containers.
Then use [postman](https://www.getpostman.com/) to create sample `HTTP GET` request for:
`http://localhost:8080/sample/sum?x=2&y=2`
This should return: `4`

## Examples

### Sum
Sample `GET` reqest to return sum of two variables `x` and `y`:<br>
```bash
curl -X GET http://localhost:8080/sample/sum\?x\=2\&y\=3
```
Should return `5`.

### Random Forest model classification for single row of data
Sample `POST` request to return run `predict()` function in R for a RandomForest model in R.<br>
```bash
curl -H "Content-Type: application/json" \
    -X POST \
    -d '{"data": {"sepalLength": 2.32, "sepalWidth": 0.23, "petalLength": "[1.0,1.6)", "petalWidth": "[0.3,1.4)"}}' \
    http://localhost:8080/classification/randomForest
 ```
 As you can see, this `POST` request takes `JSON` as `HTTP` request's body with following structure
 ```json
 {
    "data": {
      "sepalLength": 2.32,
      "sepalWidth": 0.23,
      "petalLength": "[1.0,1.6)",
      "petalWidth": "[0.3,1.4)"
    }
 }
 ```
 
 Should return `JSON` with following data structure
 ```javascript
{
  "inputData": { //fields and arrays with input data
    "sepalLength": [ 2.32 ],
    "sepalWidth": [ 0.23 ],
    "petalLength": [ "[1.0,1.6)" ],
    "petalWidth": [ "[0.3,1.4)" ]
  },
  "predictResults": [ //array with predicted results per row of input data array
      {
        "probability": 0.83, //predicted probability od P(Y='setosa')
        "label": "setosa", //predicted class
        "message": "Success",
        "timestamp": "2018-01-20 21:37:26"
      }
  ]
}
```

## Technologies used
* Dropwizard (http://www.dropwizard.io/1.2.1/docs/)
* Google Guice (https://github.com/google/guice)
* R (https://cran.r-project.org/)
* RServe (https://www.rforge.net/Rserve/)
* Docker (https://www.docker.com/)
* Apache Maven (https://maven.apache.org/)

## Maintainer & Author
* Konrad Mrozewski (konrad.mrozewski@gmail.com)
