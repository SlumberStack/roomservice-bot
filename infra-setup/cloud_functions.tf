data "archive_file" "package" {
  type        = "zip"
  source_file = "${var.function_path}/${var.function_filename}"
  output_path = "function-package.zip"
}

resource "google_storage_bucket" "bucket" {
  name = "roomservice-cloud-function-bucket"
}

resource "google_storage_bucket_object" "archive" {
  name   = "${var.function_filename}"
  bucket = google_storage_bucket.bucket.name
  source = data.archive_file.package.output_path
}

resource "google_cloudfunctions_function" "function" {
  name        = "${var.function_name}"
  description = "${var.function_description}"
  runtime     = "java11"

  available_memory_mb   = 128
  source_archive_bucket = google_storage_bucket.bucket.name
  source_archive_object = google_storage_bucket_object.archive.name
  trigger_http          = true
  timeout               = 60
  entry_point           = "${var.function_entry_point}"
}

# IAM entry for a single user to invoke the function
resource "google_cloudfunctions_function_iam_member" "invoker" {
  project        = google_cloudfunctions_function.function.project
  region         = google_cloudfunctions_function.function.region
  cloud_function = google_cloudfunctions_function.function.name

  role   = "roles/cloudfunctions.invoker"
  member = "allUsers"
}
