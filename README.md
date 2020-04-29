# zookeeper & Kafka docker container deployment using docker compose single cluster setup in windows environment

# Kafka Docker

To deploy zookeeper and Kafka single node cluster using apache kafka or confluent version of kafka.

Follow below step to setup:

1) Download docker desktop
https://hub.docker.com/editions/community/docker-ce-desktop-windows

verify docker --version

# To use Apache Kafka

cd apachekafka

docker-compose up -d

docker ps

# To use Confluent Kafka

cd confluent

docker-compose up -d

docker ps

# To Create topic
docker run -it --rm confluentinc/cp-kafka:5.2.1 kafka-topics  --zookeeper localhost:2181 --create --topic test --partitions 2 --replication-factor 1

# To test Producer & Consumer - Java Maven Project

producer and consumer - maven project