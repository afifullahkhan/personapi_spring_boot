package com.example.personwithcrud.controller;

import com.example.personwithcrud.model.Person;
import com.example.personwithcrud.services.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("save")
    public Person savePerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping()
    public @ResponseBody Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Person> getAllPersons(@PathVariable int id) {
        return personRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) {
        Person updatedPerson = personRepository.findById(id).
                orElseThrow();
        updatedPerson.setName(person.getName());
        return personRepository.save(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void delPerson(@PathVariable int id) {
         personRepository.deleteById(id);
    }
}