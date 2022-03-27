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
kubectl apply -f core,app,istio

```

Open [localhost](http://localhost/) to access the ui.

## Stop Application and Cleanup

```shell

cd deployment
kubectl delete -f istio,app,core

```

## Start Mongo Express

```shell

kubectl apply -f extra

```

## Remove Mongo Express

```shell

kubectl delete -f extra

```

## Reference

- [Reactive Systems in Java](https://www.baeldung.com/java-reactive-systems)
- [Istio Getting Started](https://istio.io/latest/docs/setup/getting-started/)
- [Palantir Docker Gradle Plugin](https://github.com/palantir/gradle-docker#docker-gradle-plugin)