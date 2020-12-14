FROM openjdk:8-alpine

COPY target/uberjar/graphql-toy.jar /graphql-toy/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/graphql-toy/app.jar"]
