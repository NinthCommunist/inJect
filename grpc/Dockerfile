FROM openjdk:11
COPY build/libs .
WORKDIR /libs
ENTRYPOINT ["java","-jar","/org.inject.grpc.jar"]