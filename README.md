# Distributed Order Processing Platform

A Spring Boot event-driven order platform demonstrating Saga orchestration, Transactional Outbox, idempotent Kafka consumers, retries/DLQ, PostgreSQL persistence, Apache Ignite caching, and observability.

## Architecture
- Order Service: accepts orders and orchestrates the Saga.
- Payment Service: reserves payment and publishes payment events.
- Inventory Service: reserves inventory and publishes inventory events.
- Kafka: asynchronous commands/events.
- PostgreSQL: durable service data and outbox records.
- Apache Ignite: hot product/inventory cache.
- Prometheus/Grafana: operational visibility.

## Saga
Order -> Payment Reserve -> Inventory Reserve -> Order Confirmed.
Failures publish compensating commands and move failed messages to retry/DLQ topics.

## Run
```bash
docker compose up -d
mvn spring-boot:run
```

Create an order:
```bash
curl -X POST http://localhost:8080/api/orders -H 'Content-Type: application/json' -d '{"customerId":"c-1","productId":"p-1","quantity":2,"amount":1200}'
```

The implementation focuses on correctness patterns and failure handling rather than unmeasured benchmark claims.
