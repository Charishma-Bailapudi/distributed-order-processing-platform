package com.charishma.order;
import org.junit.jupiter.api.Test;import java.math.BigDecimal;import static org.junit.jupiter.api.Assertions.*;
class OrderTest{@Test void createsPendingOrder(){Order o=new Order("c","p",2,BigDecimal.TEN);assertNotNull(o.getId());assertEquals("PENDING",o.getStatus());}}