# Setup project infra

## Initialisation

1. Edit _Env.sh_
1. Run _ProjectAdmin.sh_ to configure service accounts and create project
   This should create backend.tf
1. Run _terraform init_ to initialise the backend

## Operation
### Create environment

1. Set environment variables from _Env.sh_
1. Build the cloud functions (in another project)
   * roomservice-wakeup-call-service

1. ```bash
terraform plan
terraform apply
```

### Enable use of service account's API Keys

If you are using an API key for authentication, you must first enable API key
support for your service. Enter the following command, where:

_*API_ID*_ specifies the name of your API.

_*HASH*_ is the unique hash code generated when you deployed the API.

_*PROJECT_ID*_ specifies the name of your Google Cloud project.

```bash

gcloud services enable API_ID-HASH.apigateway.PROJECT_ID.cloud.goog
```

For example,

```bash
gcloud services enable my-api-a12bcd345e67f89g0h.apigateway.my-project.cloud.goog

```

#### Finding the API hash
Get API name with hash using following command

```bash
gcloud beta api-gateway apis  list
```

### Destroy

1. Run _project-cleanup.sh_
