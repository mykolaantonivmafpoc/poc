#----------terraform/modules/nat_gateway/outputs.tf----------

output "ids" {
  value = ["${aws_nat_gateway.nat.*.id}"]
}
