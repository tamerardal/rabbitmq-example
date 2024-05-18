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
- [RabbitMQ Docker](#RabbitMQwithDocker)
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
- Gradle 3.6.0 or later
- RabbitMQ server running locally on default port 5672

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/rabbitmq-example.git
    cd rabbitmq-example
    ```

2. Build the project using Gradle:

    ```bash
    gradle clean build
    ```

## Usage

1. Run the Spring Boot application:

    ```bash
    gradle bootRun
    ```

2. The application will send a message to the RabbitMQ exchange and log the received message.

## Configuration

The configuration for RabbitMQ is located in the `RabbitmqExampleApplication` class. By default, the application uses the following settings:

- **Exchange Name:** `spring-boot-exchange`
- **Queue Name:** `spring-boot`
- **Routing Key:** `foo.bar.#`

You can modify these settings in the `RabbitmqExampleApplication` class as needed.

# RabbitMQ with Docker

This guide explains how to set up and run RabbitMQ using Docker and Docker Compose.

## Prerequisites

Ensure you have Docker and Docker Compose installed on your system. You can download them from the following links:
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Docker Compose Configuration

Your `docker-compose.yml` file should contain the following configuration:

```yaml
version: '2'

services:
  rabbitmq:
    image: rabbitmq:management
    ports:
      - "5672:5672"
      - "15672:15672"
```

## RabbitMQ Management Console
After starting the RabbitMQ service, you can access the RabbitMQ management console through your web browser:

- URL: http://localhost:15672
- Default username: guest
- Default password: guest
- This management console allows you to monitor and manage the RabbitMQ server.

# Contributing
Contributions are always welcome! Please feel free to submit a Pull Request.

# Contact
If you have any questions or feedback, please contact me at [tamerardaal@gmail.com]. 
