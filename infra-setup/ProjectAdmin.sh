#!/usr/bin/env bash

. ./Env.sh

# Create a new project and link it to your billing account:

gcloud projects create ${TF_ADMIN} \
  --set-as-default
  #  --organization ${TF_VAR_org_id} \

gcloud beta billing projects link ${TF_ADMIN} \
  --billing-account ${TF_VAR_billing_account}


# Create the service account in the Terraform admin project and download the JSON credentials:

gcloud iam service-accounts create terraform \
    --display-name "Terraform admin account"

gcloud iam service-accounts keys create ${TF_CREDS} \
    --iam-account terraform@${TF_ADMIN}.iam.gserviceaccount.com


# Grant the service account permission to view the Admin Project and manage Cloud Storage:

gcloud projects add-iam-policy-binding ${TF_ADMIN} \
    --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
    --role roles/viewer

gcloud projects add-iam-policy-binding ${TF_ADMIN} \
    --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
    --role roles/storage.admin

gcloud projects add-iam-policy-binding ${TF_ADMIN} \
    --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
    --role roles/billing.projectManager

gcloud projects add-iam-policy-binding ${TF_ADMIN} \
  --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
  --role roles/resourcemanager.projectCreator

# Any actions that Terraform performs require that the API be enabled to do so. In this guide, Terraform requires the following:

gcloud services enable cloudfunctions.googleapis.com
gcloud services enable cloudbuild.googleapis.com
gcloud services enable apigateway.googleapis.com
gcloud services enable dialogflow.googleapis.com
#gcloud services enable cloudresourcemanager.googleapis.com
gcloud services enable cloudbilling.googleapis.com
#gcloud services enable iam.googleapis.com
#gcloud services enable compute.googleapis.com
#gcloud services enable serviceusage.googleapis.com

# Add organization/folder-level permissions
# Grant the service account permission to create projects and assign billing accounts:

# gcloud organizations add-iam-policy-binding ${TF_VAR_org_id} \
#   --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
#   --role roles/resourcemanager.projectCreator
#
# gcloud organizations add-iam-policy-binding ${TF_VAR_org_id} \
#   --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
#   --role roles/billing.user

gcloud beta billing accounts add-iam-policy-binding ${TF_VAR_billing_account} \
  --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
  --role roles/billing.user


# create new custom role called dialogflow_admin
gcloud iam roles create dialogflow_admin \
  --project ${GOOGLE_PROJECT} \
  --permissions "dialogflow.agents.create"



gcloud iam roles update dialogflow_admin \
    --project ${GOOGLE_PROJECT} \
    --permissions "apigateway.apis.create,apigateway.apiconfigs.create,dialogflow.agents.delete,dialogflow.agents.create,iam.serviceAccounts.actAs,apigateway.apis.delete,apigateway.gateways.create,apigateway.gateways.delete,cloudfunctions.functions.create,cloudfunctions.functions.delete,cloudfunctions.functions.setIamPolicy,apigateway.apiconfigs.delete,dialogflow.intents.create,dialogflow.intents.delete,dialogflow.agents.get"

# now the role is created, you need to bind the user and role to the project
gcloud projects add-iam-policy-binding ${GOOGLE_PROJECT} \
  --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
  --role=projects/${GOOGLE_PROJECT}/roles/dialogflow_admin

# Set up remote state in Cloud Storage
# Create the remote backend bucket in Cloud Storage and the backend.tf file for storage of the terraform.tfstate file:


gsutil mb -p ${TF_ADMIN} gs://${TF_ADMIN}

cat > backend.tf << EOF
  terraform {
   backend "gcs" {
     bucket  = "${TF_ADMIN}"
     prefix  = "terraform/state"
   }
  }
EOF

# Enable versioning for the remote bucket:


gsutil versioning set on gs://${TF_ADMIN}
