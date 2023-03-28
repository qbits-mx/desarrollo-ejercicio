docker stop dockerized-segundo-examen-srv
docker rm dockerized-segundo-examen-srv

docker pull ghcr.io/saloultrasist/dockerized-segundo-examen

docker run -d \
-e SPC=https://config.saloultrasist \
--name=dockerized-segundo-examen-srv \
--restart =unless-estopped \
-p7779:9999 \
ghcr.io/saloultrasist/dockerized-segundo-examen
