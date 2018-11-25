FROM java:8

ADD target/*.jar app.jar

RUN touch app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]