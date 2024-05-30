# Secure your Kubernetes App

## Create a Kubernetes Secret that containes the HuggingFace API key

In the previous step we hard-coded the HuggingFace API key in the deployment manifest as an environment variable. This is not a good practice as these kind of secrets might end up on Github.

Kubernetes has a mechanism to secure Secrets (passwords, API Keys...). Let's explore how to use it.

Replace `INSERT_YOUR_KEY` in the command below with your API Key and create the secret

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
kubectl delete -f k8s/secure/deployment.yaml
```
