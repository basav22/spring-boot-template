FROM gradle:6.6.1-jdk11-hotspot AS builder

WORKDIR /home/gradle/src

COPY . .

RUN gradle bootjar

FROM openjdk:11.0.7-jre-slim AS runtime

LABEL maintainer="eyeota"
LABEL name="taiyaki"
LABEL description="Api Service for Fugu"

COPY --from=builder /home/gradle/src/build/libs/*.jar /app.jar

EXPOSE 4072

ENTRYPOINT ["java", "-jar", "/app.jar"]
