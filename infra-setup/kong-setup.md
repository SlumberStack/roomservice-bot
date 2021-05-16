# Setup


Install in Docker with DB

1. Create a Docker network

```bash
 docker network create kong-net
```

1. Create a Docker volume

```bash
 docker volume create kong-vol

```

1. Inspect the volume

```bash
 docker volume inspect kong-vol
```

1. Create Configuration file

```bash
 cat > /var/lib/docker/volumes/kong-vol/_data/kong.yml <<EOF
_format_version: "2.1"

EOF
```

1. install Cassandra as DB

```bash
docker run -d --name kong-database \
               --network=kong-net \
               -p 9042:9042 \
               cassandra:3
```

1. Execute DB migration / bootstrap

```bash
docker run --rm \
     --network=kong-net \
     -e "KONG_DATABASE=cassandra" \
     -e "KONG_PG_HOST=kong-database" \
     -e "KONG_PG_USER=kong" \
     -e "KONG_PG_PASSWORD=kong" \
     -e "KONG_CASSANDRA_CONTACT_POINTS=kong-database" \
     kong:latest kong migrations bootstrap
```

1. Install Kong

```bash
docker run -d --name kong \
     --network=kong-net \
     -e "KONG_DATABASE=cassandra" \
     -e "KONG_PG_HOST=kong-database" \
     -e "KONG_PG_USER=kong" \
     -e "KONG_PG_PASSWORD=kong" \
     -e "KONG_CASSANDRA_CONTACT_POINTS=kong-database" \
     -e "KONG_PROXY_ACCESS_LOG=/dev/stdout" \
     -e "KONG_ADMIN_ACCESS_LOG=/dev/stdout" \
     -e "KONG_PROXY_ERROR_LOG=/dev/stderr" \
     -e "KONG_ADMIN_ERROR_LOG=/dev/stderr" \
     -e "KONG_ADMIN_LISTEN=0.0.0.0:8001, 0.0.0.0:8444 ssl" \
     -p 8000:8000 \
     -p 8443:8443 \
     -p 127.0.0.1:8001:8001 \
     -p 127.0.0.1:8444:8444 \
     kong:latest
```


1. Test that it is working
```bash
 curl -i http://localhost:8001/
 curl -i http://localhost:8001/services
```
