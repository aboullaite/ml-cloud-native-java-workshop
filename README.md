# LLM Powered App with Jakarta EE, MicroProfile, and LangChain4j

This project leverages the power of Large Language Models (LLMs) in a Jakarta EE and MicroProfile-based application, utilizing LangChain4j for seamless integration. Originally inspired and adapted from [LangChain4j examples](https://github.com/langchain4j/langchain4j-examples), this repository has been extended to serve as a workshop for deploying and running the application in a Google Cloud Environment.

## Overview

The application demonstrates how to build, secure, and deploy an LLM-powered application using Jakarta EE, MicroProfile, and LangChain4j. It is designed as a workshop with 8 comprehensive steps, guiding through everything from setting up the local environment to deploying the application in Google Kubernetes Engine (GKE) and Google Cloud Run.

### What You Will Learn

- Setting up your local development environment for Jakarta EE and MicroProfile.
- Integrating LangChain4j for leveraging Large Language Models in your application.
- Containerizing your application with Docker.
- Implementing security best practices for your application.
- Deploying your application to Google Kubernetes Engine (GKE).
- Deploying your application to Google Cloud Run.
- Managing and scaling your application in a cloud environment.

## Prerequisites

Before you begin, ensure you have the following installed:

- JDK 17 or later
- Maven
- Docker
- Google Cloud SDK

## Setup

1. **Clone the Repository**

   Clone this repository to your local machine using the following command:

   ```shell
   git clone git@github.com:aboullaite/devnexus-workshop.git
   ```
2. **Local Environment Setup**

Refer to `STEP1.md` in the `workshop` directory for instructions on setting up your local development environment.

## Deployment

The deployment process is broken down into several steps, each detailed in the corresponding markdown file within the `workshop` directory.

### Steps Overview

- **Step 1:** Setting up google cloud environment
- **Step 2:** Deploying teh app locally
- **Step 3:** Application Containerization
- **Step 4:** Deploy the application to Kubernetes
- **Step 5:** Securing the app
- **Step 6:** Production Ready application on Kubernetes
- **Step 7:** Deploying the app to cloud run
- **Step 8:** Using Gemini

Please follow the steps in sequential order to ensure a smooth deployment process.

## Contributing

We welcome contributions! Please feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE). See the LICENSE file for more details.

## Acknowledgments

- Thanks to the [LangChain4j](https://github.com/langchain4j/langchain4j-examples) project for the initial codebase.
- This workshop was created as part of the [DevNexus 2024](https://devnexus.com/) conference.

## Support

For support, please open an issue in the GitHub repository or contact the maintainers directly.



