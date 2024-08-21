package br.com.ebac.animal_service.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.repository.AnimalRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    public List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    public List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/cats")
    public List<Animal> findCats() {
        return repository.findCats();
    }

    @GetMapping("/dogs")
    public List<Animal> findDogs() {
        return repository.findDogs();
    }

    @GetMapping("/contagem")
    public List<Map<String, Object>> getRescueCountByEmployee(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                              @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        LocalDate startLocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        if (endLocalDate.isAfter(startLocalDate.plusYears(1))) {
            throw new IllegalArgumentException("O intervalo máximo entre as datas é de um ano.");
        }

        List<Object[]> results = repository.countAnimalsRescuedByEmployeeBetweenDates(startDate, endDate);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> employeeCount = new HashMap<>();
            employeeCount.put("nomeRecebedor", result[0]);
            employeeCount.put("quantidadeResgatada", result[1]);
            response.add(employeeCount);
        }

        return response;
    }
}
