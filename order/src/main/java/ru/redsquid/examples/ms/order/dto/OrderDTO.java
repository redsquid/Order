package ru.redsquid.examples.ms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Set;

@ToString
@Data
@NoArgsConstructor
public class OrderDTO {

    private String name;

    private String phone;

    private Set<Long> items;

    @NotNull
    private Boolean notification;
}
