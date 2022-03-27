# MongoDB and Mongo Express Kubernetes Deployment

## Set Secrets

```shell

echo -n 'username' | base64
dXNlcm5hbWU=

$ echo -n 'password' | base64
cGFzc3dvcmQ=

```

Update the values in [mongodb-secret.yaml](mongodb-secret.yaml) file.

## MongoDB deployment

```shell
kubectl apply -f mongodb-secret.yaml

kubectl get secret

kubectl apply -f mongodb-deployment.yaml

kubectl get po,deploy,svc

kubectl describe service mongodb-service

```

## Mongo Express deployment

```shell

kubectl apply -f mongo-configmap.yaml

kubectl apply -f mongo-express-deployment.yaml

kubectl get po,deploy,svc

kubectl describe service mongo-express-service

```

## Cleanup

```shell

kubectl delete -f mongo-express-deployment.yaml
kubectl delete -f mongo-configmap.yaml
kubectl delete -f mongodb-deployment.yaml
kubectl delete -f mongodb-secret.yaml

# Or
# kc delete -f .

```
