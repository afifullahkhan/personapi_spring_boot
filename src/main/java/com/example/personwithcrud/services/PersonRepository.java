package com.example.personwithcrud.services;

import com.example.personwithcrud.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, Integer> {

}

