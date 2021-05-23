export GOOGLE_APPLICATION_CREDENTIALS=~/.config/gcloud/${USER}-terraform-admin.json
export GOOGLE_PROJECT="${USER}-terraform-admin"
export GCP_SERVICE_ACCOUNT_EMAIL="..."
export BILLING_ACCOUNT="..."

# Terraform variable values
export TF_VAR_org_id="" # Can be blank/empty
export TF_VAR_billing_account="${BILLING_ACCOUNT}"
export TF_ADMIN="${GOOGLE_PROJECT}"
export TF_VAR_project_name="${TF_ADMIN}"
export TF_CREDS="${GOOGLE_APPLICATION_CREDENTIALS}"

# OAuth settings from Auth0
export TF_VAR_oauth2_token_issuer="https://${AUTH0_ACCOUNT}.auth0.com/"
export TF_VAR_jwks_uri="https://${AUTH0_ACCOUNT}.auth0.com/.well-known/jwks.json"
export TF_VAR_oauth2_client_id="${AUTH0_CLIENT_ID}"
export TF_VAR_oauth2_client_secret="${AUTH0_CLIENT_SECRET}"

# GCP internal Token Service
export TF_VAR_gcp_oauth2_token_issuer="${GCP_SERVICE_ACCOUNT_EMAIL}"
export TF_VAR_gcp_jwks_uri="https://www.googleapis.com/robot/v1/metadata/x509/${GCP_SERVICE_ACCOUNT_ADDRESS}"
