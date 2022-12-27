package com.google.invocke.presentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.invocke.application.PrintInvoice;
import com.google.invocke.domin.Invoice;
import com.google.invocke.infrastructure.entity.InvoiceEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final PrintInvoice printInvoice;

    @Operation(summary = "this is first test of swagger")
    @ApiResponses(value =
            {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "404", description = "not found",content = @Content)
            })
    @PostMapping
    public void saveInvoice(@Validated @RequestBody InvoiceEntity invoice) {
        printInvoice.sendMessage(invoice);
    }
}
