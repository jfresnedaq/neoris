PRUEBA DE NEORIS

Presentada por Paola Fresneda

Pasos para desplegar en Docker:
- Estar en la ruta donde se encuentra el proyecto, en la carpeta principal estara el Dockerfile: /prueba-neoris/Dockerfile
- Seguido de esto ejecutamos la creación de la imagen:  docker build -t prueba-neoris-1.0.0:neoris-docker .
- Verificar que la imagen haya sido creada con el comando: docker images -a
- Para ejecutar la imagen docker creada se ejecuta el siguiente comando: docker run -p 8080:8080 prueba-neoris-1.0.0:neoris-docker .
