# Imagen base de Java 17
FROM eclipse-temurin:17-jdk

# Establece directorio de trabajo
WORKDIR /app

# Copia todo el proyecto
COPY . .

# Compila el proyecto con Maven
RUN ./mvnw clean package -DskipTests

# Expone el puerto (Render usa la variable $PORT)
EXPOSE 8080

# Comando de inicio
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar target/backend-0.0.1-SNAPSHOT.jar"]