package com.tiagopaulin.curso.services.exceptions;

import java.util.Objects;
import java.util.Optional;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id: " + id);
    }

}
