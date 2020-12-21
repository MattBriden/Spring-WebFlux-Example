package com.briden.flux.repository;

import com.briden.flux.entity.Animal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IAnimalRepository extends ReactiveCrudRepository<Animal, String> {
}
