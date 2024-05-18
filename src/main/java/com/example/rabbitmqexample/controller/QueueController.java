package com.example.rabbitmqexample.controller;

import com.example.rabbitmqexample.dto.RabbitTemplateDto;
import com.example.rabbitmqexample.service.QueueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class QueueController {
    private final QueueService service;

    @PostMapping()
    public RabbitTemplateDto sendMessage(@RequestParam String message) {
        return service.send(message);
    }
}
