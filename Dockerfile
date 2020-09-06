FROM openjdk:8

WORKDIR /usr/src/app

COPY ./target/customer-0.0.1-SNAPSHOT.jar /usr/src/app

# Expose the port 
EXPOSE 8080

CMD ["java", "-jar", "customer-0.0.1-SNAPSHOT.jar"]
