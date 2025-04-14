# Etapa de construcción
FROM gradle:8.4-jdk17 as builder
WORKDIR /app
COPY backend-facturacion .
RUN gradle build --no-daemon -x test

# Etapa final
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/backend-facturacion-*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]