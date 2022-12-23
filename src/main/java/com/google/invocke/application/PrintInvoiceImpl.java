package com.google.invocke.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.invocke.infrastructure.config.AMQPProducer;
import com.google.invocke.infrastructure.entity.InvoiceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrintInvoiceImpl implements PrintInvoice {
    private final AMQPProducer producer;

    public void sendMessage(InvoiceEntity invoice) {
        send(invoice);
    }

    private void send(InvoiceEntity invoice) {
        try {
            producer.publishMessage(invoice);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
