package com.charishma.order;
import jakarta.persistence.*;import java.util.UUID;
@Entity @Table(name="outbox_events") public class OutboxEvent {
 @Id private UUID id; private String topic; private String eventKey; @Lob private String payload; private boolean published;
 protected OutboxEvent(){}
 public OutboxEvent(String topic,String key,String payload){id=UUID.randomUUID();this.topic=topic;eventKey=key;this.payload=payload;}
 public UUID getId(){return id;} public String getTopic(){return topic;} public String getEventKey(){return eventKey;} public String getPayload(){return payload;} public boolean isPublished(){return published;} public void markPublished(){published=true;}
}