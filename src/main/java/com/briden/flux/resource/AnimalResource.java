package com.briden.flux.resource;

import com.briden.flux.entity.Animal;
import lombok.Data;

@Data
public class AnimalResource {

    private String id;

    private String name;

    private String kingdom;

    public AnimalResource(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.kingdom = animal.getKingdom();
    }

}
