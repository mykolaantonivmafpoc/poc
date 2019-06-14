#----------terraform/modules/ecr/outputs.tf----------
output "tf_ecr.repository_url" {
value ="${aws_ecr_repository.repository_name.repository_url}"
}