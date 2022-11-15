#Incidencias
creacion del proyecto
```bash
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes \
-DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4
```

le indicamos el paquete, el nombre de la aplicacion y confirmamos

abrimos con visual studio code e instalamos la extensión **community server connectors**

para crear el paquete para hacer el despliegue hacemos:
```bash
mvn war:war
```
o
```bash
mvn package
```
Ahora hacemos click derecho en el WAR y seleccionamos "Run on Server" . En el navegador podemos verlo en <http:///localhost:8080/incidencias>

##creación de los contenedores para la BBDD fichero **stack.yaml**

Para levantar la base de datos:
```bash
docker-compose -f stack.yaml up -d
```