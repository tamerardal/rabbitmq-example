package com.example.rabbitmqexample.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {
    private static final Logger logger = LogManager.getLogger(Receiver.class);

    private final CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) throws InterruptedException {
        logger.info("Received message: {}", message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
