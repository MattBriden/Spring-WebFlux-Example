package com.briden.flux;

import com.briden.flux.controller.AnimalController;
import com.briden.flux.entity.Animal;
import com.briden.flux.repository.IAnimalRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(AnimalController.class)
@RunWith(SpringRunner.class)
public class AnimalControllerTests {

    @MockBean
    private IAnimalRepository animalRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void testFindAllAnimals() {
        List<Animal> animals = Arrays.asList(new Animal(), new Animal());
        when(animalRepository.findAll()).thenReturn(Flux.fromIterable(animals));

        webClient.get().uri("/api/animal")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Animal.class);

        verify(animalRepository, times(1)).findAll();
    }
}
