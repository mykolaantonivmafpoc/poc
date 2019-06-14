#----------terraform/modules/ecs/outputs.tf----------

output "default_alb_target_group" {
  value = "${module.alb.default_alb_target_group}"
}
