package com.example.rabbitmqexample.component;

import com.example.rabbitmqexample.RabbitmqExampleApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Runner implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(Runner.class);

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Sending message...");

        rabbitTemplate.convertAndSend(RabbitmqExampleApplication.topicExchangeName,
                "foo.bar.baz",
                "Hello from RabbitMQ!");

        receiver.getLatch().await(10000L, TimeUnit.MILLISECONDS);
        logger.info("Message sent!");
    }
}
