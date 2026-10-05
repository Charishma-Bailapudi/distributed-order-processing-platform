package com.charishma.order;
import org.springframework.context.annotation.*;import org.springframework.kafka.core.*;import org.springframework.kafka.config.TopicBuilder;
@Configuration public class KafkaConfig{
@Bean NewTopic payment(){return TopicBuilder.name("payment.commands").partitions(3).replicas(1).build();}
@Bean NewTopic inventory(){return TopicBuilder.name("inventory.commands").partitions(3).replicas(1).build();}
@Bean NewTopic events(){return TopicBuilder.name("order.events").partitions(3).replicas(1).build();}
}