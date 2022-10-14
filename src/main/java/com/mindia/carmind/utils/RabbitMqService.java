package com.mindia.carmind.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqService {
  public static final String TOPIC_EXCHANGE_NAME = "carmind";

  public static final String NOTIFICACION_TESTING_QUEUE = "back-testing";
  public static final String NOTIFICACION = "back.notification.zone";

  @Bean
  Queue notificationTestingQueue() {
    return new Queue(NOTIFICACION_TESTING_QUEUE, false, false,true);
  }

  @Bean
  Queue notificationQueue() {
    return new Queue(NOTIFICACION, false, false,true);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange(TOPIC_EXCHANGE_NAME);
  }

  @Bean
  Binding binding(Queue notificationTestingQueue, TopicExchange exchange) {
    return BindingBuilder.bind(notificationTestingQueue).to(exchange).with("back.notification.test.#");
  }

  @Bean
  Binding bindinNnotificationQueue(Queue notificationQueue, TopicExchange exchange) {
    return BindingBuilder.bind(notificationQueue).to(exchange).with("notification.zone.back.preparing");
  }


  @Bean
  public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
    final var rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
