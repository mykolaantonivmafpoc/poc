#----------terraform/modules/ecs_instances/outputs.tf----------

output "ecs_instance_security_group_id" {
  value = "${aws_security_group.instance.id}"
}
