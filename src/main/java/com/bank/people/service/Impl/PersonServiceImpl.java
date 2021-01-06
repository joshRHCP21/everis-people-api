package com.bank.people.service.Impl;

import com.bank.people.config.exception.NotFoundException;
import com.bank.people.dto.PersonResponse;
import com.bank.people.entity.Person;
import com.bank.people.repository.PersonRepository;
import com.bank.people.service.PersonService;
import io.reactivex.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService
{
    @Autowired
    PersonRepository repository;

    @Override
    public Single<Person> create(Person person)
    {
        return repository.save(person);
    }

    @Override
    public Single<Person> getByDocument(String document)
    {
        return repository.findByDocument(document);
    }

    @Override
    public Single<Long> count()
    {
        return repository.count();
    }

    @Override
    public Single getPersonResponseByDocument(String document)
    {
        try
        {   return repository.existsByDocument(document)
                    .flatMap(exists -> {
                        if(Boolean.TRUE.equals(exists))
                            return getByDocument(document)
                                    .map( person ->
                                            new PersonResponse(  person.getId(), person.getDocument(), person.isFingerprint(),  person.isBlacklist()) );
                        else
                            log.error("Person not found. Invalid document : "+document);
                            return Single.just(new NotFoundException("Invalid document : " + document));
                    });
        }
        catch (Exception e)
        {
            return Single.error(new RuntimeException(e.getMessage()));
        }
    }
}
