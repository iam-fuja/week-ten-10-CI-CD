FROM openjdk:17
EXPOSE 8080
ADD target/fashion-blog-api.jar fashion-blog-api.jar
ENTRYPOINT ["java" , "-jar" , "fashion-blog-api.jar"]