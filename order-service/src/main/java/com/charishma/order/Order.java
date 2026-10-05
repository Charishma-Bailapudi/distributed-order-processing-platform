package com.charishma.order;
import jakarta.persistence.*;import java.math.BigDecimal;import java.util.UUID;
@Entity @Table(name="orders") public class Order{
@Id private UUID id; private String customerId; private String productId; private int quantity; private BigDecimal amount; private String status;
protected Order(){} public Order(String c,String p,int q,BigDecimal a){id=UUID.randomUUID();customerId=c;productId=p;quantity=q;amount=a;status="PENDING";}
public UUID getId(){return id;} public String getCustomerId(){return customerId;} public String getProductId(){return productId;} public int getQuantity(){return quantity;} public BigDecimal getAmount(){return amount;} public String getStatus(){return status;} public void status(String s){status=s;}}