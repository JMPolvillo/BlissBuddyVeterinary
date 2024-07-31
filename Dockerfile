#Imagen que descargara de Docker Hub con la version correcta de Java
FROM maven:3.9.6-amazoncorretto-21

#Informar en que puerto se expone el contenedor (es a modo informativo)
EXPOSE 8080

#Crear un directorio raiz de nuestro contenedor
WORKDIR /root

# Copiar el archivo pom.xml y descargar las dependencias
COPY Patient/pom.xml .
RUN mvn dependency:go-offline

# Copiar el resto del código fuente al contenedor y construir la aplicación
COPY Patient/src ./src
RUN mvn package

#Copiar el código fuente (*.jar) dentro del directorio raiz que creamos para el contenedor
COPY /Patient/target/Patient-0.0.1-SNAPSHOT.jar /Patient/src/main/java/Veterinary/*.jar

#Levantar nuestra aplicación cuando el contenedor inicie
ENTRYPOINT ["java","-jar","/root/Patient/target/Patient-0.0.1-SNAPSHOT.jar"]