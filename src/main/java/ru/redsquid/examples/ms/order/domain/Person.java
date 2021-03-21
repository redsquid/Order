package ru.redsquid.examples.ms.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {

    private final String phone;

    private final String firstName;

    private final String lastName;
}
