RUTA=/home/ubuntu/development/desarrollo-ejercicio/src/main/resources/local-database

docker run -d \
-p 3308:3309 \
--name datos \
-v $RUTA/data:/var/lib/mysql \
-v $RUTA/scripts:/scripts \
-e MYSQL_ROOT_PASSWORD=garellano \
mariadb
