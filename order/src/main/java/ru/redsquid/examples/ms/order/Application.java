package ru.redsquid.examples.ms.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import ru.redsquid.examples.ms.order.client.NotificationClient;

@SpringBootApplication(scanBasePackages = "ru.redsquid.examples.ms.order")
@PropertySource(value = "classpath:application.yml")
@RefreshScope
@EnableFeignClients(clients = NotificationClient.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
