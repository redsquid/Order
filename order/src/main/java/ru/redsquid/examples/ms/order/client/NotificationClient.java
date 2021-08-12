package ru.redsquid.examples.ms.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification")
public interface NotificationClient {

    @PostMapping(path = "/ms/notification")
    String sendSms(@RequestBody Notification dto);

}
