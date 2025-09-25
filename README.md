para ejecutar el proyecto en ambiente local se debe tener instalado previamente java 17 y un editor de codigo,
este proyecto trae por defecto el servidor de tomcat.

la base de datos que se esta utilizando en dynamodb de amazon, se puede aprovicionar mediente
el archivo dynamoTemplate en la carpeta resources dentro del modulo de application

el archivo nequi test.postman_collection.json contiene los request del proyecto, el archivo se encuentra en
la carpeta resources dentro del modulo de application

la aplicacion corre por defecto en el puerto 8080 en caso de tener problemas con el puerto modificar la 
propiedad server.port en el archivo application.properties que se encuentra en la carpeta resources 
dentro del modulo de application