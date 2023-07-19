FROM openjdk:11
EXPOSE 8080
ADD target/quarkus-product-image.jar quarkus-product-image.jar
ENTRYPOINT ["java","-jar","/quarkus-product-image.jar"]