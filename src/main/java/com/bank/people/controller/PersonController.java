package com.bank.people.controller;

import com.bank.people.config.exception.NotFoundException;
import com.bank.people.dto.PersonResponse;
import com.bank.people.service.PersonService;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/core/persons")
@Api("/core/persons")
public class PersonController
{
    @Autowired
    private final PersonService personService;

    @GetMapping()
    @ApiOperation(value = "Find person by Document Number", notes = "Retrieving a Person Class", response = PersonResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = PersonResponse.class)
    })
    public Single<PersonResponse> getPersonByDocument(@RequestParam(name = "documentNumber") String document)
    {
        return personService.getPersonResponseByDocument(document);
    }
}
