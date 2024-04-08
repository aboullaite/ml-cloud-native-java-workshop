# Deploying the app to cloud run

### Build Docker image with Dockerfile
Follow steps in [Step 3](Step3.md) to build the Docker image, tag and push the image to Google Container Registry

### Creating a secret using Google Secret manager
First let's enable the Secret Manager API
```shell
gcloud services enable secretmanager.googleapis.com
```
Create a secret with the Hugging Face API key
```shell
printf "YOUR HUGGIN FACE API KEY " | gcloud secrets create huggingface-api --data-file=- --replication-policy=user-managed --locations=us-east1
````
### Deploy Docker images to Cloud Run

Check existing deployed Cloud Run Services

```shell
export PROJECT_ID=$(gcloud config list --format 'value(core.project)')
echo   $PROJECT_ID

gcloud run services list
```
Deploy the application image to Cloud Run

```
# note the URL of the deployed service
gcloud run deploy devnexus-workshop-app \
     --image us-east1-docker.pkg.dev/$PROJECT_ID/devnexus/devnexus-workshop-app \
     --region us-central1 \
     --memory 2Gi --allow-unauthenticated
     --update-secrets=HUGGING_FACE_API_KEY=huggingface-api
```
Test the application in Cloud Run

```
# find the app URL if you have not noted it
gcloud run services list | grep devnexus-app
✔  quotes                    us-central1   https://devnexus-...-uc.a.run.app       
```
Open the URL in a browser and test the application