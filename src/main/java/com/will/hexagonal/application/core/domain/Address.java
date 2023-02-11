package com.will.hexagonal.application.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address {

    private String street;

    private String city;

    private String state;
}
