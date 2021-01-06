package com.bank.people.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonResponse
{
    private String id;
    private String document;
    private boolean fingerprint;
    private boolean blacklist;
}
