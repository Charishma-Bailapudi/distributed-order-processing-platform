package com.charishma.order;
import org.springframework.web.bind.annotation.*;import java.math.BigDecimal;
@RestController @RequestMapping("/api/orders") public class OrderController{
private final OrderRepository repo; private final OrderSaga saga;
public OrderController(OrderRepository r,OrderSaga s){repo=r;saga=s;}
@PostMapping public Order create(@RequestBody Request x){Order o=repo.save(new Order(x.customerId(),x.productId(),x.quantity(),x.amount()));saga.start(o);return o;}
record Request(String customerId,String productId,int quantity,BigDecimal amount){} }