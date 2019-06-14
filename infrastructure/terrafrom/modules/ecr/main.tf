#----------terraform/modules/ecr/main.tf----------
resource "aws_ecr_repository" "repository_name" {
  name = "${var.repository_name}"
}