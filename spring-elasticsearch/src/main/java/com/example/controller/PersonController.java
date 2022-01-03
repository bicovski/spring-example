package com.example.controller;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {


    private final PersonRepository personRepository;

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setName("Mucahit");
        person.setSurname("Gunhan");
        person.setAddress("Gaziosmanpasa/Istanbul");
        person.setBirthDate(Calendar.getInstance().getTime());
        person.setId("23");
        personRepository.save(person);

        person = new Person();
        person.setName("Mehmet");
        person.setSurname("Yilmaz");
        person.setAddress("Bayrampasa/Istanbul");
        person.setBirthDate(Calendar.getInstance().getTime());
        person.setId("31");
        personRepository.save(person);

    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search ){
        List<Person> persons = personRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(persons);
    }


}
