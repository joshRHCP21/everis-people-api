package com.bank.people.config.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NotFoundException extends RuntimeException
{
    public NotFoundException()
    {
        super("Not Found");
    }

    public NotFoundException(String  message)
    {
        super("Not found: " + message);
    }
}
