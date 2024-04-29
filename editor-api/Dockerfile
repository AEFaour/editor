FROM eclipse-temurin:21-jdk

ADD target/*.jar app.jar
RUN sh -c 'touch /app.jar'
RUN chmod +x mvnw
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
