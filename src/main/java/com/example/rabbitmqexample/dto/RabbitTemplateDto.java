package com.example.rabbitmqexample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RabbitTemplateDto {
    private String exchangeName;
    private String routingKey;
    private String messageBody;
}
