#----------terraform/modules/ecs_events/variables.tf----------

variable "environment" {
  description = "The name of the environment"
}

variable "cluster" {
  default     = "default"
  description = "The name of the ECS cluster"
}
