

provider "google" {
  region = var.region
}

data "google_projects" "my-org-projects" {
  filter = "name:${var.project_name}"
}

data "google_project" "project" {
  project_id = data.google_projects.my-org-projects.projects[0].project_id
}

resource "random_id" "id" {
  byte_length = 4
  prefix      = data.google_project.project.project_id
}

resource "google_project_service" "service" {
  for_each = toset([
    "compute.googleapis.com",
    "apigateway.googleapis.com",
    "dialogflow.googleapis.com",
    "cloudfunctions.googleapis.com",
    "cloudbuild.googleapis.com",
    "cloudbilling.googleapis.com"
  ])

  service = each.key

  project            = data.google_project.project.project_id
  disable_on_destroy = false
}

output "project_id" {
  value = data.google_project.project.project_id
}
