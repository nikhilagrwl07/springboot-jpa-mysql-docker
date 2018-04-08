#!/usr/bin/env bash
kubectl delete -f scripts/deployment-gym.yml
kubectl delete -f scripts/service-gym.yml
kubectl delete -f scripts/ingress-gym.yml
kubectl delete cm hostname-config
#kubectl delete -f scripts/mysql.yml

