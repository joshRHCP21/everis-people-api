package com.bank.people.repository;

import com.bank.people.entity.Person;
import io.reactivex.Single;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends RxJava2CrudRepository<Person, String>
{
    Single<Person> findByDocument(String document);
    Single<Boolean> existsByDocument(String name);
}