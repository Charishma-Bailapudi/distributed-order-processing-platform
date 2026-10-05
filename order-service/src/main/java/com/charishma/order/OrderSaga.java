package com.charishma.order;
import com.fasterxml.jackson.databind.ObjectMapper;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;
@Service public class OrderSaga{
 private final OutboxRepository outbox; private final ObjectMapper mapper;
 public OrderSaga(OutboxRepository o,ObjectMapper m){outbox=o;mapper=m;}
 @Transactional public void start(Order o){try{Command c=new Command(o.getId().toString(),o.getAmount(),"RESERVE");outbox.save(new OutboxEvent("payment.commands",o.getId().toString(),mapper.writeValueAsString(c)));}catch(Exception e){throw new IllegalStateException("Unable to create outbox event",e);}}
 public record Command(String orderId,java.math.BigDecimal amount,String action){} }