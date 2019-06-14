vpc_cidr = "10.0.0.0/16"

environment = "acc"

public_subnet_cidrs = ["10.0.0.0/24", "10.0.1.0/24", "10.0.2.0/24"]

private_subnet_cidrs = ["10.0.50.0/24", "10.0.51.0/24", "10.0.52.0/24"]

availability_zones = ["eu-west-1a", "eu-west-1b", "eu-west-1c"]

max_size = 2

min_size = 1

desired_capacity = 1

instance_type = "t2.micro"

ecs_aws_ami = "ami-95f8d2f3"

repository_name = "production"