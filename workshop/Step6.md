# Production Ready application on Kubernetes

## Startup Boost

## Load Balancer

```
kubectl create secret generic huggingfacekey --from-literal=HUGGING_FACE_API_KEY=INSERT_YOUR_KEY
```

Check the secret has been created

```
kubectl get secret huggingfacekey -o yaml
```

Note that the value of the secret has been Base64 encoded

Edit the file `k8s/secure/deployment.yaml`:

- Change the value of `PROJECT_ID` to match your project ID

Run the command below to deploy the app

```
kubectl apply -f k8s/secure/deployment.yaml
```

Wait for the Pod to get to the `READY` state

```
kubectl get pods -w
```

Access the application. You will need to copy the name of the pod form the previous step

```
kubectl port-forward pod/POD_NAME 9080:9080
```

Use the Cloud Shell Web Preview to open the app

## Clean up

Exit port-forward by pressing `Ctrl+C`

```
kubectl delete -f k8s/basic/deployment.yaml
```
