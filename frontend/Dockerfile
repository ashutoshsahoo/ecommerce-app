FROM nginx:alpine

ARG VERSION=latest
LABEL version=${VERSION}
LABEL maintainer="Ashutosh Sahoo"
LABEL description="Frontend - ECommerce Application"

COPY nginx.conf /etc/nginx/nginx.conf
WORKDIR /usr/share/nginx/html
COPY frontend .