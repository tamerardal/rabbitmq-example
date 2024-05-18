package com.example.rabbitmqexample.service.impl;

import com.example.rabbitmqexample.component.Receiver;
import com.example.rabbitmqexample.config.RabbitConfig;
import com.example.rabbitmqexample.dto.RabbitTemplateDto;
import com.example.rabbitmqexample.service.QueueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueServiceImpl implements QueueService {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @Override
    public RabbitTemplateDto send(String message) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, "foo.bar.baz", message);

        return RabbitTemplateDto.builder()
                .exchangeName(RabbitConfig.EXCHANGE)
                .routingKey("foo.bar.baz")
                .messageBody(message)
                .build();
    }
}
