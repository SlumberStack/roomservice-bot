


resource "google_dialogflow_agent" "roomservice_agent" {
  display_name = "roomservice_agent"
  default_language_code = "en"
  supported_language_codes = ["fr","de","es"]
  time_zone = "America/New_York"
  description = "RoomService Agent"
  avatar_uri = "https://cloud.google.com/_static/images/cloud/icons/favicons/onecloud/super_cloud.png"
  enable_logging = true
  match_mode = "MATCH_MODE_HYBRID"
  classification_threshold = 0.3
  api_version = "API_VERSION_V2"
  tier = "TIER_STANDARD"
}
