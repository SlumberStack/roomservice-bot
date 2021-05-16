export TF_VAR_org_id=""
export TF_VAR_billing_account=
export TF_ADMIN=${USER}-terraform-admin
export TF_VAR_project_name="${TF_ADMIN}"

export TF_CREDS=~/.config/gcloud/${USER}-terraform-admin.json


export GOOGLE_APPLICATION_CREDENTIALS=${TF_CREDS}
export GOOGLE_PROJECT=${TF_ADMIN}

export AUTH0_ACCOUNT=
export TF_VAR_oauth2_token_issuer="https://${AUTH0_ACCOUNT}.auth0.com/"
export TF_VAR_jwks_uri="https://${AUTH0_ACCOUNT}.auth0.com/.well-known/jwks.json"
export TF_VAR_oauth2_client_id=
export TF_VAR_oauth2_client_secret=
