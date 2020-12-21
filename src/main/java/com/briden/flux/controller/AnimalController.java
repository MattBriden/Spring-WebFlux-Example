package com.briden.flux.controller;

import com.briden.flux.repository.IAnimalRepository;
import com.briden.flux.resource.AnimalResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private IAnimalRepository animalRepository;

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<AnimalResource> findAll() {
        return animalRepository.findAll()
                .map(AnimalResource::new)
                .delayElements(Duration.ofSeconds(1L));
    }
}
