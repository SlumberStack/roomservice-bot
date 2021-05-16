#!/usr/bin/env bash

. ./Env.sh
# Permanently delete the resources created by Terraform:

terraform destroy

# Delete the Terraform Admin project and all of its resources:

gcloud projects delete ${TF_ADMIN}


# Remove the organization level IAM permissions for the service account:

gcloud organizations remove-iam-policy-binding ${TF_VAR_org_id} \
  --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
  --role roles/resourcemanager.projectCreator

gcloud organizations remove-iam-policy-binding ${TF_VAR_org_id} \
  --member serviceAccount:terraform@${TF_ADMIN}.iam.gserviceaccount.com \
  --role roles/billing.user
