# Java 17 asosiy image
FROM openjdk:17-jdk-alpine

# Loyiha fayllarini konteynerga nusxalash
COPY target/*.jar app.jar

# Loyihani ishga tushirish
ENTRYPOINT ["java", "-jar", "/app.jar"]