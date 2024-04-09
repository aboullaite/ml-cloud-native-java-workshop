# Google Cloud Setup

## Create Google Cloud Account

1 - Open [Lab Environment](https://trygcp.dev/e/devnexus24) and Sign-In

![alt text](images/gcp-setup-step1.jpg)

2 - Click on "Click Here to Access Your credits"

![alt text](images/gcp-setup-step2.jpg)

3 - Click "Accept and Continue"

![alt text](images/gcp-setup-step3.jpg)

4 - Click on "Create Or Select a Project"

![alt text](images/gcp-setup-step4.jpg)

5 - Click "New Project"

![alt text](images/gcp-setup-step5.jpg)

6 - Name your Project. Select the Billing Account created previously. Click "Create"

![alt text](images/gcp-setup-step6.jpg)

7 - Click the Cloud Shell Button

![alt text](images/gcp-setup-step7.jpg)

8 - Open Editor. This step might take few minutes

![alt text](images/gcp-setup-step8.jpg)

9 - Enable Needed API's

Open a Terminal Window and run the following commands

```
gcloud services enable artifactregistry.googleapis.com
gcloud services enable container.googleapis.com
gcloud services enable run.googleapis.com
gcloud services enable secretmanager.googleapis.com
```

The rest of the steps will be executed from this environment unless instructed otherwise.
