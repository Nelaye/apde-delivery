package fr.univlorraine.apdedelivery.message;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    public Queue queue() {
        return new Queue("delivery");
    }

    @Profile("receiver")
    @Bean
    public Receiver receiver() {
        return new Receiver();
    }
}
