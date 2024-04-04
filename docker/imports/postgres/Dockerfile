# Используем базовый образ PostgreSQL
FROM postgres:latest

# Установим рабочий каталог в /docker-entrypoint-initdb.d
WORKDIR /docker-entrypoint-initdb.d

# Скопируем файл инициализации в каталог контейнера
COPY ./init/test_dump.sql /docker-entrypoint-initdb.d/

# владелец файла
#USER postgres