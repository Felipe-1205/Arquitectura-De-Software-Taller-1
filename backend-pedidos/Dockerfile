# Etapa 1: build con Gradle
FROM gradle:8.5-jdk17 AS builder

WORKDIR /app

# Copiar solo los archivos relevantes
COPY build.gradle.kts settings.gradle.kts gradlew gradlew.bat ./
COPY gradle ./gradle
COPY src ./src

# Ejecutar la compilación con el wrapper
RUN ./gradlew build -x test --no-daemon

# Etapa 2: imagen final
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
