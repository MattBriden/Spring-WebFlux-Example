package com.briden.flux.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Animal {

    @Id
    private String id;

    private String name;

    private String kingdom;
}
