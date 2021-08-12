package ru.redsquid.examples.ms.order.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Notification {

    private final String phone;

    private final String message;
}
