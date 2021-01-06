package com.bank.people.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person
{
    @Id
    private String id;
    private String document;
    private String name;
    private String lastName;
    private String Sex;
    private boolean fingerprint;
    private boolean blacklist;
}
