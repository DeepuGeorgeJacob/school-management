# Install kubernetes

1. Install kubectl (https://kubernetes.io/docs/tasks/tools/install-kubectl-macos/)
2. Install minikube for local machine (https://minikube.sigs.k8s.io/docs/start/)
3. Setup driver (https://minikube.sigs.k8s.io/docs/drivers/)
4. Configure driver (eg :- docker (https://minikube.sigs.k8s.io/docs/drivers/docker/))
   1. minikube start --driver=docker
   2. minikube config set driver docker

## Minikube Commands 

1. Start - `minikube start`
2. Stop - `minikube stop`
3. Delete - `minikube delete`
4. Dashboard - `minikube dashboard`


# Create Deployment object using imperative approach

### Create/Delete deployment
`kubectl create deployment <deployment name> --image=<image name>:<tag>` 
<br><br>
eg:- `kubectl create deployment eureka-deployment --image=deepugeorgejacob/eureka-server:0.1`
<br><br>
`kubectl delete deployment <deployment name> `

### Show deployments

`kubectl get deployments`

### Show pods
`kubectl get pods`

# Create Service object using imperative approach

What is Service object?
<br>Service object exposing pods to cluster or externally

## Expose port of deployment inside the cluster
`kubectl expose deployment <deploymement name> --port=<port number>`
<br>eg:- `kubectl expose deployment eureka-deployment  --port=8761`


## Expose port of deployment outside world
`kubectl expose deployment <deploymement name> --type=LoadBalancer --port=<port number>`
<br>eg:-> `kubectl expose deployment eureka-deployment --type=LoadBalancer --port=8761`</br>

## Get Running services
`kubectl get services`
## Get exposed port from minikube
`minikube service eureka-deployment`

## Scale the deployment
`kubectl scale deployment/eureka-deployment --replicas=3`

# Create Deployment object using declarative approach

https://kubernetes.io/docs/concepts/workloads/controllers/deployment/

## Submit deployment

`kubectl apply -f=eureka-server-deployment.yml`

<br>
See the deployment file created for the project
<br>

[Kubernetes yml files for cloud configuration](../kubernetes)
<br>
[Script to run all pods to cluster](../scrips/kubernetes.sh)

## Delete based on label
`kubectl delete <kind of resources in array> -l <key>=<value>`
<br>
`kubectl delete deployments,service -l <key>=<value>`
<br>
eg:- `kubectl delete deployments,services -l group=school-management`

