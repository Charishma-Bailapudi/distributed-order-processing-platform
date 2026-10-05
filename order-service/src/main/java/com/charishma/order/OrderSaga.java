package com.charishma.order;
import org.springframework.kafka.core.KafkaTemplate;import org.springframework.stereotype.Service;
@Service public class OrderSaga{
private final KafkaTemplate<String,Object> kafka;
public OrderSaga(KafkaTemplate<String,Object> k){kafka=k;}
public void start(Order o){kafka.send("payment.commands",o.getId().toString(),new Command(o.getId().toString(),o.getAmount(),"RESERVE"));}
public record Command(String orderId,java.math.BigDecimal amount,String action){} }