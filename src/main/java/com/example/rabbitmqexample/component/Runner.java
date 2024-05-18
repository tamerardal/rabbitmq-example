package com.example.rabbitmqexample.component;

import com.example.rabbitmqexample.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message...");

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,
                "foo.bar.baz",
                "Application started!");

        receiver.getLatch().await(10000L, TimeUnit.MILLISECONDS);
        log.info("Message sent!");
    }
}
