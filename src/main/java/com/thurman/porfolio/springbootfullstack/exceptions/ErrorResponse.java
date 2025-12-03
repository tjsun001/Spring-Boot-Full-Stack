package com.thurman.porfolio.springbootfullstack.exceptions;

import java.time.Instant;

public record ErrorResponse(
        String message,
        String error,
        int statusCode,
        String path,
        Instant timestamp,

        java.util.Map<String, String> fieldErrors) {
}
