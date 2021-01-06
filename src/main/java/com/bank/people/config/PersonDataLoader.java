package com.bank.people.config;

import com.bank.people.entity.Person;
import com.bank.people.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
public class PersonDataLoader implements ApplicationRunner
{
    @Autowired
    private PersonService service;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        if(service.count().blockingGet() == 0L)
        {
            Person person1 = new Person(null, "73431156", "Jose", "Alvino Velaque", "M", true, false);
            Person person2 = new Person(null, "10000000", "Rosa", "Rosales Martinez", "F", true, false);
            Person person3 = new Person(null, "45785521", "Maria", "Defani Romero", "F", false, false);

            List<Person> peopleToStore = Arrays.asList(person1, person2, person3);

            peopleToStore.forEach(person -> service.create(person).subscribe());
        }
    }
}
