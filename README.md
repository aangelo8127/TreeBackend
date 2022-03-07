# TreeBackend

Para el desarrollo de la prueba se trato de utilizar Arquitecturas Limpias.

Para tener un completo funcionamiento de la aplicacion se necesita tener instalado lo siguiente:

* Jdk 1.8 o Superior
* Maven
* Postman o cualquier herramienta para consumir servicios web

Para la instalacion se deben seguir los siguientes pasos:

1. Clonar o descargar el repositorio.
2. Abrir cmd o terminal y situarse en la carpeta del proyecto por ejemplo C:\TreeBackend\
3. Ejecutar el comando mvn package
4. Una vez termine el comando anterior ubicar la carpeta Target dentro de la carpeta del proyecto
5. Ejecutar el archivo Tree-backend-0.0.1-SNAPSHOT.jar
6. Abrir postman o cualquier herramienta de consumo de servicios y probar los 2 endpoints creados

Pruebas de los servicios:

1. Servicio Creacion de un arbol se puede utilizar el siguiente curl:

```
curl --location --request POST 'localhost:8081/registrar/nodo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "arbol":[
        {
            "id":1,
            "valor":67,
            "padre":0
        },
        {
            "id":1,
            "valor":39,
            "padre":67
        },
        {
            "id":1,
            "valor":76,
            "padre":67
        },
        {
            "id":1,
            "valor":28,
            "padre":39
        },
        {
            "id":1,
            "valor":44,
            "padre":39
        },
        {
            "id":1,
            "valor":29,
            "padre":28
        },
        {
            "id":1,
            "valor":74,
            "padre":76
        },
        {
            "id":1,
            "valor":85,
            "padre":76
        },
        {
            "id":1,
            "valor":83,
            "padre":85
        },
        {
            "id":1,
            "valor":87,
            "padre":85
        }
    ]
}'
```
  Response: valor de nodos creados para el arbol
  
```
{
    "valor": 10
}
```
2.Consultar ancestro común más cercano dando el id y 2 nodos obtener el valor del ancestro mas cercano.

```
curl --location --request GET 'localhost:8081/consultas/LowestCommonAncestor?id=1&nodo1=39&nodo2=76'
```
Response
```
67
```
Reglas que se desarrollaron adicionales: 

1. El id, valor y padre del arbol es unico
2. Como es un arbol binario no permite tener mas de 2 hijos
3. Si se consulta el ancestro de un arbol no existente genera un mensaje informando que el arbol no existe
4. Si uno de los nodos consultado no existe genera un mensaje informando que el nodo no existe en el arbol a consultar.

Nota:
Se realizaron pruebas unitarias para corroborar las reglas antriores


