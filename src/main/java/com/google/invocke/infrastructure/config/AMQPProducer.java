package com.google.invocke.infrastructure.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.invocke.infrastructure.entity.InvoiceEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class AMQPProducer {
    private final AmqpTemplate amqpTemplate;

    @Value("${javaInuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javaInuse.rabbitmq.routingKey}")
    private String routingKey;

    public void publishMessage(InvoiceEntity invoice) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(invoice);
        amqpTemplate.convertAndSend(exchange, routingKey, json);
    }
}
