#Stage 1
# initialize build and set base image for first stage
FROM amd64/maven:3.9.7-sapmachine-22 as onbuild
# speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
# set working directory
WORKDIR /app/src
# copy your other files
COPY . .

WORKDIR /app/src/impl/SprintBook
# go-offline using the pom.xml
RUN mvn dependency:go-offline

RUN mvn clean package -Pdocker-onbuild

WORKDIR /app/src/impl/SprintBook
# compile the source code and package it in a jar file
#Stage 2
# set base image for second stage
FROM eclipse-temurin:22.0.1_8-jdk-ubi9-minimal
# set deployment directory
WORKDIR /app/customerportal
# copy over the built artifact from the maven image
COPY --from=onbuild /app/src/impl/SprintBook/target/SprintBook-1.0-SNAPSHOT.jar /app/sprintbook/SprintBook-1.0-SNAPSHOT.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar", "/app/sprintbook/SprintBook-1.0-SNAPSHOT.jar"]
