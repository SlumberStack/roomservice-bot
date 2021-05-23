resource "google_api_gateway_api" "api_gw" {
  provider = google-beta
  api_id = "api-gw"
}

resource "google_api_gateway_api_config" "api_gw" {
  provider = google-beta
  api = google_api_gateway_api.api_gw.api_id
  api_config_id = "config"

  openapi_documents {
    document {
      path = "spec.yaml"
      contents = base64encode(templatefile("api-spec.tpl",
        {
          function_endpoint = google_cloudfunctions_function.function.https_trigger_url,
          CLIENT_ID = "",
          JWKS_URI = var.gcp_jwks_uri,
          TOKEN_ISSUER = var.gcp_oauth2_token_issuer
          }
          ))
    }
  }
  lifecycle {
    create_before_destroy = false
  }
}

resource "google_api_gateway_gateway" "api_gw" {
  provider = google-beta
  region = var.region
  api_config = google_api_gateway_api_config.api_gw.id
  gateway_id = "api-gw"
}
