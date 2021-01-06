package com.bank.people.controller;

import com.bank.people.config.exception.NotFoundException;
import com.bank.people.dto.PersonResponse;
import com.bank.people.service.PersonService;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/core/persons")
public class PersonController
{
    @Autowired
    private final PersonService personService;

    @GetMapping()
    public Single<PersonResponse> getPersonByDocument(@RequestParam(name = "documentNumber") String document)
    {
        return personService.getPersonResponseByDocument(document);
    }
}
