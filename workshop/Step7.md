# Deploying the app to cloud run

### Build Docker image with Dockerfile
Follow steps in [Step 3](Step3.md) to build the Docker image, tag and push the image to Google Container Registry

### Creating a secret using Google Secret manager

Create a secret with the Hugging Face API key
```shell
export REGION=us-east1
export PROJECT_NUMBER=$(gcloud projects describe $PROJECT_ID --format="value(projectNumber)")
printf "YOUR HUGGIN FACE API KEY " | gcloud secrets create huggingface-api --data-file=- --replication-policy=user-managed --locations=$REGION
```

Grant the default service account access to secrets
```
gcloud projects add-iam-policy-binding \
     $PROJECT_ID  \
     --member=serviceAccount:$PROJECT_NUMBER-compute@developer.gserviceaccount.com \
     --role roles/secretmanager.secretAccessor
```

### Deploy Docker images to Cloud Run

Check existing deployed Cloud Run Services
;
```shell
export PROJECT_ID=$(gcloud config get-value project)

gcloud run services list
```
Deploy the application image to Cloud Run

```
# note the URL of the deployed service
gcloud run deploy ml-java-workshopp-app \
     --image $REGION-docker.pkg.dev/$PROJECT_ID/ml-java-workshopp/ml-java-workshopp-app \
     --region $REGION \
     --port 9080 \
     --memory 2Gi --allow-unauthenticated \
     --update-secrets=HUGGING_FACE_API_KEY=huggingface-api:latest
```
Test the application in Cloud Run

```
# find the app URL if you have not noted it
gcloud run services list | grep devnexus-app
✔  quotes                    us-east1   https://devnexus-...-uc.a.run.app       
```
Open the URL in a browser and test the application
