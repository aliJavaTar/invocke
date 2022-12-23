package com.google.invocke.application;

import com.google.invocke.infrastructure.entity.InvoiceEntity;

public interface PrintInvoice {
    void sendMessage(InvoiceEntity invoice);
}
