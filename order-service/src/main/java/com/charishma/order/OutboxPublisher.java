package com.charishma.order;
import org.springframework.kafka.core.KafkaTemplate;import org.springframework.scheduling.annotation.Scheduled;import org.springframework.stereotype.Component;
@Component public class OutboxPublisher {
 private final OutboxRepository repo; private final KafkaTemplate<String,String> kafka;
 public OutboxPublisher(OutboxRepository r,KafkaTemplate<String,String> k){repo=r;kafka=k;}
 @Scheduled(fixedDelay=1000) public void publish(){for(OutboxEvent e:repo.findTop100ByPublishedFalseOrderById()){try{kafka.send(e.getTopic(),e.getEventKey(),e.getPayload()).get();e.markPublished();repo.save(e);}catch(Exception ignored){}}}
}