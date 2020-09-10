#docker --version && docker build -t spring-tdd . && docker tag spring-tdd:latest 156790592858.dkr.ecr.us-west-2.amazonaws.com/spring-tdd:latest && docker images
docker --version && docker build -t 156790592858.dkr.ecr.us-west-2.amazonaws.com/spring-tdd:latest . && docker push 156790592858.dkr.ecr.us-west-2.amazonaws.com/spring-tdd:latest && docker images
