package com.charishma.payment;
import org.springframework.kafka.annotation.KafkaListener;import org.springframework.kafka.core.KafkaTemplate;import org.springframework.stereotype.Service;
@Service public class PaymentConsumer{
private final KafkaTemplate<String,Object> kafka; public PaymentConsumer(KafkaTemplate<String,Object> k){kafka=k;}
@KafkaListener(topics="payment.commands",groupId="payment-service")
public void reserve(Command c){if("RESERVE".equals(c.action()))kafka.send("inventory.commands",c.orderId(),c);}
public record Command(String orderId,java.math.BigDecimal amount,String action){} }