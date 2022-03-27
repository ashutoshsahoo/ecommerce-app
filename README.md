# Ecommerce Application

This is a Message Driven Architecture example based on spring boot reactive microservices, MongoDB and Apache Kafka.

## Requirements

* JDK 17
* Gradle 7.4.1
* Docker Desktop (Kubernetes Enabled)
* Nodejs & npm

## Start Application

```shell

# Sometimes the pvc don't get deleted from previous runs, ignore error pvc not found
kubectl delete pvc kafka-data-kafka-0
gradle clean dockerTag
cd deployment
kubectl apply -f .

```

## Stop Application and Cleanup

```shell

cd deployment
kubectl delete -f .
kubectl delete pvc kafka-data-kafka-0 # sometimes the pvc don't get deleted

```

## Reference

- [Reactive Systems in Java](https://www.baeldung.com/java-reactive-systems)