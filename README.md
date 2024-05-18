# Creating a README.md file with the provided content

readme_content = """
# RabbitMQ Example Application

This is a simple Spring Boot application demonstrating the usage of RabbitMQ for messaging.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Introduction

This application showcases a basic example of sending and receiving messages using RabbitMQ with Spring Boot. The application sends a message to a RabbitMQ exchange and listens to a queue for incoming messages.

## Features

- Send messages to RabbitMQ.
- Receive and process messages from RabbitMQ.
- Configurable RabbitMQ exchange and queue.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or later
- Maven 3.6.0 or later
- RabbitMQ server running locally on default port 5672

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/rabbitmq-example.git
    cd rabbitmq-example
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage

1. Start the RabbitMQ server if it is not already running. You can download and install RabbitMQ from [here](https://www.rabbitmq.com/download.html).

2. Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

3. The application will send a message to the RabbitMQ exchange and log the received message.

## Configuration

The configuration for RabbitMQ is located in the `RabbitmqExampleApplication` class. By default, the application uses the following settings:

- **Exchange Name:** `spring-boot-exchange`
- **Queue Name:** `spring-boot`
- **Routing Key:** `foo.bar.#`

You can modify these settings in the `RabbitmqExampleApplication` class as needed.

### Example Code Snippets

#### RabbitmqExampleApplication

```java
@SpringBootApplication
public class RabbitmqExampleApplication {
    public static final String topicExchangeName = "spring-boot-exchange";
    public static final String queueName = "spring-boot";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receive");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RabbitmqExampleApplication.class, args).close();
    }
}
