FROM java:8-jre-alpine

ADD rservices.jar rservices.jar
ADD config.yml config.yml

CMD java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5080 -jar rservices.jar server config.yml

EXPOSE 8080
EXPOSE 5080
