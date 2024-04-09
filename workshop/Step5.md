# Deploy the application to Kubernetes

## Create a Google Kubernetes Engine Cluster

```
export PROJECT_ID=$(gcloud config get-value project)
export ZONE=us-east1-b

gcloud container --project $PROJECT_ID clusters create devnexus-workshop \
    --enable-kubernetes-alpha \
    --cluster-version "1.29.3-gke.1093000"\
    --machine-type "e2-medium" \
    --disk-type "pd-standard" \
    --disk-size "50" \
    --num-nodes "2" \
    --addons HorizontalPodAutoscaling,HttpLoadBalancing \
    --no-enable-autorepair \
    --no-enable-autoupgrade \
    --zone $ZONE --quiet
```

## Deploy and test the application

Edit the file `k8s/basic/deployment.yaml`:

- Change the value of the `HUGGING_FACE_API_KEY` environment variable
- Change the value of `PROJECT_ID` to match your project ID

Run the command below to deploy the app

```
kubectl apply -f k8s/basic/deployment.yaml
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
