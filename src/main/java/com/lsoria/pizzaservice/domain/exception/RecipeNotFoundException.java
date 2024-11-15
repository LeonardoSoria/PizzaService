package com.lsoria.pizzaservice.domain.exception;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(String message) {
        super(message);
    }

}
