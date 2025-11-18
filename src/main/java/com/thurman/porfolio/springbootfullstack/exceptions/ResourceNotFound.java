package com.thurman.porfolio.springbootfullstack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

//    String prompt = """
//                Based on the programming stack %s that %s has \s
//                given provide a full training path and recommendations for this person\s
//               \s""".formatted(
//            softwareEngineer.getTechStack()
//            ,softwareEngineer.getName());
    public ResourceNotFound(String message) {
        super(message);
    }
}
