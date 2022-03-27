# Ecommerce Application

This is a Message Driven Architecture example based on spring boot reactive microservices, MongoDB and Apache Kafka.

## Requirements

* JDK 17
* Gradle 7.4.1
* Docker Desktop (Kubernetes Enabled with Istio)
* Nodejs & npm

## Start Application

```shell

gradle clean dockerTag
cd deployment
kc apply -f istio,app,core

```

## Stop Application and Cleanup

```shell

cd deployment
kc delete -f istio,app,core

```

## Start Mongo Express

```shell

kc apply -f extra

```

## Reference

- [Reactive Systems in Java](https://www.baeldung.com/java-reactive-systems)