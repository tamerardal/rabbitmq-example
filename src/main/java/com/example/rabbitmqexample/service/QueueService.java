package com.example.rabbitmqexample.service;

import com.example.rabbitmqexample.dto.RabbitTemplateDto;

public interface QueueService {
    RabbitTemplateDto send(String message);
}
