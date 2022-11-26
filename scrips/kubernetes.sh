cd ..
cd kubernetes

minikube start

kubectl apply -f=eureka-server-deployment.yml -f=eureka-server-service.yml
kubectl apply -f=api-gateway-deployment.yml -f=api-gateway-service.yml
kubectl apply -f=postgres-deployment.yml -f=postgres-service.yml
kubectl apply -f=scheduler-deployment.yml -f=scheduler-service.yml
kubectl apply -f=school-library-deployment.yml -f=school-library-service.yml
kubectl apply -f=student-deployment.yml -f=student-service.yml
