FROM openjdk:17
EXPOSE 8080
ADD target/blogging-styles.jar blogging-styles.jar
ENTRYPOINT ["java" , "-jar" , "blogging-styles.jar"]