package com.google.invocke.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.invocke.application.PrintInvoice;
import com.google.invocke.domin.Invoice;
import com.google.invocke.infrastructure.entity.InvoiceEntity;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final PrintInvoice printInvoice;

    @PostMapping
    public void saveInvoice(@Validated @RequestBody InvoiceEntity invoice) {
        printInvoice.sendMessage(invoice);
    }
}
