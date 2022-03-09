FROM openjdk:11.0.7-jre-slim AS runtime

WORKDIR /app

LABEL maintainer="eyeota"
LABEL name="taiyaki"
LABEL description="Api Service for Fugu"

COPY build/libs/*.jar /app/taiyaki.jar

EXPOSE 4072

ENTRYPOINT ["java", "-jar", "-Xms512m","-Xmx1000m" ,"/app/taiyaki.jar"]
