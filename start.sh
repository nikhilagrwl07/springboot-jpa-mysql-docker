#!/usr/bin/env bash
mvn clean compile -DskipTests package

docker build -t nikhilagrwl07/springboot-jpa-mysql-docker:v4 .
docker push nikhilagrwl07/springboot-jpa-mysql-docker:v4

kubectl create -f scripts/mysql.yml
kubectl create configmap hostname-config --from-literal=mysql_host=$(kubectl get svc mysql -o jsonpath="{.spec.clusterIP}")

sleep 15s
minikube addons enable ingress
kubectl create -f scripts/deployment-gym.yml
kubectl create -f scripts/service-gym.yml
kubectl create -f scripts/ingress-gym.yml
echo "$(minikube ip) myminikube.info gym.all" | sudo tee -a /etc/hosts
