package com.bank.people.service;

import com.bank.people.dto.PersonResponse;
import com.bank.people.entity.Person;
import io.reactivex.Single;

public interface PersonService
{
    Single<Person> create(Person person);
    Single<Person> getByDocument(String document);
    Single<Long> count();
    Single<PersonResponse> getPersonResponseByDocument(String document);
}
