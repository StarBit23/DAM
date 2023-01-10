
# Hola mundo REST

## Compilar el proyecto y generar el WAR

mvn package

## Crear el contenedor

docker build -t payara-server-image .
docker run -d --name payara-server -p 8282:8181 -p 8080:8080 -p 4848:4848 --name payara-server payara-server-image

## Limpiar el entorno

docker stop payara-server
docker rmi payara-server
docker rm payara-server
